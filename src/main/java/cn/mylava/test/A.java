package cn.mylava.test;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 19/03/2018
 */
public class A {
    public A() {
        System.out.println("调用A");
    }
}
class B extends A {
    public B() {
        super();
    }

    public static void main(String[] args) {
        B b = new B();
    }
}



