package cn.mylava._300._5_Socket._190_chatroom._2_multiClient;

import java.io.*;
import java.net.Socket;

/**
 * 用于接收数据的对象
 *
 * @author lipengfei
 */
public class Receive implements Runnable {
    private DataInputStream dis;
    private boolean isRunning = true;

    public Receive() {
    }

    //创建线程时，从client中获取输入流
    public Receive(Socket client) {
        try {
            this.dis = new DataInputStream(client.getInputStream());
        } catch (IOException e) {
            isRunning = false;
            CloseUtil.closeAll(dis);
            e.printStackTrace();
        }
    }

    //使用client的输入流，获取接收到的数据
    public String receive() {
        try {
            //线程阻塞，一致等待接收数据
            return dis.readUTF();
        } catch (IOException e) {
            isRunning = false;
            CloseUtil.closeAll(dis);
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public void run() {
        while (isRunning) {
            System.out.println(1);
            System.out.println("接收到--->" + receive());
        }
    }
}
