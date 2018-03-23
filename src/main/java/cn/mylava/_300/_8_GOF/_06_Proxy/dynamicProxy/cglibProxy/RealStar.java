package cn.mylava._300._8_GOF._06_Proxy.dynamicProxy.cglibProxy;

/**
 * comment: 真实角色
 * cglib代理不需要接口类，因为cglib是动态生成真是对象的子类，之后使用子类代理父类
 *
 * @author: lipengfei
 * @date: 22/01/2018
 */
public class RealStar {

    public void sing() {
        System.out.println("realStar.sing()---->cglib真实对象演唱");
    }

}
