package cn.mylava._300._5_Socket._189_TCP;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 可以与多个客户端通信，但是对客户端请求只能处理完一个在处理另一个
 * @author lipengfei
 */
public class MultiServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(9999);

        while (true) {
            //一个accept 一个客户端
            Socket client = server.accept();
            System.out.println("一个客户端简历连接");
            String msg = "欢迎！";
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream(), "utf-8"));
            bw.write(msg);
            bw.newLine();
            bw.flush();

            //单线程，处理完一个才能接受另外一个，如果这里阻塞，新客户端就不能建立连接了
            while (true) {

            }

        }
    }
}
