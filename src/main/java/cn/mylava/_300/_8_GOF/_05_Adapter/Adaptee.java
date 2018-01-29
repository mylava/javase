package cn.mylava._300._8_GOF._05_Adapter;

/**
 * comment: 被适配的类
 *
 * @author: lipengfei
 * @date: 22/01/2018
 */
public class Adaptee {
    public void process() {
        System.out.println("我是被适配的类，处理客户请求！");
    }
}
