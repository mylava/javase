package cn.mylava._300._5_Socket._195_httpserver._3_responseServer;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * comment: 创建服务器，并启动
 * 区别于2 ： 处理请求，并响应
 * @author: lipengfei
 * @date: 2017/12/25
 */
public class Server {

    private ServerSocket server;
    //换行
    public static final String CRLF="\r\n";
    public static final String BLANK=" ";
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
            byte[] data = new byte[20480];
            int len = client.getInputStream().read(data);

            System.out.println(len);
            String requestInfo = new String(data,0,len).trim();
            System.out.println(requestInfo);

            String responseText = new String("<html><body>hello world!</body></html>");

            StringBuilder response = new StringBuilder();
            //http协议版本、状态码、描述
            response.append("HTTP/1.1").append(BLANK).append("404").append(BLANK).append("OK").append(CRLF);
            //响应头 MyServer:Apache Tomcat/6.0.12
            response.append("MyServer:myServer myTomcat/0.0.1").append(CRLF)
                    .append("Date:").append(new Date()).append(CRLF)
                    //常见类型 text/html(超文本类型);text/plain(普通文本类型);application/octet-stream(流，下载用)
                    .append("Content-type:text/html;charset=UTF-8").append(CRLF);
            //正文长度 指的是字节码长度
            response.append("Content-length:").append(responseText.getBytes().length).append(CRLF);
            //正文之前
            response.append(CRLF);
            //正文
            response.append(responseText).append(CRLF);

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            bw.write(response.toString());
            bw.flush();
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void stop() {

    }
}
