package cn.mylava._300._5_Socket._190_chatroom._1_singThread;

import java.io.*;
import java.net.Socket;

/**
 * 单线程版客户端，因为在同一个线程中，只能先发送信息，后接收信息
 * @author lipengfei
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost",9999);

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        DataInputStream dis = new DataInputStream(client.getInputStream());
        while (true) {
            String msg = console.readLine();

            dos.writeUTF(msg);
            dos.flush();

            String line = dis.readUTF();
            System.out.println(line);
        }
    }
}
