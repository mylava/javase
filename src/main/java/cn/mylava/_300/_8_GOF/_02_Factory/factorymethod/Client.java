package cn.mylava._300._8_GOF._02_Factory.factorymethod;

/**
 * comment: 工厂方法模式，符合开闭原则，但是代码更多了，采用简单工厂还是工厂模板需要合理取舍
 * 适合单个接口
 *
 * @author: lipengfei
 * @date: 17/01/2018
 */
public class Client {
    public static void main(String[] args) {
        Car c1 = new AudiFactory().createCar();
        Car c2 = new BenzFactory().createCar();
        c1.run();
        c2.run();
    }
}
