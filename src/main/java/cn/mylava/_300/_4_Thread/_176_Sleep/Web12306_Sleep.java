package cn.mylava._300._4_Thread._176_Sleep;

/**
 * sleep模式网络延时
 * @author lipengfei
 */
public class Web12306_Sleep implements Runnable{
    private int num = 10;

    @Override
    public void run() {
        while (true) {
            if (num<=0){
                break;
            }
            //模拟网络延时
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"抢到了"+num--);
        }
    }

    public static void main(String[] args) {
        Web12306_Sleep web = new Web12306_Sleep();
        Thread t1 = new Thread(web,"路人甲");
        Thread t2 = new Thread(web,"路人乙");
        Thread t3 = new Thread(web,"程序猿");

        t1.start();
        t2.start();
        t3.start();
    }

}
