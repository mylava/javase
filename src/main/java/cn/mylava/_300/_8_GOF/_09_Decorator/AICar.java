package cn.mylava._300._8_GOF._09_Decorator;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 24/01/2018
 */
public class AICar extends SuperCar {
    public AICar(ICar car) {
        super(car);
    }

    public void autoMove() {
        System.out.println("新增功能自动驾驶！");
    }

    @Override
    public void move() {
        super.move();
        autoMove();
    }
}
