package cn.mylava._300._5_Socket._190_chatroom._3_multiServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * 多线程服务端，同时处理多个连接请求
 * @author lipengfei
 */
public class Server {
    private List<MyChannel> all = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        new Server().start();
    }

    public void start() throws IOException {
        ServerSocket server = new ServerSocket(9999);

        while (true) {
            Socket client = server.accept();

            MyChannel channel = new MyChannel(client);
            all.add(channel);
            new Thread(channel).start();
        }
    }

    /**
     * 一个客户端一条单独通道
     */
    private class MyChannel implements Runnable {
        private DataInputStream dis;
        private DataOutputStream dos;
        private boolean isRunning=true;

        public MyChannel() {
        }

        /**
         * 构造方法
         * @param client
         */
        public MyChannel(Socket client) {
            try {
                this.dis = new DataInputStream(client.getInputStream());
                this.dos = new DataOutputStream(client.getOutputStream());
            } catch (IOException e) {
                isRunning = false;
                CloseUtil.closeAll(dos,dis);
                all.remove(this);
            }
        }

        /**
         * 接收数据
         * @return
         */
        private String receive() {
            try {
                //阻塞当前线程
                return dis.readUTF();
            } catch (IOException e) {
                isRunning = false;
                CloseUtil.closeAll(dos,dis);
                all.remove(this);
            }
            return "";
        }

        /**
         * 发送数据给当前客户端
         * @param msg
         */
        private void send(String msg) {
            try {
                if (null != msg || !"".equals(msg)) {
                    dos.writeUTF(msg);
                    dos.flush();
                }
            } catch (IOException e) {
                isRunning = false;
                CloseUtil.closeAll(dos,dis);
                //谁调用移除谁
                all.remove(this);
            }
        }

        /**
         * 发送给所有客户端
         * @param msg
         */
        private void sendAll(String msg) {
            for (MyChannel other:all) {
                //不发送给自己
                if (other == this) {
                    continue;
                }
                other.send(msg);
            }
        }


        @Override
        public void run() {
            while (isRunning) {
               sendAll(receive());
            }
        }
    }
}
