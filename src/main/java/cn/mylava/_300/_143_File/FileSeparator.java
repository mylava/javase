package cn.mylava._300._143_File;

import java.io.File;

/**
 * Java不同文件系统中分隔符不一样
 * @author lipengfei
 */
public class FileSeparator {
    public static void main(String[] args) {
        //路径分隔符
        System.out.println(File.pathSeparator);
        //名称分隔符
        System.out.println(File.separator);
    }
}
