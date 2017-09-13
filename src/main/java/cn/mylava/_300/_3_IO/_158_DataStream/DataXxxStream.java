package cn.mylava._300._3_IO._158_DataStream;

import java.io.*;

/**
 * 基本数据类型读写流
 *
 * @author lipengfei
 */
public class DataXxxStream {

    public static void main(String[] args) throws IOException {
        write("/Users/lipengfei/Desktop/test.txt");
        read("/Users/lipengfei/Desktop/test.txt");
    }

    /**
     * 数据+类型输出到文件
     * @throws IOException
     */
    public static void write(String destPath) throws IOException {
        double point =2.5;
        long num=100L;
        String str ="数据类型";

        //创建源
        File dest =new File(destPath);
        //选择流  DataOutputStream
        DataOutputStream dos =new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(dest)
                )
        );
        //操作 写出的顺序 为读取准备
        dos.writeDouble(point);
        dos.writeLong(num);
        dos.writeUTF(str);
        dos.flush();

        //释放资源
        dos.close();
    }

    public static void read(String srcPath) throws IOException{
        File src = new File(srcPath);
        DataInputStream dis = new DataInputStream(
                new BufferedInputStream(new FileInputStream(src))
        );

        //操作 读取的顺序与写出一致   必须存在才能读取,否则：java.io.EOFException
        //不一致，数据存在问题
        double num1 =dis.readDouble();
        long num2 =dis.readLong();
        String str =dis.readUTF();
        dis.close();
        System.out.println(num2+"--------"+str+"--------"+num1);

    }
}
