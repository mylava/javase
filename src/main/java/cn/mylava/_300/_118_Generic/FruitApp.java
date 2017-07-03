package cn.mylava._300._118_Generic;

/**
 * 多态的两种形式
 *  1.形参使用多态
 *  2.返回类型使用多态
 *  泛型没有多态
 * @author lipengfei
 */
public class FruitApp {
    public static void main(String[] args) {
        Fruit f = new Apple();
        //多态的两种形式
        //1.形参使用多态
        testPolymorphic(new Apple());
        //2.返回类型使用多态
        Fruit apple = testPolymorphic1();

        //泛型无法使用多态,编译报错
//        Generic<Fruit> generic = new Generic<Apple>();
        Generic<Fruit> generic = new Generic<Fruit>();
        //泛型无法使用多态,编译报错
//        testGeneric(new Generic<Apple>());
        testGeneric(new Generic<Fruit>());

        Generic<Fruit> obj = testGeneric1();

    }

    public static void testPolymorphic(Fruit f) {
    }

    public static Fruit testPolymorphic1() {
        return new Apple();
    }

    public static void testGeneric(Generic<Fruit> g) {
    }
    public static Generic<Fruit> testGeneric1() {
        //泛型无法使用多态,编译报错
//        return new Generic<Apple>();
        return new Generic<Fruit>();
    }

}

class Generic<T> {
}