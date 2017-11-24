package cn.mylava._300._5_Socket._189_TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 客户端，交互完毕就结束
 * 1.创建
 * 2.接收数据
 * @author lipengfei
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost",9999);

        BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
//        String line = null;
//        while (null!=(line=br.readLine())) {
//            System.out.println(line);
//        }
        System.out.println(br.readLine()); //阻塞式方法

    }
}
