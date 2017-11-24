package cn.mylava._300._5_Socket._190_chatroom._3_multiServer;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 用于接收数据的对象----不变
 *
 * @author lipengfei
 */
public class Receive implements Runnable {
    private DataInputStream dis;
    private boolean isRunning = true;

    public Receive() {
    }

    public Receive(Socket client) {
        try {
            this.dis = new DataInputStream(client.getInputStream());
        } catch (IOException e) {
            isRunning = false;
            CloseUtil.closeAll(dis);
            e.printStackTrace();
        }
    }

    public String receive() {
        try {
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
            System.out.println("接收到--->" + receive());
        }
    }
}
