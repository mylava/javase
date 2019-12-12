package cn.mylava._300._8_GOF._09_Decorator.demo;

/**
 * comment: 装饰角色
 *
 * @author: lipengfei
 * @date: 24/01/2018
 */
public class SuperCar implements ICar {
    //持有
    private ICar car;

    public SuperCar(ICar car) {
        this.car = car;
    }

    @Override
    public void move() {
        car.move();
    }
}
