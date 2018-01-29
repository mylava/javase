package cn.mylava._300._8_GOF._01_Singleton;

/**
 * comment: 懒汉式单例
 *
 * @author: lipengfei
 * @date: 09/01/2018
 */
public class Singleton02 {
    //类初始化时，不初始化这个对象（延时加载，真正使用时候在创建）
    private static Singleton02 instance;

    private Singleton02() {
    }

    //方法同步，调用效率低
    public static synchronized Singleton02 getInstance() {
        if (instance==null) {
            instance = new Singleton02();
        }
        return instance;
    }

}