package cn.mylava._300._5_Socket._189_TCP;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 只能交互一次的服务端，交互完毕就结束
 * 1.创建服务器，指定端口
 * 2.接收客户端连接  阻塞
 * 3.发送数据
 * @author lipengfei
 */
public class Server {
    public static void main(String[] args) throws IOException {
        //1
        ServerSocket server = new ServerSocket(9999);
        //2 阻塞式方法
        Socket client = server.accept();
        System.out.println("创建了一个连接");
        //3
        String msg = "欢迎使用！";

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream(),"utf-8"));

        bw.write(msg);
        bw.newLine();
        bw.flush();

    }
}
