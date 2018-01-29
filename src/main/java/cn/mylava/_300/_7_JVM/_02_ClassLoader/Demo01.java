package cn.mylava._300._7_JVM._02_ClassLoader;

/**
 * comment: 查看ClassLoader
 *
 * @author: lipengfei
 * @date: 08/01/2018
 */
public class Demo01 {
    public static void main(String[] args) {
        //获取当前使用的类加载器 即应用类加载器
        System.out.println(ClassLoader.getSystemClassLoader());
        //扩展类加载器
        System.out.println(ClassLoader.getSystemClassLoader().getParent());
        //启动类加载器 ----> 由原生代码实现，获取不到，所以为null
        System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());

        //获取当前类的classpath
        System.out.println(System.getProperty("java.class.path"));
        //扩展路径
        System.out.println(System.getProperty("java.ext.dirs"));

    }
}
