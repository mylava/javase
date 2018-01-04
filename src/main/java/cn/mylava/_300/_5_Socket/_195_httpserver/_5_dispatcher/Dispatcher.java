package cn.mylava._300._5_Socket._195_httpserver._5_dispatcher;

import java.io.IOException;
import java.net.Socket;

/**
 * comment: 分发器（其实只是对线程的封装，分发功能在下一节才实现）
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
        MyServlet servlet = new MyServlet();
        servlet.service(request, response);

        //处理完成推送200
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
