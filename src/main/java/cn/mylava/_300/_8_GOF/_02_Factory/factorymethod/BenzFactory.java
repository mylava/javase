package cn.mylava._300._8_GOF._02_Factory.factorymethod;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 17/01/2018
 */
public class BenzFactory implements CarFactory {
    @Override
    public Car createCar() {
        return new Benz();
    }
}
