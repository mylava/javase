package cn.mylava._300._5_Socket._190_chatroom._4_privateChat;

import java.io.Closeable;
import java.io.IOException;

/**
 * ----不变
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
