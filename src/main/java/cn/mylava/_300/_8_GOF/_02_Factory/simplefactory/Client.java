package cn.mylava._300._8_GOF._02_Factory.simplefactory;

/**
 * comment: 简单工厂模式，适合单个接口
 *
 * @author: lipengfei
 * @date: 17/01/2018
 */
public class Client {
    public static void main(String[] args) {
        /**
         * --------------- ---------------
         * 不使用工厂模式，需要同时依赖接口和多个实现类
         * --------------- ---------------
         */
/*        Car c1 = new Audi();
        Car c2 = new Benz();
        c1.run();
        c2.run();*/
        
        /**
         * --------------- ---------------
         * 使用简单工厂模式创建对象，只需要依赖接口和工厂对象
         * --------------- ---------------
         */
        Car c3 = CarFactory.createCar("audi");
        Car c4 = CarFactory.createCar("benz");
        c3.run();
        c4.run();
    }
}
