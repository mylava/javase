package cn.mylava._300._5_Socket._195_httpserver._4_oopServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * comment: 创建服务器，并启动
 * 区别于3 ：将Request和Response抽象出来
 * @author: lipengfei
 * @date: 2017/12/25
 */
public class MyServer {

    private ServerSocket server;
    //换行
    public static final String CRLF="\r\n";
    public static final String BLANK=" ";
    public static void main(String[] args) {
        MyServer server = new MyServer();
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

            MyRequest request = new MyRequest(client.getInputStream());
            MyResponse response = new MyResponse(client);
            response.buildContent("<html><body>");
            response.buildContent("欢迎："+request.decode(request.getParameter("name"),"utf-8")+"<br/>爱好是："+request.getParameter("box"));
            response.buildContent("</body></html>");
            response.completeContent();

//            response.pushToClient(404);
            response.pushToClient(200);
            response.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void stop() {

    }
}
