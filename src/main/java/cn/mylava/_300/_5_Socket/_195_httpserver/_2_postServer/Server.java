package cn.mylava._300._5_Socket._195_httpserver._2_postServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * comment: 创建服务器，并启动
 * 区别于1 ： 能够接收到post类型的数据
 * @author: lipengfei
 * @date: 2017/12/25
 */
public class Server {

    private ServerSocket server;
    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }

    public void start() {
        try {
            server = new ServerSocket(8888);
            this.receive();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void receive() {
        try {
            Socket client = server.accept();
            byte[] data = new byte[20480];
            int len = client.getInputStream().read(data);

            System.out.println(len);
            String requestInfo = new String(data,0,len).trim();
            System.out.println(requestInfo);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void stop() {

    }
}
