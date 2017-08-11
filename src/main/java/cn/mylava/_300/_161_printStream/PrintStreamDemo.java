package cn.mylava._300._161_printStream;

import java.io.*;
import java.util.Scanner;

/**
 * 打印流
 * @author lipengfei
 */
public class PrintStreamDemo {
    public static void main(String[] args) throws IOException {
        //System.out就是一个PrintStream类型的对象引用
        PrintStream ps = System.out;
        ps.println("test");

        //printStream写入文件
        String src = "/Users/lipengfei/Desktop/print.txt";
        ps = new PrintStream(new BufferedOutputStream(
                new FileOutputStream(new File(src))
            ),true);

        ps.println("hello,world");
        ps.close();


        //Scanner从文件中读取
//        Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(new FileInputStream(new File(src)));
        System.out.println(sc.nextLine());

        //修改System.out的目的地址
        System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(new File(src))),true));
        System.out.println("hi,java");

        //还原标准输出
        System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(FileDescriptor.out)),true));
        System.out.println("i am back");

        //BufferedReader作为Scanner
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入：");
        System.out.println(br.readLine());
    }
}
