package cn.mylava._300._8_GOF._06_Proxy.dynamicProxy.cglibProxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 19/03/2018
 */
public class StarInterceptor implements MethodInterceptor{
    public Object getInstance(Class<?> clazz) throws Exception{
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if (method.getName().equals(o.getClass().getMethod("sing",null).getName())) {
            System.out.println("jdkProxyStar.confer()");
            System.out.println("jdkProxyStar.signContract()");
            System.out.println("jdkProxyStar.bookTicket()");
            methodProxy.invokeSuper(o, objects);
            System.out.println("jdkProxyStar.collectMoney()");
        }
        return null;
    }
}
