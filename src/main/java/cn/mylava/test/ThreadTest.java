package cn.mylava.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 09/08/2018
 */
public class ThreadTest {
    public static void main(String[] args) {
        Bean bean = new Bean();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                bean.print1();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                bean.print2();
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                bean.print3();
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }

}

class Bean {
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    private int i = 1;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
    public void print1() {
        lock.lock();
        try {
            for (;i<100;i++) {
                while (i % 3 != 1) {
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(i);
                condition.signalAll();
            }
        } finally {
            lock.unlock();
        }
    }
    public void print2() {
        lock.lock();
        try {
            for (;i<100;i++) {
                while (i % 3 != 2) {
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(i);
                condition.signalAll();
            }
        } finally {
            lock.unlock();
        }
    }
    public void print3() {
        lock.lock();
        try {
            for (;i<100;i++) {
                while (i % 3 != 0) {
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(i);
                condition.signalAll();
            }
        } finally {
            lock.unlock();
        }
    }
}