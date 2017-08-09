package cn.mylava._300._147_ReadWrite;

import java.io.*;

/**
 * 拷贝文件
 *
 * 细分步骤……
 * 文件的读入
 * 1.1.建立联系 --> File对象
 * 1.2.选择流   --> 输入流：InputStream / Reader --> read()
 * 1.3.设置缓冲数组，即每次传输的数据量： byte[] car = new byte[1024]   char[] car = new char[1024];
 * 1.4.释放资源： --> close()
 *
 * 文件的写出
 * 2.1.建立联系 --> File对象
 * 2.2.选择流   --> 输出流：OutputStream / Writer --> write() + flush()
 * 2.3.释放资源： --> close()
 * @author lipengfei
 */
public class CopyFile {
    public static void main(String[] args) throws IOException {

        String src = "/Users/lipengfei/Desktop/startzk.txt";
        String dest = "/Users/lipengfei/Desktop/startzkBak.txt";
        copyFile(src,dest);
    }


    public static void copyFile(String srcPath,String destPath) throws IOException {
        copyFile(new File(srcPath),new File(destPath));
    }

    public static void copyFile(File src,File dest) throws IOException {
        if (!src.exists()) {
            throw new FileNotFoundException("源文件找不到!");
        } else if (src.isDirectory()) {
            //根据需求递归复制，或者抛出异常
            //src.list() 读取子目录
            return;
        }
        if (!dest.exists()) {
            dest.createNewFile();
        }

        FileInputStream is = null;

        FileOutputStream os = null;
        try {
            //1.2
            is = new FileInputStream(src);
            //2.2  false表示覆盖写入，true表示追加
            os = new FileOutputStream(dest,false);
            //1.3  观察输出时，可以将length改小一点
            byte[] car = new byte[1024];
            int len = 0;
            //等于-1表示读取完毕
            while (-1!=(len=is.read(car))) {
                System.out.println(new String(car));
                os.write(car,0,len);
                //观察输出----注意最后管道中的数据并没有刷出
//                Thread.sleep(100);
            }
            //强制将管道中的数据刷出
            os.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("文件不存在");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("读取文件失败");
        } finally {
            try {
                //注意顺序，后打开的先关闭
                if (null!=os) {
                    //2.3
                    os.close();
                }
                if (null!=is) {
                    //1.4
                    is.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("关闭输入流失败");
            }
        }
    }
}
