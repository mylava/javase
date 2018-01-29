package cn.mylava._300._8_GOF._01_Singleton;

/**
 * comment: 双重检测
 * 由于编译器优化原因和JVM底层内部模型原因，偶尔会出问题，不建议使用
 *
 * @author: lipengfei
 * @date: 16/01/2018
 */
public class Singleton03 {
    private static Singleton03 instance = null;

    private Singleton03() {
    }

    public static Singleton03 getInstance() {
        if (instance==null) {
            synchronized (Singleton03.class) {
                if (instance==null) {
                    instance = new Singleton03();
                }
            }
        }
        return instance;
    }
}
