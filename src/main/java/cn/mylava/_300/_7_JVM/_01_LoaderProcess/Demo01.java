package cn.mylava._300._7_JVM._01_LoaderProcess;

/**
 * comment: 类加载过程描述
 *
 * @author: lipengfei
 * @date: 08/01/2018
 */
public class Demo01 {
    public static void main(String[] args) throws ClassNotFoundException {
        //最先执行
  /*      System.out.println("调用main方法");
        //A 执行初始化  a在栈中创建对象引用  new A();创建对象，调用构造器(压栈动作)   = 将对象引用赋值给a
        A a1 = new A();
        System.out.println(A.width);
        //类只初始化一次，再次调用不会执行初始化方法
        A a2 = new A();*/


        /**
         * --------------- ---------------
         * 主动引用(触发初始化)
         * --------------- ---------------
         */
        //1.new一个类的对象    4.初始化一个类，其父类没有被初始化，则先初始化父类
//        new A();
        //2.调用类的静态成员或静态方法
//        System.out.println(A.width);
        //3.使用java.lang.reflect方法进行反射调用
//        Class.forName("cn.mylava._300._7_JVM._01_LoaderProcess.A");
        
        
        /**
         * --------------- ---------------
         * 被动引用
         * --------------- ---------------
         */
        //1.访问一个静态域时，只有真正声明这个域的类才会被初始化(通过子类引用父类的静态变量，不会导致子类初始化)
//        System.out.println(A.length);
        //2.定义类的引用，不会触发此类的初始化
//        A[] array = new A[10];
//        A a;
        //3.引用常量不会触发初始化(常量在编译阶段就存入[调用类]的常量池中了)
        System.out.println(A.max);
    }
}

class A extends Father{
    //初始化-------> <clinit>()-------> 静态域及静态块
    public static int width = 100;
    static {
        System.out.println("静态初始化类A");
        width = 300;
    }
    //常量不会初始化
    public static final int max = 100;

    public A() {
        System.out.println("创建A类的对象");
    }
}

class Father {
    //访问一个静态域时，只有真正声明这个域的类才会被初始化(通过子类引用父类的静态变量，不会导致子类初始化)
    public static int length=800;
    static {
        System.out.println("父类的静态块");
    }
}