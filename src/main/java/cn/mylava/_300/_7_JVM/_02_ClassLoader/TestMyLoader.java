package cn.mylava._300._7_JVM._02_ClassLoader;

/**
 * comment: 测试自定义类加载器
 *
 * @author: lipengfei
 * @date: 08/01/2018
 */
public class TestMyLoader {
    public static void main(String[] args) throws ClassNotFoundException {
        MyClassLoader classLoader = new MyClassLoader("/Users/lipengfei/Desktop");
        Class<?> clazz1 = classLoader.loadClass("Test");
        Class<?> clazz2 = classLoader.loadClass("Test");

        System.out.println(clazz1.hashCode());
        System.out.println(clazz2.hashCode());


        MyClassLoader classLoader1 = new MyClassLoader("/Users/lipengfei/Desktop");
        Class<?> clazz3 = classLoader1.loadClass("Test");
        System.out.println(clazz3.hashCode());


        Class<?> clazz4 = classLoader1.loadClass("java.lang.String");
        Class<?> clazz5 = classLoader1.loadClass("cn.mylava._300._7_JVM._02_ClassLoader.TestMyLoader");
        System.out.println(clazz3.getClassLoader());
        System.out.println(clazz4.getClassLoader());
        System.out.println(clazz5.getClassLoader());
    }
}
