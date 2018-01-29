package cn.mylava._300._8_GOF._02_Factory.simplefactory;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 17/01/2018
 */
public class CarFactory {
    //简单工厂也叫静态工厂模式，因为工厂类一般使用静态方法，通过接受不同参数来返回不同的实例对象。
    public static Car createCar(String type) {
        if ("audi".equals(type)) {
            return  new Audi();
        } else if ("benz".equals(type)) {
            return  new Benz();
        } else { //增加新的产品需要修改代码(违反开闭原则)
            return null;
        }
    }
}
