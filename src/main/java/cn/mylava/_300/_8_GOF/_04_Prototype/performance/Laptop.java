package cn.mylava._300._8_GOF._04_Prototype.performance;

/**
 * comment: 笔记本电脑对象
 *
 * @author: lipengfei
 * @date: 17/01/2018
 */
public class Laptop implements Cloneable{
    public Laptop() {
        try {
            //模拟创建对象比较耗时
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
