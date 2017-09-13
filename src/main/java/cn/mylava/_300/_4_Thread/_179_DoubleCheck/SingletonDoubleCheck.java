package cn.mylava._300._4_Thread._179_DoubleCheck;

/**
 * @author lipengfei
 */
public class SingletonDoubleCheck {
    public static void main(String[] args) {
//        test1();
        test2();
    }

    //单线程访问
    public static void test1() {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton1 == singleton2);
    }

    //多线程访问
    public static void test2() {
        Thread t1 = new Thread(new TestThread());
        Thread t2 = new Thread(new TestThread());
        t1.start();
        t2.start();
    }
}
/**
 * 懒汉单例
 * 双重检查单例
 * 单例模式需要满足一下几点：
 * 1.构造器私有化,避免外部直接创建对象
 * 2.声明私有静态变量
 * 3.提供对外的静态公共方法获取实例
 */
class Singleton {
    //多个线程访问同一份资源（静态变量，也称为类变量，存储在方法区，只有一份，所以说是同一份资源，多线程导致引用指向的对象不一致）
    private static Singleton instance = null;

    private Singleton() {
    }
    //没有同步的方法，只能单线程使用
    public static Singleton getInstance() {
        if (null==instance) {
            //多个线程调用时可能存在延时，模拟延时
            try {
                Thread.sleep(((long) (Math.random()*100)));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new Singleton();
        }
        return instance;
    }

    //同步方法,效率低
    public synchronized static Singleton getInstanceSync() {
        if (null==instance) {
            //多个线程调用时可能存在延时，模拟延时
            try {
                Thread.sleep(((long) (Math.random()*100)));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new Singleton();
        }
        return instance;
    }

    //同步方法,效率低
    public  static Singleton getInstanceSyncClass() {
        //静态方法中不能使用this，所以这里对class对象加锁
        // ------->JVM内部还是对象，这些对象由ClassLoader管理，锁定创建对象的模板后，其他线程创建对象时只能等待锁释放后方能继续
        synchronized(Singleton.class) {
            if (null == instance) {
                //多个线程调用时可能存在延时，模拟延时
                try {
                    Thread.sleep(((long) (Math.random() * 100)));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                instance = new Singleton();
            }
        }
        return instance;
    }

    //双重检查
    public  static Singleton getInstanceDoubleCheck() {
        //提高效率，如果不为空，直接返回
        if(null == instance) {
            //第一次创建实例，可能同时有多个线程都执行到这一步(假设a b两个线程)，所以加锁
            synchronized (Singleton.class) {
                //假设 a线程先拿到锁，执行完之后 instance 不为空，b在获取到锁之后再进行一次判断
                if (null == instance) {
                    try {
                        Thread.sleep(((long) (Math.random() * 100)));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

}

class TestThread implements Runnable {
    @Override
    public void run() {
//        System.out.println(Thread.currentThread().getName()+"创建了："+Singleton.getInstance());
//        System.out.println(Thread.currentThread().getName()+"创建了："+Singleton.getInstanceSync());
//        System.out.println(Thread.currentThread().getName()+"创建了："+Singleton.getInstanceSyncClass());
        System.out.println(Thread.currentThread().getName()+"创建了："+ Singleton.getInstanceDoubleCheck());
    }
}