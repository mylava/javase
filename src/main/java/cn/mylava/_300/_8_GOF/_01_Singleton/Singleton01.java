package cn.mylava._300._8_GOF._01_Singleton;

/**
 * comment: 饿汉单例 ---- 类初始化时候，立即加载这个对象
 * 1.私有化构造器
 * 2.私有化静态对象
 * 3.提供访问入口(静态方法)
 *
 * @author: lipengfei
 * @date: 09/01/2018
 */
public class Singleton01 {

    //类初始化时立即加载这个对象(如果运行期没有用到此对象，就浪费资源了),类加载器在加载的时候是天然的线程安全的
    private static Singleton01 instance = new Singleton01();
    private Singleton01() {
    }

    //线程安全，调用效率高
    public static Singleton01 getInstance() {
        return instance;
    }

}
