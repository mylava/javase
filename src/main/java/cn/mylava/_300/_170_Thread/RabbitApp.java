package cn.mylava._300._170_Thread;

/**
 * 模拟龟兔赛跑
 * @author lipengfei
 */
public class RabbitApp {

    public static void main(String[] args) {
        Rabbit rabbit = new Rabbit();
        Tortoise tortoise = new Tortoise();
        rabbit.start();
        tortoise.start();
    }
}


class Rabbit extends Thread {
    //run方法称为线程体
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println("兔子跑了"+i+"步！");
        }
    }
}

class Tortoise extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println("乌龟跑了"+i+"步！");
        }
    }
}


