package cn.mylava._300._8_GOF._09_Decorator;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 24/01/2018
 */
public class FlyCar extends SuperCar {
    public FlyCar(ICar car) {
        super(car);
    }

    public void swim() {
        System.out.println("新增功能水上游！");
    }

    @Override
    public void move() {
        super.move();
        swim();
    }
}
