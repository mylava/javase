package cn.mylava._300._8_GOF._06_Proxy.dynamicProxy.jdkProxy;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Proxy;

/**
 * comment: JDK内置Proxy类实现动态代理
 *
 * @author: lipengfei
 * @date: 22/01/2018
 */
public class Client {
    public static void main(String[] args) throws IOException {
        StarHandler handler = new StarHandler(new RealStar());

        Star proxy = (Star) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{Star.class}, handler);

        proxy.confer();
        proxy.signContract();
        proxy.bookTicket();
        proxy.sing();
        proxy.collectMoney();

        //查看动态生成源码
        byte[] bytes = ProxyGenerator.generateProxyClass("$Star.class", new Class[]{Star.class});
        //Class.getResource
        String path = Client.class.getResource("").getPath()+"$Star.class";
        System.out.println(path);
        FileOutputStream fos = new FileOutputStream(path);

        fos.write(bytes);
        fos.flush();
        fos.close();
    }
}
