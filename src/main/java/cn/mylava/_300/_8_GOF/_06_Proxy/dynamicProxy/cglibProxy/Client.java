package cn.mylava._300._8_GOF._06_Proxy.dynamicProxy.cglibProxy;



/**
 * comment: cgLib实现动态代理
 *
 * @author: lipengfei
 * @date: 22/01/2018
 */
public class Client {
    public static void main(String[] args) throws Exception {
        RealStar proxy = (RealStar) new StarInterceptor().getInstance(RealStar.class);
        System.out.println(proxy.getClass());
        proxy.sing();
    }
}
