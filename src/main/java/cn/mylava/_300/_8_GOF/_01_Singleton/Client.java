package cn.mylava._300._8_GOF._01_Singleton;

import java.util.concurrent.CountDownLatch;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 09/01/2018
 */
public class Client {
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();

        int num = 100;
        CountDownLatch countDownLatch = new CountDownLatch(num);

        //启动十个线程 每个线程获取10W次单例
        for (int i = 0; i < num; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 1000000; i++) {
//                        Object instance = Singleton01.getInstance();
//                        Object instance = Singleton02.getInstance();
//                        Object instance = Singleton03.getInstance();
                        Object instance = Singleton04.getInstance();
                    }

                    countDownLatch.countDown();
                }
            }).start();
        }
        countDownLatch.await();
        long end = System.currentTimeMillis();

        System.out.println("总耗时+"+(end-start));

    }
}
