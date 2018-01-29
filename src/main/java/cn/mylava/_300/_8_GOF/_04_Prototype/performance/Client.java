package cn.mylava._300._8_GOF._04_Prototype.performance;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 17/01/2018
 */
public class Client {
    
    public static void testNew(int size) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            Laptop t = new Laptop();
        }
        long end = System.currentTimeMillis();
        System.out.println("new的方式创建耗时："+(end-start));
    }

    public static void testClone(int size) throws CloneNotSupportedException {
        Laptop t = new Laptop();
        long start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            Object clone = t.clone();
        }
        long end = System.currentTimeMillis();
        System.out.println("new的方式创建耗时："+(end-start));
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        testNew(1000);
        testClone(1000);
    }
}
