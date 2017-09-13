package cn.mylava._300._4_Thread._178_Synchronized;

/**
 * @author lipengfei
 */
public class SyncWeb12306 {
    public static void main(String[] args) {
        Web12306 web = new Web12306();
        Thread t1 = new Thread(web,"路人甲");
        Thread t2 = new Thread(web,"路人乙");
        Thread t3 = new Thread(web,"程序猿");

        t1.start();
        t2.start();
        t3.start();
    }
}

class Web12306 implements Runnable {
    private int num = 10;
    private boolean flag = true;
    @Override
    public void run() {
        while (flag) {
//            test1();
//            test2();
//            test3();
            test4();
        }
    }
    //线程不安全的方法
    public void test1() {
        if (num<=0){
            flag=false;
            return; //------>即使返回也会出现负数
        }
        //模拟网络延时
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"抢到了"+num--);
    }

    //线程安全的方法
    public synchronized void test2() {
        if (num<=0){
            flag=false;
            return; //------>如果不返回会出现负数
        }
        //模拟网络延时
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"抢到了"+num--);
    }

    //同步块实现线程安全
    public void test3() {
        synchronized(this) {
            if (num <= 0) {
                flag = false;
                return; //------>如果不返回会出现负数
            }
            //模拟网络延时
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "抢到了" + num--);
        }
    }

    //锁定范围不正确
    public void test4() {
        synchronized(this) {
            if (num <= 0) {
                flag = false;
                return; //------>如果不返回会出现负数
            }
        }

        //模拟网络延时
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "抢到了" + num--);
    }
}