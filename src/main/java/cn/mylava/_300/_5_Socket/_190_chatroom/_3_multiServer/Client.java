package cn.mylava._300._5_Socket._190_chatroom._3_multiServer;

import java.io.IOException;
import java.net.Socket;

/**
 * 多线程版客户端，实现了同时收发信息。----不变
 * @author lipengfei
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost",9999);

        new Thread(new Send(client)).start();
        new Thread(new Receive(client)).start();

    }
}
