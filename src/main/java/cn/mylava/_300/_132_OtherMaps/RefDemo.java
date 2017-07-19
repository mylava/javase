package cn.mylava._300._132_OtherMaps;

import java.lang.ref.WeakReference;

/**
 * Java中的引用分为：强引用、软引用、弱引用、虚引用
 * StrongReference：引用指向对象，gc运行时不回收
 * SoftReference：gc运行时可能回收（jvm内存不够）
 * WeakReference：gc运行时立即回收
 * PhantomReference：类似于无引用，主要用于跟踪对象被回收的状态，必须和ReferenceQueue联合使用
 * 这里演示强引用个弱引用的区别
 * @author lipengfei
 */
public class RefDemo {
    public static void main(String[] args) {
        strongRef();
        weakRef();
    }

    //强引用类型对象测试
    public static void strongRef() {
        //存储在字符串常量池中,共享的（不能回收）
        String string = "hello world";
        //使用弱引用来管理对象
        WeakReference<String> wr = new WeakReference<String>(string);
        System.out.println("strongRef(),gc运行前" + wr.get());
        //断开引用
        string = null;
        //通知回收
        System.gc();
        System.runFinalization();
        //强引用对象不会被回收
        System.out.println("strongRef(),gc运行后" + wr.get());
    }

    //弱引用类型对象测试
    public static void weakRef() {
        //字符串存储在堆内存中
        String string = new String("hello world");
        //使用弱引用来管理对象
        WeakReference<String> wr = new WeakReference<String>(string);
        System.out.println("weakRef(),gc运行前" + wr.get());
        //断开引用
        string = null;
        //通知回收
        System.gc();
        System.runFinalization();
        //发现对象被回收
        System.out.println("weakRef(),gc运行后" + wr.get());
    }
}
