package cn.mylava._300._5_Socket._195_httpserver._5_dispatcher;

import java.io.Closeable;
import java.io.IOException;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 2017/12/27
 */
public class CloseUtil {
    public static void closeAll(Closeable... ios) {
        for (Closeable tmp:ios) {
            if (null!=tmp) {
                try {
                    tmp.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}