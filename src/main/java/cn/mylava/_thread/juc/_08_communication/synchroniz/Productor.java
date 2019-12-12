package cn.mylava._thread.juc._08_communication.synchroniz;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 11/04/2018
 */
public class Productor implements Runnable {
    private Shop shop;

    public Productor(Shop shop) {
        this.shop = shop;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            shop.stock();
        }
    }
}
