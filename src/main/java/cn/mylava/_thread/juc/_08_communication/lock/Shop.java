package cn.mylava._thread.juc._08_communication.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * comment: 商店
 *
 * @author: lipengfei
 * @date: 11/04/2018
 */
public class Shop {
    //商品库存，最多10个
    private int count = 0;

    //使用lock替换synchronized
    private Lock lock = new ReentrantLock();
    //使用lock之后不能使用this.wait()了  需要使用condition完成线程间通信  this的wait/notify/notifyAll 分别对应 condition的 await/signal/signalAll
    Condition condition = lock.newCondition();

    //进货
    public void stock() {
        lock.lock();
        try {
            while (count >= 1) {
                System.out.println("生产太快了，库存满了，生产者的数据丢失");
                try {
//                    this.wait();  因为使用lock，所以使用condition代替this对象
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + " : " + ++count);
//            this.notifyAll();  同理  使用condition.signalAll()唤醒所有
            condition.signalAll();
        } finally {
            lock.unlock();
        }

    }

    //售货
    public void sale() {
        lock.lock();
        try {
            while (count <= 0) {
                System.out.println("生产太慢了，没有库存，消费者收到重复数据");
                try {
    //                    this.wait();  因为使用lock，所以使用condition代替this对象
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + " : " + --count);
//            this.notifyAll();  同理  使用condition.signalAll()唤醒所有
            condition.signalAll();
        } finally {
            lock.unlock();
        }

    }
}
