package cn.mylava._300._5_Socket._186_URL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * 统一资源定位符
 * @author lipengfei
 */
public class URLDemo {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://www.baidu.com:80/index.html?uname=test");

        System.out.println("协议："+url.getProtocol());
        System.out.println("域名："+url.getHost());
        System.out.println("端口："+url.getPort());
        System.out.println("资源："+url.getFile());
        System.out.println("相对路径资源："+url.getPath());
        System.out.println("参数："+url.getQuery());
        System.out.println(url.toString());

        //获取网络资源流
        //乱码，改用转换流（可以设置编解码格式）
        /*InputStream is = url.openStream();
        int length=0;
        byte[] flush = new byte[1024];
        while (-1!=(length=is.read(flush))) {
            System.out.println(new String(flush,0,length));
        }*/


        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(),"gb2312"));
        String msg=null;
        while (null!=(msg=reader.readLine())) {
            System.out.println(msg);
        }
        reader.close();
    }
}
