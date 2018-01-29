package cn.mylava._300._8_GOF._04_Prototype.serialDeepClone;

import java.io.*;
import java.util.Date;

/**
 * comment: 使用序列化和反序列化也可以实现深克隆
 *
 * @author: lipengfei
 * @date: 17/01/2018
 */
public class Client {
    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        Date d = new Date(12312312312L);
        Sheep s1 = new Sheep("深克隆原型",d);
        System.out.println(s1);

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(s1);
        byte[] bytes = bos.toByteArray();

        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = new ObjectInputStream(bis);
        Sheep s2 = (Sheep) ois.readObject();


        //修改Date对象
        d.setTime(21231231232L);
        System.out.println(s1);
        System.out.println("克隆的"+s2);
    }
}
