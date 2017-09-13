package cn.mylava._itcast.Thread._04_Communication;

/**
 * 两个线程，a先循环10次，b再循环20次，之后a再循环10次，b再循环20次，如此往复50次
 * @author lipengfei
 */
public class Communication {
    public static void main(String[] args) {
        final Business b = new Business();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 50; i++) {
                    b.sub(i);
                }
            }
        }).start();

        for (int i = 1; i <= 50; i++) {
            b.main(i);
        }
    }
}


class Business {
    //信号灯，
    //true，子线程执行，主线程等待，执行完成后通知主线程
    //false，主线程执行，子线程等待，执行完成后通知子线程
    private boolean flag = true;
    public synchronized void sub(int num) {
        //等待
        while (!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //延时
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //执行
        for (int i = 1; i <= 10; i++) {
            System.out.println("sub thread sequence of "+ i +", loop of "+ num);
        }
        //通知
        this.notify();
        this.flag=false;

    }

    public synchronized void main(int num) {
        //等待
        while (flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //延时
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //执行
        for (int i = 1; i <= 20; i++) {
            System.out.println("main thread sequence of "+ i +", loop of "+ num);
        }
        //通知
        this.notify();
        this.flag=true;
    }
}