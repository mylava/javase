package cn.mylava._300._172_Thread;

/**
 * 使用Runnable形式实现多线程
 * runnable优点：
 *  1.避免java的单继承带来的局限性
 *  2.方便资源共享，这里是余票的数量num，适合多个相同程序代码的线程去处理同一个资源
 *  3.增强了程序的健壮性，代码能够被多个线程共享，代码与数据是独立的。 -->  线程对象在实例化的时候只实例化一个对象
 * @author lipengfei
 */
public class Web12306 implements Runnable{
    private int num = 50;

    @Override
    public void run() {
        while (true) {
            if (num<=0){
                break;
            }
            System.out.println(Thread.currentThread().getName()+"抢到了"+num--);
        }
    }

    public static void main(String[] args) {
        Web12306 web = new Web12306();
        Thread t1 = new Thread(web,"路人甲");
        Thread t2 = new Thread(web,"路人乙");
        Thread t3 = new Thread(web,"程序猿");

        t1.start();
        t2.start();
        t3.start();
    }

}
