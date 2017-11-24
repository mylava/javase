package cn.mylava._300._5_Socket._190_chatroom._3_multiServer;

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

    public Send() {
        console = new BufferedReader(new InputStreamReader(System.in));
    }

    public Send(Socket client) {
        this();
        try {
            this.dos = new DataOutputStream(client.getOutputStream());
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

    public void send() {
        String msg = getMsgFromConsole();

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
            send();
        }
    }
}
