package cn.mylava._300._8_GOF._09_Decorator;

import java.io.FileNotFoundException;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 24/01/2018
 */
public class Client {
    public static void main(String[] args) throws FileNotFoundException {
        ICar car = new Car();
        ICar aiCar = new AICar(car);
        aiCar.move();

        System.out.println("--------组合后--------");
        ICar complexCar = new FlyCar(aiCar);
        complexCar.move();

    }
}
