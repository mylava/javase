package cn.mylava._itcast.Thread._07_ShareDate;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 多个线程访问同一份数据的实现方式
 * 1.如果每个线程执行的代码相同，可以将数据封装在Runnable对象内，如卖票系统(票总数减减)。
 * 2.如果每个线程执行的代码不同，将数据封装到同一对象中，分别在run()方法中进行调用
 *      1）对象作为参数传递到Runnable对象中
 *      2) 匿名Runnable内部类直接使用局部变量
 * @author lipengfei
 */
public class MultiThread1 {

    public static void main(String[] args) {
        //模拟卖票
//        test1();
        //卖票同时退票
        test2();
    }

    //1
    public static void test1() {
        ShareData1 data1 = new ShareData1();
        new Thread(data1).start();
        new Thread(data1).start();
    }
    //2.1
    public static void test2() {
        ShareData2 data2 = new ShareData2();
        //卖票
        new Thread(new Runnable1(data2)).start();
        //退票
        new Thread(new Runnable2(data2)).start();
    }
    //2.2
    public static void test3() {
        final ShareData2 data2 = new ShareData2();
        //卖票
        new Thread(new Runnable() {
            @Override
            public void run() {
                //data2.sail()   代码省略……

            }
        }).start();
        //退票
        new Thread(new Runnable(){
            @Override
            public void run() {
                //data2.refund()   代码省略……
            }
        }).start();
    }

}

/**
 * 模拟卖票，不能退票的场景
 * ---------------------卖到最后一张票会出问题，暂时不解决，可以采用信号灯等待退票再继续卖票
 */
class ShareData1 implements Runnable {
    private int count = 20;

    private synchronized int sail() {
        //其他逻辑……
        //返回余量
        return count--;
    }

    @Override
    public void run() {
        while (count > 0) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 抢走了第------>" + sail() + "张票");
        }
    }
}

/**
 * 同时可以退票和卖票场景
 */
class ShareData2 {
    private int count = 20;
    public synchronized int getCount() {
        return count;
    }
    public synchronized int sail() {
        //其他逻辑……
        //返回余量
        if (count > 1) {
            count--;
        }
        return count;
    }

    public synchronized int refound() {
        //其他逻辑……
        //返回余量
        return count++;
    }
}
class Runnable1 implements Runnable{
    private ShareData2 data2;

    public Runnable1(ShareData2 data2) {
        this.data2 = data2;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (data2.getCount()>0) {
                System.out.println(Thread.currentThread().getName() + " 抢走了第------>" + data2.sail() + "张票");
            } else {
                System.out.println("------票已售罄------");
            }
        }
    }
}

class Runnable2 implements Runnable{
    private ShareData2 data2;

    public Runnable2(ShareData2 data2) {
        this.data2 = data2;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 退了--->" + data2.refound() + "张票");
        }
    }
}