package cn.mylava._300._8_GOF._15_Strategy.amount3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.SortedMap;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 23/03/2018
 */
public class StrategyProxy implements InvocationHandler {
    private SortedMap<Integer,Class<? extends Strategy>> clazzMap;

    private StrategyProxy(SortedMap<Integer, Class<? extends Strategy>> clazzMap) {
        this.clazzMap = clazzMap;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Double result = 0d;
        if (method.getName().equals("getPrice")) {
            for (Class<? extends Strategy> clazz : clazzMap.values()) {
                if (result==0) {
                    result = (Double) method.invoke(clazz.newInstance(),args);
                } else {
                    result = (Double) method.invoke(clazz.newInstance(),result);
                }
            }
        }
        return result;
    }

    public static Strategy getProxy(SortedMap<Integer,Class<? extends Strategy>> clazzMap) {
        return (Strategy) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),new Class[]{Strategy.class},new StrategyProxy(clazzMap));
    }
}
