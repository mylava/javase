package cn.mylava._300._8_GOF._06_Proxy.dynamicProxy.customJdkProxy.myjdk;

import java.lang.reflect.Method;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 19/03/2018
 */
public interface MyInvocationHandler {
    public Object invoke(Object proxy, Method method,Object[] args) throws Throwable;
}
