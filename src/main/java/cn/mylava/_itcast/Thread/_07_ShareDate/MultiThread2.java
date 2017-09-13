package cn.mylava._itcast.Thread._07_ShareDate;

/**
 * @author lipengfei
 */
public class MultiThread2 {

    //AtomicInteger怎么样？
    private static Integer count = 20;

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (count) {
                        if (count>=1) {
                            System.out.println(Thread.currentThread().getName() + " 抢走了第------>" + count + "张票");
                            count--;
                        } else {
                            System.out.println("票已售罄！");
                        }
                    }
                }
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(500);try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (count) {
                        System.out.println(Thread.currentThread().getName() + " 退了--->" + (count++) + "张票");
                    }
                }
            }
        }).start();
    }
}
