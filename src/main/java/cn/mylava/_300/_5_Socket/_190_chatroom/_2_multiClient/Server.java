package cn.mylava._300._5_Socket._190_chatroom._2_multiClient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 单线程聊天室服务端，只能处理完一个客户端，待客户端断开连接之后，处理另外一个客户端
 * @author lipengfei
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(9999);

        while (true) {
            Socket client = server.accept();
            DataInputStream dis = new DataInputStream(client.getInputStream());
            DataOutputStream dos = new DataOutputStream(client.getOutputStream());

            while (true) {
                String msg = dis.readUTF();

                dos.writeUTF("服务器--->" + msg);
                dos.flush();
            }
        }
    }
}
