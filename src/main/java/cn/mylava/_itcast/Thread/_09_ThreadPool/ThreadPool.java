package cn.mylava._itcast.Thread._09_ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lipengfei
 */
public class ThreadPool {
    //线程结束时注册回调函数
    public static void callback(int taskId) {
        System.out.println(taskId+"------------------调用完成");
    }


    public static void main(String[] args) {
        //创建线程池  固定执行个数，每次从池中取出两个，执行完再从池中取
//        ExecutorService threadPool = Executors.newFixedThreadPool(2);

        //单个执行线程池----特点：执行线程的时候，如果线程挂掉，会再启动一个线程
//        ExecutorService threadPool = Executors.newSingleThreadExecutor();

        //可变执行个数
        ExecutorService threadPool = Executors.newCachedThreadPool();


        //让线程池执行10个任务
        for (int i = 1; i <= 10; i++) {
            final int taskId = i;
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    for (int j = 1; j <= 10; j++) {
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + " loop of "+ j +" for task of "+ taskId);
                    }
                    ThreadPool.callback(taskId);
                }
            });
        }


        System.out.println("job committed");

        //立即关闭线程池，无论任务是否完成

//        threadPool.shutdownNow();

        //任务完成后再关闭池
        threadPool.shutdown();
    }
}

