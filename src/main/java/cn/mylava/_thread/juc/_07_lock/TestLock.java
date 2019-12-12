package cn.mylava._thread.juc._07_lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * comment: 同步锁
 *
 * @author: lipengfei
 * @date: 11/04/2018
 */
public class TestLock {
    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(3);
        Ticket ticket = new Ticket(latch);

        new Thread(ticket,"1号窗口").start();
        latch.countDown();
        new Thread(ticket,"2号窗口").start();
        latch.countDown();
        new Thread(ticket,"3号窗口").start();
        latch.countDown();
    }
}

class Ticket implements Runnable {
    private CountDownLatch latch;

    public Ticket(CountDownLatch latch) {
        this.latch = latch;
    }

    private int count = 1000;

    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"准备就绪");
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"开始运行");

        while (true) {
            lock.lock();
            try {
                if (count>0) {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                    }
                    System.out.println(Thread.currentThread().getName() + "完成售票，余票为" + --count);
                } else {
                    System.out.println(Thread.currentThread().getName() + "售完！");
                    break;
                }
            } finally {
                lock.unlock();
            }
        }
    }
}


