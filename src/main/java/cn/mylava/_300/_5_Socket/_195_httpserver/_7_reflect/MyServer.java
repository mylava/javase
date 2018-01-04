package cn.mylava._300._5_Socket._195_httpserver._7_reflect;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * comment: 创建服务器，并启动   205讲
 * 区别于6 ：1.将ServletContext中存储Servlet类型改为字符串类型，通过反射获取具体Servlet
 *          2.将ServletContext内容配置改为通过xml配置，添加sax读取xml功能
 *          3.将Servlet父类方法改为protected，只有子类能够访问
 *
 * @author: lipengfei
 * @date: 2017/12/25
 */
public class MyServer {

    private ServerSocket server;
    //换行
    public static final String CRLF = "\r\n";
    public static final String BLANK = " ";

    private boolean isShutdown = false;

    public static void main(String[] args) {
        MyServer server = new MyServer();
        server.start();
    }

    /**
     * 启动服务器 默认端口
     */
    public void start() {
        start(8888);
    }

    /**
     * 启动服务器 可以指定端口
     */
    public void start(int port) {
        try {
            server = new ServerSocket(port);
            this.receive();
        } catch (IOException e) {
            e.printStackTrace();
            stop();
        }

    }

    /**
     * 接收客户端
     */
    private void receive() {
        try {
            while (!isShutdown) {
                Dispatcher dispatcher = new Dispatcher(server.accept());
                new Thread(dispatcher).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
            //创建线程失败，关闭服务器
            stop();
        }
    }

    /**
     * 停止服务器
     */
    public void stop() {
        isShutdown = true;
        CloseUtil.closeAll(server);
    }
}
