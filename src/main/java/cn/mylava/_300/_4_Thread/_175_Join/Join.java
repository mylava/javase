package cn.mylava._300._4_Thread._175_Join;

/**
 * @author lipengfei
 */
public class Join extends Thread{
    public static void main(String[] args) throws InterruptedException {

        Thread t = new Join();
        t.start();

        for (int i = 0; i < 100; i++) {
            if (i==50) {
                System.out.println("加入线程……");
                t.join();
            }
            System.out.println("main……"+i);
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 500; i++) {
            if (i%20==0) {
                System.out.println("暂停本线程---->");
                Thread.yield();
            }
            System.out.println("join……"+i);
       }
    }
}
