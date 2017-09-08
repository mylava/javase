package cn.mylava._300._173_Thread;

import java.util.concurrent.*;

/**
 * 1.创建线程池 ExecutorService es = Executors.newFixedThreadPool(2);
 * 2.提交Callable到线程池 Future<Integer> f1 = es.submit(tortoise);
 * 3.获取结果  Integer num1 = f1.get();
 * 4.关闭线程池 es.shutdownNow();
 * @author lipengfei
 */
public class Call {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(2);
        Race tortoise = new Race("乌龟");
        tortoise.setTime(300);
        Race rabbit = new Race("兔子");
        rabbit.setTime(100);

        Future<Integer> f1 = es.submit(tortoise);
        Future<Integer> f2 = es.submit(rabbit);
        //让线程运行两秒钟
        Thread.sleep(2000);
        //之后终止线程
        tortoise.setFlag(false);
        rabbit.setFlag(false);

        Integer num1 = f1.get();
        Integer num2 = f2.get();
        System.out.println("乌龟跑了--->"+num1+"步");
        System.out.println("兔子跑了--->"+num2+"步");
        es.shutdownNow();
    }
}

class Race implements Callable<Integer> {
    private String name;
    //模拟网络延时
    private int time;
    private boolean flag = true;
    private int step = 0;

    public Race() {
    }

    public Race(String name) {
        this.name = name;
    }

    @Override
    public Integer call() throws Exception {
        while (flag) {
            Thread.sleep(time);
            step++;
        }
        return step;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }
}