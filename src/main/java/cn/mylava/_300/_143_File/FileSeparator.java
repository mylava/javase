package cn.mylava._300._143_FileSeparator;

import java.io.File;

/**
 * @author lipengfei
 */
public class Demo {
    public static void main(String[] args) {
        //路径分隔符
        System.out.println(File.pathSeparator);
        //名称分隔符
        System.out.println(File.separator);

        //当前的默认路径
        System.out.println(System.getProperty("user.dir"));

        File file = new File("test.txt");
        System.out.println(file.exists());
    }
}
