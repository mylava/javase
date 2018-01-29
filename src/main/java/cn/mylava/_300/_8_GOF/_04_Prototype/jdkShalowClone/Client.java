package cn.mylava._300._8_GOF._04_Prototype.jdkShalowClone;

import java.util.Date;

/**
 * comment: 测试JDK克隆 (浅克隆，可以看到修改date，两个对象的值都跟着变化，说明引用的Date对象是同一个对象)
 *
 * @author: lipengfei
 * @date: 17/01/2018
 */
public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        Date d = new Date(12312312312L);
        Sheep s1 = new Sheep("多利的原型",d);
        System.out.println(s1);

        Sheep s2 = (Sheep) s1.clone();
        s2.setName("多利");
        System.out.println(s1==s2);
        System.out.println(s2);


        //修改Date对象
        d.setTime(2123123123L);
        System.out.println(s1);
        System.out.println(s2);

    }
}
