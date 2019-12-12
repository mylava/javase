package cn.mylava._300._8_GOF._18_Observer.mq;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 04/05/2018
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("生产消息对象：");
        Subject subject = new Subject(new Provider(), new Consumer());
        System.out.println("消息对象放入队列：");
        subject.setState(0);
        System.out.println("消息对象被消费：");
        subject.setState(1);
    }
}
