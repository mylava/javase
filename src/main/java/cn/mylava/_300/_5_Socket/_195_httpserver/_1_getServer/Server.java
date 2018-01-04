package cn.mylava._300._5_Socket._195_httpserver._1_getServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * comment: 创建服务器，并启动
 * 可以在网页访问，只能读取到get类型的数据
 *
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
            StringBuilder sb = new StringBuilder();
            String msg = null;
            BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
            while ((msg = br.readLine()).length()>0) {
                System.out.println("1==="+msg.length());
                sb.append(msg);
                sb.append("\r\n");
            }

            String requestInfo = sb.toString().trim();
            System.out.println(sb.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void stop() {

    }
}
