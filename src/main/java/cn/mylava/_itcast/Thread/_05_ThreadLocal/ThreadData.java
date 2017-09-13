package cn.mylava._itcast.Thread._05_ThreadLocal;

import java.util.Random;

/**
 * ThreadLocal的使用：
 * 1.将数据封装到对象中
 * 2.在对象中声明ThreadLocal对象
 * 3.私有化构造方法，提供静态方法
 * 是一种特殊的单例(同一线程的单例)
 *
 * @author lipengfei
 */
public class ThreadData {
    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //现实场景中赋值和获取不会在同一方法内执行，这里只是一个demo
                    ThreadDataObj  obj = ThreadDataObj.getThreadInstance();
                    int money = new Random().nextInt();
                    obj.setMoney(money);
                    System.out.println(Thread.currentThread().getName()+"--->赋值："+money);

                    System.out.println(Thread.currentThread().getName()+"--->获取值："+ThreadDataObj.getThreadInstance().getMoney());
                }
            }).start();
        }
    }

}
//1.将数据封装到对象中
class ThreadDataObj {
    private String name;
    private int money;
    private static ThreadLocal<ThreadDataObj> holder = new ThreadLocal<>();

    private ThreadDataObj() {
    }

    public static ThreadDataObj getThreadInstance() {
        ThreadDataObj instance = holder.get();
        if (instance == null) {
            instance = new ThreadDataObj();
            holder.set(instance);
        }
        return instance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}

