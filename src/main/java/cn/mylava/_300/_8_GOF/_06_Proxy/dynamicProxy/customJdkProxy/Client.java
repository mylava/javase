package cn.mylava._300._8_GOF._06_Proxy.dynamicProxy.customJdkProxy;

import cn.mylava._300._8_GOF._06_Proxy.dynamicProxy.customJdkProxy.myjdk.MyClassLoader;
import cn.mylava._300._8_GOF._06_Proxy.dynamicProxy.customJdkProxy.myjdk.MyProxy;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 19/03/2018
 */
public class Client {

    public static void main(String[] args) throws ClassNotFoundException {
        RealStar realStar = new RealStar();
        StarHandler handler = new StarHandler(realStar);

        Class<?>[] interfaces = realStar.getClass().getInterfaces();
        for (Class clazz : interfaces) {
            System.out.println(clazz.getName());
        }
        Star proxy = (Star) MyProxy.newProxyInstance(new MyClassLoader(), realStar.getClass().getInterfaces(), handler);


        proxy.confer();
        proxy.signContract();
        proxy.bookTicket();
        proxy.sing();
        proxy.collectMoney();


        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        contextClassLoader.loadClass("");
        System.out.println(contextClassLoader);
    }

}
