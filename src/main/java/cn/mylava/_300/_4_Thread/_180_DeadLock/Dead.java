package cn.mylava._300._4_Thread._180_DeadLock;

/**
 * 一手给钱一手给货导致死锁
 * @author lipengfei
 */
public class Dead {
    public static void main(String[] args) {
        Object goods = new Object();
        Object money = new Object();

        //共同的资源
        Customer customer = new Customer(goods,money);
        Seller seller = new Seller(goods,money);

        Thread proxy1 = new Thread(customer);
        Thread proxy2 = new Thread(seller);
        proxy1.start();
        proxy2.start();
    }
}

/**
 * 卖家
 */
class Seller implements Runnable{
    Object goods;
    Object money;

    public Seller(Object goods, Object money) {
        this.goods = goods;
        this.money = money;
    }

    @Override
    public void run() {
        while (true) {
            test();
        }
    }
    public void test() {
        synchronized (goods) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (money) {

            }
        }
        System.out.println("一手给钱……");
    }
}

/**
 * 买家
 */
class Customer implements Runnable{
    Object goods;
    Object money;

    public Customer(Object goods, Object money) {
        this.goods = goods;
        this.money = money;
    }

    @Override
    public void run() {
        while (true) {
            test();
        }
    }
    public void test() {
        synchronized (money) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (goods) {

            }
        }
        System.out.println("一手给货……");
    }
}

