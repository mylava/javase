package cn.mylava._300._4_Thread._179_DoubleCheck;

/**
 * @author lipengfei
 */
public class SingletonLazyLoad {

}

/**
 * 饿汉单例   缺点：不能延迟加载
 */
class Singleton1 {
    //静态变量，在ClassLoader首次加载类的时候初始化,所以是线程安全的
    private static Singleton1 instance = new Singleton1();
    private Singleton1() {
    }

    public static Singleton1 getInstance() {
        return instance;
    }
}

/**
 * 优化饿汉单例
 * 使用到的特性：
 * 1.静态属性在类被初始化的时候就被初始化，方法在调用时候才初始化
 * 2.外部类被调用时，内部类不一定被调用
 */
class Singleton2 {
    //类在使用的时候才会被加载(即加载 Singleton2 不一定加载 InstanceHolder)，隐藏到内部类中，延时加载
    private static class InstanceHolder {
        //内部类可以直接调用外部类方法
        private static Singleton2 instance = new Singleton2();
    }
    private Singleton2() {
    }

    //只有在调用getInstance方法时，才会调用内部类对象，这时才加载内部类，实现了延迟加载
    public static Singleton2 getInstance() {
        //直接访问内部类的静态变量
        return InstanceHolder.instance;
    }


}