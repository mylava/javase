package cn.mylava._thread.juc._10_alternate;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * comment: 信号灯对象
 *
 * @author: lipengfei
 * @date: 11/04/2018
 */
public class Alternate {
    private int number = 1; //用于控制线程的执行顺序
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void threadA(int innerLoop,int outerLoop) {
        lock.lock();
        try {
            while (number != 1) {
                condition.await();
            }
            for (int i = 0; i < innerLoop; i++) {
                System.out.println(Thread.currentThread().getName() + "\t"+ (i+1));
            }
            number=2;
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void threadB(int innerLoop,int outerLoop) {
        lock.lock();
        try {
            while (number != 2) {
                condition.await();
            }
            for (int i = 0; i < innerLoop; i++) {
                System.out.println(Thread.currentThread().getName() + "\t"+ (i+1));
            }
            number=3;
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void threadC(int innerLoop,int outerLoop) {
        lock.lock();
        try {
            while (number != 3) {
                condition.await();
            }
            for (int i = 0; i < innerLoop; i++) {
                System.out.println(Thread.currentThread().getName() + "\t"+ (i+1));
            }
            System.out.println("--------------"+outerLoop+"--------------");
            number=1;
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
