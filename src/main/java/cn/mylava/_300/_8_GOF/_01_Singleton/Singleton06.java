package cn.mylava._300._8_GOF._01_Singleton;

import java.io.*;
import java.lang.reflect.Constructor;

/**
 * comment: 防止反射和反序列化生成新对象
 * 通过在构造方法中抛出异常避免
 * @author: lipengfei
 * @date: 16/01/2018
 */
public class Singleton06 implements Serializable{
    private static Singleton06 instance = new Singleton06();
    private Singleton06() {
        //防止反射生成新对象
        if (instance!=null) {
            throw new RuntimeException("不能创建实例！");
        }
    }
    //防止反序列化生成新的对象
    private Object readResolve() throws ObjectStreamException{
        return instance;
    }


    //线程安全，调用效率高
    public static Singleton06 getInstance() {
        return instance;
    }

    public static void main(String[] args) throws Exception {
        Singleton06 s1 = Singleton06.getInstance();
        Singleton06 s2 = Singleton06.getInstance();
        System.out.println(s1==s2);
        /**
         * --------------- ---------------
         * 反射生成新的对象
         * --------------- ---------------
         */
        Class<?> clazz = Class.forName("cn.mylava._300._8_GOF._01_Singleton.Singleton06");
        Constructor<?> constructor = clazz.getDeclaredConstructor(null);
        //跳过权限检察
        constructor.setAccessible(true);
//        System.out.println(constructor.newInstance()==s1);

        /**
         * --------------- ---------------
         * 反序列化生成新的对象
         * --------------- ---------------
         */
        FileOutputStream fos = new FileOutputStream("/Users/lipengfei/Desktop/test.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(s1);
        oos.close();
        fos.getClass();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/Users/lipengfei/Desktop/test.txt"));
        Singleton06 s4 = (Singleton06) ois.readObject();
        System.out.println(s4==s1);
    }
}
