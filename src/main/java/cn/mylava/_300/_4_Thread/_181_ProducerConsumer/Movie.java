package cn.mylava._300._4_Thread._181_ProducerConsumer;

/**
 * 共同资源
 * @author lipengfei
 */
public class Movie {
    private String pic;
    //信号灯：
    // true 生产者生产，消费者等待； 生产完成后通知消费
    // false 生产者等待，消费者消费  消费完成后通知生产
    private boolean flag = true;

    //模拟生产
    public synchronized void play(String pic) {
        //等待
        if (!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //生产耗费时间
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //生产
        this.pic = pic;
        //通知
        this.flag = false;
        this.notify();
    }

    //模拟消费
    public synchronized void watch() {
        //等待
        if (flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //消费耗费时间
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //消费
        System.out.println(pic);
        //通知
        this.flag = true;
        this.notify();
    }

}
