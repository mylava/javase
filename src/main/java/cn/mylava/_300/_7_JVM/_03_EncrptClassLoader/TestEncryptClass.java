package cn.mylava._300._7_JVM._03_EncrptClassLoader;

/**
 * comment: 测试加密类加载器
 *
 * @author: lipengfei
 * @date: 09/01/2018
 */
public class TestEncryptClass {
    public static void main(String[] args) throws ClassNotFoundException {
        //加密后的Class文件，正常的类加载器无法加载，报ClassFormatError

        /*FileClassLoader loader = new FileClassLoader("/Users/lipengfei/Desktop/encrypt");
        Class<?> clazz = loader.loadClass("Test");
        System.out.println(clazz);*/

        //使用加密类加载器，正常加载
        DecryptClassLoader loader = new DecryptClassLoader("/Users/lipengfei/Desktop/encrypt");
        Class<?> clazz = loader.loadClass("Test");
        System.out.println(clazz);
    }
}
