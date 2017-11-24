package cn.mylava._itcast.Thread._09_ThreadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author lipengfei
 */
public class ScheduledThreadPool {
    public static void main(String[] args) {
        //创建一个任务调度池，每次最多执行3个任务
        ScheduledExecutorService scheduledPool = Executors.newScheduledThreadPool(3);

        for (int i = 0; i < 10; i++) {
            final int taskId = i;
            scheduledPool.schedule(new Runnable() {
                @Override
                public void run() {
//                    System.out.println(taskId+" is scheduled!");
                }
            },1000, TimeUnit.MILLISECONDS);
        }
    }
}
