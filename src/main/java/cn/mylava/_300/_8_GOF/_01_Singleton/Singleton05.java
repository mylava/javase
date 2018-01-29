package cn.mylava._300._8_GOF._01_Singleton;

/**
 * comment: 线程安全，调用效率高，不能延时加载。
 * 可以天然的防止反射和反序列化漏洞(因为枚举式基于JVM底层来实现的)
 *
 * @author: lipengfei
 * @date: 16/01/2018
 */
enum SomeThing {
    INSTANCE;
    private Singleton05 instance;
    SomeThing() {
        instance = new Singleton05();
    }
    public Singleton05 getInstance() {
        return instance;
    }

}

public class Singleton05 {
}