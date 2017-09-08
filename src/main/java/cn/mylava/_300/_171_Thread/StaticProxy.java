package cn.mylava._300._171_Thread;

/**
 * 静态代理设计模式
 * 代理模式要点：
 * 1.真实角色
 * 2.代理角色+持有真实角色的引用
 * 3.二者实现相同接口
 * @author lipengfei
 */
public class StaticProxy {
    public static void main(String[] args) {
        //创建真实角色
        Marry people = new People();
        //创建代理角色 + 持有真实角色的引用
        WeddingCompany proxy = new WeddingCompany(people);

        proxy.marry();
    }
}

/**
 * 共同接口
 */
interface Marry {
    //接口中的方法默认就是public abstract------>相当于Runnable的run方法
    /*public abstract*/ void marry();
}

/**
 * 真实角色
 * 相当于写多线程程序时，编写的实现Runnable接口的类
 */
class People implements Marry {
    //相当于线程体，run方法
    @Override
    public void marry() {
        System.out.println("--------->线程体执行中。。。");
    }
}

/**
 * 代理角色
 * 相当于Thread类
 */
class WeddingCompany implements Marry {
    private Marry people;

    public WeddingCompany() {
    }
    //相当于new Thread()时传入Runnable对象
    public WeddingCompany(Marry people) {
        this.people = people;
    }

    private void before() {
        System.out.println("准备资源。。。");
    }


    @Override
    public void marry() {
        //前期准备  初始化资源，开辟线程等
        before();
        //相当于执行线程体
        people.marry();
        //后期整理  销毁资源，关闭线程等
        after();
    }

    private void after() {
        System.out.println("销毁资源。。。");
    }
}