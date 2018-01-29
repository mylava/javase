package cn.mylava._300._8_GOF._01_Singleton;

/**
 * comment: 静态内部类
 * 兼备调用效率和线程安全
 *
 * @author: lipengfei
 * @date: 16/01/2018
 */
public class Singleton04 {
    //静态内部类，只有在在使用时才会被加载、初始化
    private static class InnerClass {
        private static final Singleton04 instance = new Singleton04();
    }

    private Singleton04() {
    }

    public static Singleton04 getInstance() {
        return InnerClass.instance;
    }
}
