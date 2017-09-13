package cn.mylava._300._3_IO._160_CloseResource;

import java.io.Closeable;
import java.io.IOException;

/**
 * 通用关闭流的实现
 * @author lipengfei
 */
public class Close {
    /**
     * 可变参数只能位于最后一个参数位置
     * @param ios
     * @throws IOException
     */
    public static void close(Closeable ... ios) throws IOException {
        for (Closeable tmp:ios) {
            if (null!=tmp) {
                tmp.close();
            }
        }
    }

    /**
     * 使用泛型
     * @param ts
     * @param <T>
     * @throws IOException
     */
    public static <T extends Closeable> void closeT(T ... ts) throws IOException {
        for (Closeable tmp:ts) {
            if (null!=tmp) {
                tmp.close();
            }
        }
    }


}
