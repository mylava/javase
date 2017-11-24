package cn.mylava._300._5_Socket._190_chatroom._2_multiClient;

import java.io.Closeable;
import java.io.IOException;

/**
 * @author lipengfei
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
