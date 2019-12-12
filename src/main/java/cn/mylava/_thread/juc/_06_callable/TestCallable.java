package cn.mylava._thread.juc._06_callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * comment: FutureTask 也可用于闭锁
 *
 * @author: lipengfei
 * @date: 11/04/2018
 */
public class TestCallable {
    public static void main(String[] args) {
        Sum sum = new Sum();
        FutureTask task = new FutureTask(sum);
        new Thread(task).start();

        try {
            System.out.println(task.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class Sum implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i <= Integer.MAX_VALUE; i++) {
            sum+=i;
        }
        return sum;
    }
}
