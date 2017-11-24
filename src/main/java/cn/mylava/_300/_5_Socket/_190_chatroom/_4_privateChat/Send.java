package cn.mylava._300._5_Socket._190_chatroom._4_privateChat;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 用于发送数据的对象----不变
 * @author lipengfei
 */
public class Send implements Runnable {
    private BufferedReader console;
    private DataOutputStream dos;
    //线程是否正常运行
    private boolean isRunning = true;
    //当前用户的名称-->一个用户对应一个线程，所以这里直接把用户名绑定在线程上
    private String name;

    public Send() {
        console = new BufferedReader(new InputStreamReader(System.in));
    }

    //在初始化时就将用户名发送给服务器
    public Send(Socket client, String name) {
        this();
        try {
            this.dos = new DataOutputStream(client.getOutputStream());
            this.name = name;
            send(this.name);
        } catch (IOException e) {
            //初始化出现异常时，线程不能继续，要关闭资源
            isRunning = false;
            CloseUtil.closeAll(dos,console);
            e.printStackTrace();
        }
    }

    private String getMsgFromConsole() {
        try {
            return console.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public void send(String msg) {

        try {
            if (null!=msg && !"".equals(msg)) {
                dos.writeUTF(msg);
                dos.flush();
            }
        } catch (IOException e) {
            //写数据出现异常，就说明通道有问题，线程就没用了，可以直接关掉
            isRunning = false;
            CloseUtil.closeAll(dos,console);
        }

    }

    @Override
    public void run() {
        while (isRunning) {
            send(getMsgFromConsole());
        }
    }
}
