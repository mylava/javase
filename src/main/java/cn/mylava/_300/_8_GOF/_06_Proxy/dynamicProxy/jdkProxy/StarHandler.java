package cn.mylava._300._8_GOF._06_Proxy.dynamicProxy.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * comment: InvocationHandler实现类
 *
 * @author: lipengfei
 * @date: 22/01/2018
 */
public class StarHandler implements InvocationHandler {
    //传入真实角色
    private Star realStar;

    public StarHandler(Star realStar) {
        this.realStar = realStar;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if (method.getName().equals("sing")) {
            method.invoke(realStar, args);
        } else if (method.getName().equals("confer")) {
            System.out.println("jdkProxyStar.confer()");
        } else if (method.getName().equals("signContract")) {
            System.out.println("jdkProxyStar.signContract()");
        } else if (method.getName().equals("bookTicket")) {
            System.out.println("jdkProxyStar.bookTicket()");
        } else if (method.getName().equals("collectMoney")) {
            System.out.println("jdkProxyStar.collectMoney()");
        }
        return null;
    }
}
