package cn.mylava._300._5_Socket._190_chatroom._4_privateChat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 多线程版客户端，实现了同时收发信息。添加私聊功能
 * @author lipengfei
 */
public class Client {
    public static void main(String[] args) throws IOException {
        System.out.println("请输入名称：");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //阻塞
        String name = br.readLine();
        if (name.equals("")) {
            return;
        }

        Socket client = new Socket("localhost",9999);

        //在创建时就传入姓名
        new Thread(new Send(client,name)).start();
        new Thread(new Receive(client)).start();

    }
}
