package cn.mylava._300._164_RandomAccessFile;

import cn.mylava._300._160_CloseResource.Close;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lipengfei
 */
public class SplitFile {
    //源文件路径
    private String filePath;
    //源文件名称
    private String fileName;
    //源文件大小
    private long length;
    //每块大小
    private long blockSize;
    //块数
    private int amount;
    //每块的名称
    private List<String> blockPath;
    //源文件
    private File src;

    //初始化设定默认值
    public SplitFile() {
        this.blockPath = new ArrayList<>();
    }
    //设置不指定blockSize时默认为1024
    public SplitFile(String filePath) {
        /*
         * 添加可以指定blockSize的构造函数后，重构
        this.filePath = filePath;
        this.blockSize = 1024;
        */
        this(filePath,1024);
        //添加默认构造函数后重构---->直接放入默认构造器中
        //this.blockPath = new ArrayList<>();
    }
    //可以指定blockSize
    public SplitFile(String filePath, long blockSize) {
        //这个可以省略，会隐式调用
        this();
        this.filePath = filePath;
        this.blockSize = blockSize;
        init();
    }

    /**
     * 初始化操作：计算块数、确定文件名
     */
    public void init() {
        //检查源文件是否存在，如果不存在直接返回 ----> 健壮性
        if (null==filePath||!((src=new File(filePath)).exists())) {
            throw new RuntimeException("源文件不存在！");
        }
        if (src.isDirectory())
            throw new RuntimeException("文件夹不能分割！");
        this.fileName = src.getName();
        this.length = src.length();

        //开始计算块数
        long length = src.length();
        //如果块的大小大于文件大小，修正每块的大小
        if (this.blockSize>length) {
            this.blockSize = length;
        }
        //计算块数  java中整数相除结果为int，可能会为0，如 1/2结果就为0 ，乘以1.0将第一个数值隐式提升为double类型，得到double类型结果
        this.amount = (int) Math.ceil(length*1.0/this.blockSize); //Math.ceil获取不小于参数的最小整数，结果为double类型，强转为int
    }
    //初始化分割后的文件名
    /*private void initPathName(String destPath) {
        for (int i = 0; i < this.amount; i++) {
            this.blockPath.add(destPath+"/"+this.fileName+".part"+i);
        }
    }*/

    public void split(String destPath) {
        long beginPos = 0;
        long actualBlockSize = blockSize;
        for (int i = 0; i < amount; i++) {
            //生成分割后的文件名
            this.blockPath.add(destPath+"/"+this.fileName+".part"+i);
            //计算最后一块大小
            if (i==amount-1) {
                actualBlockSize = length-beginPos;
            }
            splitDetail(i, beginPos,actualBlockSize);
            beginPos += actualBlockSize;
        }
    }

    private void splitDetail(int idx, long beginPos, long actualBlockSize) {
        //目标文件
        File dest = new File(blockPath.get(idx));
        //流
        RandomAccessFile raf = null;
        BufferedOutputStream bos = null;
        try {
            raf = new RandomAccessFile(src,"r");
            bos = new BufferedOutputStream(new FileOutputStream(dest));

            raf.seek(beginPos);
            byte[] flush = new byte[1024];
            int len = 0;
            while (-1!=(len=raf.read(flush))) {
                //如果实际大小大于len，直接写出
                if (actualBlockSize-len>=0) {
                    bos.write(flush,0,len);
                    actualBlockSize-=len;
                } else {
                    bos.write(flush,0, (int) actualBlockSize);
                    //最后一次写完跳出循环
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                Close.close(bos,raf);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        SplitFile sf = new SplitFile("/Users/lipengfei/Desktop/startzk.txt",50);
        System.out.println(sf.amount);
        sf.split("/Users/lipengfei/Desktop");
    }

}
