package cn.mylava._thread.juc._08_communication.lock;

/**
 * comment: 演示生产者消费者及虚假唤醒
 * 在使用 this.wait(); 方法时，使用while代替if判断，防止虚假唤醒
 * @author: lipengfei
 * @date: 11/04/2018
 */
public class Client {
    public static void main(String[] args) {
        Shop shop = new Shop();
        Productor productor = new Productor(shop);
        Consumer consumer = new Consumer(shop);

        new Thread(productor,"生产者1").start();
        new Thread(productor,"生产者2").start();
        new Thread(consumer,"消费者1").start();
        new Thread(consumer,"消费者2").start();
    }
}
