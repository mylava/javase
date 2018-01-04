package cn.mylava._300._5_Socket._195_httpserver._6_myServlet;

import java.io.IOException;
import java.net.Socket;

/**
 * comment: 分发器
 *
 * 将单独属于线程的对象封装起来
 * @author: lipengfei
 * @date: 2017/12/29
 */
public class Dispatcher implements Runnable{
    private Socket client;
    private MyRequest request;
    private MyResponse response;
    private int code=200;

    Dispatcher(Socket client) {
        this.client = client;
        try {
            this.request = new MyRequest(client.getInputStream());
            this.response = new MyResponse(client);
        } catch (IOException e) {
            e.printStackTrace();
            code=500;
            return;
        }
    }
    @Override
    public void run() {
        //真正开始分发，根据url获取具体的servlet
        MyServlet servlet = WebApp.getServlet(request.getUrl());
        if (null==servlet) {
            //找不到对应的处理
            this.code=404;
        } else {
            try {
                servlet.service(request, response);
            } catch (Exception e) {
                e.printStackTrace();
                this.code=500;
            }
        }

        try {
            response.pushToClient(code);
        } catch (IOException e) {
            e.printStackTrace();
            //如果推送失败，尝试在推送一次500
            try {
                response.pushToClient(500);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

        //关闭client，两个读写流自然也就关闭了
        CloseUtil.closeAll(client);
    }
}
