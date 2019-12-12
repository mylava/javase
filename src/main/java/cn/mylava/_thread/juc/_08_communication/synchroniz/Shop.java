package cn.mylava._thread.juc._08_communication.synchroniz;

/**
 * comment: 商店
 *
 * @author: lipengfei
 * @date: 11/04/2018
 */
public class Shop {
    //商品库存，最多10个
    private int count = 0;

    //进货
    public synchronized void stock() {
        while (count >= 1) {
            System.out.println("生产太快了，库存满了，生产者的数据丢失");
            try {
                //不能进货
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " : " + ++count);
        //通知进货
        this.notifyAll();

    }

    //售货
    public synchronized void sale() {
        while (count <= 0) {
            System.out.println("生产太慢了，没有库存，消费者收到重复数据");
            try {
                //停止卖货
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " : " + --count);
        //通知卖货
        this.notifyAll();

    }
}
