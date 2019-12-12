package cn.mylava._thread.juc._08_communication.lock;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 11/04/2018
 */
public class Consumer implements Runnable {
    private Shop shop;

    public Consumer(Shop shop) {
        this.shop = shop;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            shop.sale();
        }
    }
}
