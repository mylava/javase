package cn.mylava._300._8_GOF._02_Factory.abstractfactory;

import cn.mylava._300._8_GOF._02_Factory.abstractfactory.engine.Engine;
import cn.mylava._300._8_GOF._02_Factory.abstractfactory.seat.Seat;
import cn.mylava._300._8_GOF._02_Factory.abstractfactory.tyre.Tyre;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 17/01/2018
 */
public class Client {
    public static void main(String[] args) {
        CarFactory luxury = new LuxuryCarFactory();
        Engine engine = luxury.createEngine();
        engine.run();
        engine.start();

        Seat seat = luxury.createSeat();
        seat.massage();

        Tyre tyre = luxury.createTyre();
        tyre.sound();


        LowCarFactory low = new LowCarFactory();

    }
}
