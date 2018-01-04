package cn.mylava._300._5_Socket._195_httpserver._7_reflect;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Date;

/**
 * comment:封装响应信息
 *
 * @author: lipengfei
 * @date: 2017/12/26
 */
public class MyResponse {

    //换行
    public static final String CRLF = "\r\n";
    public static final String BLANK = " ";
    //存储头信息
    private StringBuilder headInfo;
    //存储正文长度
    private long len;
    //正文
    private StringBuilder content;
    //输出流，用于推送消息到客户端
    private BufferedWriter bw;

    public MyResponse() {
        this.headInfo = new StringBuilder();
        this.len = 0;
        this.content = new StringBuilder();
    }

    public MyResponse(Socket client) {
        this();
        try {
            bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        } catch (IOException e) {
            headInfo = null;
            e.printStackTrace();
        }
    }

    public MyResponse(OutputStream os) {
        this();
        bw = new BufferedWriter(new OutputStreamWriter(os));
    }

    /**
     * 构建响应头
     */
    private void createHeadInfo(int code) {
        //http协议版本、状态码、描述
        headInfo.append("HTTP/1.1").append(BLANK).append(code).append(BLANK);
        switch (code) {
            case 200:
                headInfo.append("OK");
                break;
            case 404:
                headInfo.append("NOT Found");
                break;
            case 500:
                headInfo.append("INTERNAL ERROR");
                break;
        }

        headInfo.append(CRLF);
        //响应头 MyServer:Apache Tomcat/6.0.12
        headInfo.append("MyServer:myServer myTomcat/0.0.1").append(CRLF)
                .append("Date:").append(new Date()).append(CRLF)
                //常见类型 text/html(超文本类型);text/plain(普通文本类型);application/octet-stream(流，下载用)
                .append("Content-type:text/html;charset=UTF-8").append(CRLF);
        headInfo.append(CRLF);
    }

    /**
     * 构建正文
     *
     * @param txt
     * @return
     */
    public MyResponse buildContent(String txt) {
        content.append(txt);
        len += txt.getBytes().length;
        return this;
    }

    /**
     * 结束正文
     *
     * @return
     */
    public MyResponse completeContent() {
        content.append(CRLF);
        len += CRLF.getBytes().length;
        return this;
    }

    /**
     * 发送消息到客户端
     *
     * @param code
     */
    public void pushToClient(int code) throws IOException {
        if (null == headInfo) {
            code = 500;
        }
        createHeadInfo(code);
        bw.append(headInfo.toString());
        if (code == 200) {
            bw.append(content.toString());
        } else {
            bw.append("出错了，错误码为：" + code);
        }
        bw.flush();
    }

    public void println(String txt) {
        buildContent(txt);
        completeContent();
    }


    public void close() {
        CloseUtil.closeAll(bw);
    }
}
