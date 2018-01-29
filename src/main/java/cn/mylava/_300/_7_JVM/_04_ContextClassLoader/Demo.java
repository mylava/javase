package cn.mylava._300._7_JVM._04_ContextClassLoader;

import cn.mylava._300._7_JVM._03_EncrptClassLoader.FileClassLoader;

/**
 * comment: 演示线程上下文类加载器
 *
 * @author: lipengfei
 * @date: 09/01/2018
 */
public class Demo {

    public static void main(String[] args) {
        ClassLoader loader1 = Demo.class.getClassLoader();
        System.out.println(loader1);

        ClassLoader loader2 = Thread.currentThread().getContextClassLoader();
        System.out.println(loader2);

        Thread.currentThread().setContextClassLoader(new FileClassLoader("/Users/lipengfei/Desktop"));
        System.out.println(Thread.currentThread().getContextClassLoader());
    }
}
