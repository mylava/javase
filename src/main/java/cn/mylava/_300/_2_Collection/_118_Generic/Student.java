package cn.mylava._300._2_Collection._118_Generic;

/**
 * 泛型实现类似多态的功能
 *
 * 使用问号(?)通配符实现类似多态功能
 * ?只能使用在声明时使用，切只能使用在  声明类型|声明方法上，不能使用在声明类上
 * 只能在用在声明时，不能用在使用时
 *
 * extends <= 小于等于指定类型  即指定类型的子类或者指定类型自身
 * super   >= 大于等于指定类型，即指定类型的父类或者指定类型自身
 * @author lipengfei
 */
public class Student<T> {

    T score;

    public static void main(String[] args) {
        //只能使用在  声明时
        Student<?> stu;
        //使用时  必须使用  确定类型
        stu = new Student<String>();

        //实现类似多态形式的泛型 --> extends,注意这里使用的是Fruit的子类
        test1(new Student<Apple>());
        //直接使用报错
//        test2(new Student<Apple>());
        //实现类似多态形式的泛型 --> super,注意这里使用的是Apple的父类
        test1(new Student<Fruit>());
    }

    /**
     * 静态方法不能使用类上定义的泛型
    public static void test(Student<T> student) {

    }
     */
    /**
     *  类型不确定时，使用问号通配符
     * @param student
     */
    public static void test(Student<?> student) {

    }

    /**
     * 实现类似多态形式的泛型 --> extends
     * @param student
     */
    public static void test1(Student<? extends Fruit> student) {

    }

    /**
     * 和test1对比，直接使用多态编译报错
     * @param student
     */
    public static void test2(Student<Fruit> student) {

    }

    /**
     * 实现类似多态形式的泛型 --> super
     * @param student
     */
    public static void test3(Student<? super Apple> student) {

    }
}
