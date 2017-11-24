package cn.mylava._300._5_Socket._190_chatroom._4_privateChat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * 多线程服务端，同时处理多个连接请求，添加私聊功能
 *
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
        //用户名
        private String name;
        private boolean isRunning = true;

        public MyChannel() {
        }

        /**
         * 构造方法
         *
         * @param client
         */
        public MyChannel(Socket client) {
            try {
                this.dis = new DataInputStream(client.getInputStream());
                this.dos = new DataOutputStream(client.getOutputStream());
                this.name = dis.readUTF();
                this.send("欢迎进入聊天室！");
                this.sendAll("[" + this.name + "]进入了聊天室！",true);
            } catch (IOException e) {
                isRunning = false;
                CloseUtil.closeAll(dos, dis);
                all.remove(this);
            }
        }

        /**
         * 接收数据
         *
         * @return
         */
        private String receive() {
            try {
                return dis.readUTF();
            } catch (IOException e) {
                isRunning = false;
                CloseUtil.closeAll(dos, dis);
                all.remove(this);
            }
            return "";
        }

        /**
         * 发送数据给当前客户端(自己)
         *
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
                CloseUtil.closeAll(dos, dis);
                //谁调用移除谁
                all.remove(this);
            }

        }

        /**
         * 发送给所有客户端
         * sys 是否为系统信息
         * @param msg
         */
        private void sendAll(String msg,boolean sys) {
            //私聊 [@ + name + :]为私聊
            if (msg.startsWith("@") && msg.contains(":")) {
                String name = msg.substring(1,msg.indexOf(":"));
                String content = msg.substring(msg.indexOf(":")+1);
                for (MyChannel other : all) {
                    //不发送给自己
                    if (other.name.equals(name)) {
                        other.send(this.name+"对你说："+content);
                    }
                }
            } else {//群聊
                for (MyChannel other : all) {
                    //不发送给自己
                    if (other == this) {
                        continue;
                    }
                    if (sys){
                        other.send("[系统信息]"+msg);
                    } else {
                        other.send(this.name + "对所有人说：" + msg);
                    }
                }
            }
        }


        @Override
        public void run() {
            while (isRunning) {
                sendAll(receive(), false);
            }
        }
    }
}
