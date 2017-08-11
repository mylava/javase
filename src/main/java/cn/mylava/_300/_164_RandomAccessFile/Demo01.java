package cn.mylava._300._164_RandomAccessFile;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 文件的分割与合并
 *
 * 思路：
 * 1.块数 n
 * 2.每块的大小 blocksize
 *          前n-1块：blocksize
 *          最后一块： size % blocksize
 * 3.每块的名称 及 顺序
 * 4.分割
 *
 * @author lipengfei
 */
public class Demo01 {
    public static void main(String[] args) throws IOException {
        String src = "/Users/lipengfei/Desktop/startzk.txt";
        RandomAccessFile ra = new RandomAccessFile(new File(src),"r");
        ra.seek(100);

        byte[] flush = new byte[1024];
        int len = 0;

        while (-1 != (len=ra.read(flush))) {
            System.out.println(new String(flush,0,len));
        }

        ra.close();
    }
}
