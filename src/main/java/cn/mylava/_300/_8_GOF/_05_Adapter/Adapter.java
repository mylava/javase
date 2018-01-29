package cn.mylava._300._8_GOF._05_Adapter;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 22/01/2018
 */
public class Adapter implements Target{
    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void process() {
        System.out.println("我是适配器");
        adaptee.process();
    }
}
