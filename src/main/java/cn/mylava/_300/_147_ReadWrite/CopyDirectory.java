package cn.mylava._300._147_ReadWrite;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * 拷贝文件夹
 * @author lipengfei
 */
public class CopyDirectory {
    public static void main(String[] args) {
        String src = "/Users/lipengfei/Desktop/logs";
        String dest = "/Users/lipengfei/Desktop/logs/logsback";
        try {
            copyDirectory(src,dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copyDirectory(File src, File dest) throws IOException {
        if (src.exists()) {
            if (src.isFile()) {
                CopyFile.copyFile(src, dest);
            } else if (src.isDirectory()) {
                if (dest.exists()) {
                    System.out.println("文件夹已经存在，确定要覆盖吗（Y/N）？");
                    Scanner scanner = new Scanner(System.in);
                    String goOn = scanner.nextLine();
                    if ("Y".equals(goOn)){
                        //需要提供操作系统的权限
                        boolean result = dest.delete();
                    }
                }

                if (dest.getAbsolutePath().contains(src.getAbsolutePath())) {
                    System.out.println("父目录不能拷贝到子目录中！");
                    return;
                }
                dest.mkdirs();
                for (File sub:src.listFiles()) {
                    //注意第二个参数：使用dest作为相对路径
                    copyDirectory(sub,new File(dest,sub.getName()));
                }
            }
        } else {
            throw new FileNotFoundException("源文件(夹)不存在！");
        }
    }

    public static void copyDirectory(String srcPath, String destPath) throws IOException {
        copyDirectory(new File(srcPath),new File(destPath));
    }
}
