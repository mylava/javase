package cn.mylava._300._143_File;

import java.io.File;
import java.io.IOException;

/**
 * Java中获取当前目录的所有方法
 * @author lipengfei
 */
public class FilePath {
    public static void main(String[] args) throws IOException {
        //1.利用System.getProperty()函数获取当前路径 --> 只能取到工程的根目录
        System.out.println("user.dir\t-->\t"+System.getProperty("user.dir"));

        //2.使用File提供的函数获取当前路径：
        File directory = new File("");//设定为当前文件夹
        //对于getCanonicalPath()函数，“."就表示当前的文件夹，而”..“则表示当前文件夹的上一级文件夹
        System.out.println("\nCanonicalPath\t-->\t"+directory.getCanonicalPath());//获取标-->准的路径
        //对于getAbsolutePath()函数，则不管”.”、“..”,返回当前的路径加上你在new File()时设定的路径,即 对于getAbsolutePath = getPath + 当前路径
        System.out.println("AbsolutePath\t-->\t"+directory.getAbsolutePath());//获取绝对路径
        //至于getPath()函数，得到的只是你在new File()时设定的路径
        System.out.println("Path\t-->\t"+directory.getPath());

        //3.使用getResource()
        System.out.println("\nclass.getResource(\"/\")\t-->\t"+FilePath.class.getResource("/"));
        //path不能以“/”开头时，是从ClassPath根下获取，等价于 class.getResource("/")
        System.out.println("class.getClassLoader().getResource(\"\")\t-->\t"+FilePath.class.getClassLoader().getResource(""));
        System.out.println("class.getClassLoader().getResource(\"/\")\t-->\t"+FilePath.class.getClassLoader().getResource("/"));

        //4.servlet/jsp获取路径
        //得到包含工程名的当前页面全路径：request.getRequestURI()               -->  /TEST/test.jsp
        //得到工程名：request.getContextPath()                                -->  /TEST
        //得到当前页面所在目录下全名称：request.getServletPath()                -->  /TEST/jsp/test.jsp
        //得到页面所在服务器的全路径：application.getRealPath("test.jsp")       -->  D:/resin/webapps/TEST/test.jsp

    }
}
