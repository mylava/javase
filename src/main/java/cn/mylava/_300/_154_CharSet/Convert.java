package cn.mylava._300._154_CharSet;

import java.io.*;

/**
 * 使用转换流复制文件，演示乱码
 * 1.输入流 InputStreamReader 解码 （二进制-->字符）
 * 2.输出流 OutputStreamWriter 编码  （字符-->二进制）
 * @author lipengfei
 */
public class Convert {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(
                //通过 InputStreamReader 将字节流转为字符流，同时指定解码集
                new InputStreamReader(new FileInputStream("/Users/lipengfei/Desktop/startzk.txt"),"utf-8"));

        BufferedWriter bw = new BufferedWriter(
                //通过OutputStreamWriter将字符流转为字节流，同时指定编码集
                new OutputStreamWriter(new FileOutputStream("/Users/lipengfei/Desktop/startzk2.txt"),"gbk")
        );


        String line = null;
        while (null!=(line=br.readLine())) {
            System.out.println(line);
            bw.write(line);
            bw.newLine();
        }
        bw.flush();

        bw.close();
        br.close();

    }
}
