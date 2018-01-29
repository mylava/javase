package cn.mylava._300._8_GOF._06_Proxy.dynamicProxy;

import java.lang.reflect.Proxy;

/**
 * comment: JDK内置Proxy类实现动态代理
 *
 * @author: lipengfei
 * @date: 22/01/2018
 */
public class Client {
    public static void main(String[] args) {
        StarHandler handler = new StarHandler(new RealStar());

        Star proxy = (Star) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{Star.class}, handler);

        proxy.confer();
        proxy.signContract();
        proxy.bookTicket();
        proxy.sing();
        proxy.collectMoney();
    }
}
