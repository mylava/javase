package cn.mylava._thread.juc._10_alternate;

/**
 * comment: 控制多个线程交替执行
 *
 *
 * @author: lipengfei
 * @date: 11/04/2018
 */
public class Client {
    public static void main(String[] args) {
        Alternate alternate = new Alternate();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 5; i++) {
                    alternate.threadA(1,i);
                }
            }
        },"A").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 5; i++) {
                    alternate.threadB(2,i);
                }
            }
        },"B").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 5; i++) {
                    alternate.threadC(3,i);
                }
            }
        },"C").start();
    }
}
