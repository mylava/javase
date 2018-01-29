package cn.mylava._300._7_JVM._03_EncrptClassLoader;

import java.io.*;

/**
 * comment: 加密工具类
 *
 * @author: lipengfei
 * @date: 09/01/2018
 */
public class EncryptUtil {
    public static void main(String[] args) {
        encrypt(new File("/Users/lipengfei/Desktop/Test.class"),new File("/Users/lipengfei/Desktop/encrypt/Test.class"));
    }

    public static void encrypt(File src, File dest) {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream(src);
            fos = new FileOutputStream(dest);
            int tmp = -1;
            while ((tmp=fis.read())!= -1) {
                fos.write(tmp^0xff);//取反操作
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos!=null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
