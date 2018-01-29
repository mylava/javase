package cn.mylava._300._8_GOF._04_Prototype.jdkDeepClone;

import java.util.Date;

/**
 * comment: 测试JDK克隆 (深克隆，可以看到修改date，只有s1的值变化)
 *
 * @author: lipengfei
 * @date: 17/01/2018
 */
public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        Date d = new Date(12312312312L);
        Sheep s1 = new Sheep("深克隆原型",d);
        System.out.println(s1);

        Sheep s2 = (Sheep) s1.clone();
        s2.setName("多利");
        System.out.println(s2);

        //修改Date对象
        d.setTime(21231231232L);
        System.out.println(s1);
        System.out.println(s2);

        //使用序列化和反序列化也可以实现深克隆
    }
}
