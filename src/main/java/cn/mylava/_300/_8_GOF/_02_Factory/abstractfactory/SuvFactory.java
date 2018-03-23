package cn.mylava._300._8_GOF._02_Factory.abstractfactory;

import cn.mylava._300._8_GOF._02_Factory.abstractfactory.engine.Engine;
import cn.mylava._300._8_GOF._02_Factory.abstractfactory.engine.BusEngine;
import cn.mylava._300._8_GOF._02_Factory.abstractfactory.seat.SuvSeat;
import cn.mylava._300._8_GOF._02_Factory.abstractfactory.seat.Seat;
import cn.mylava._300._8_GOF._02_Factory.abstractfactory.tyre.SuvTyre;
import cn.mylava._300._8_GOF._02_Factory.abstractfactory.tyre.Tyre;

/**
 * comment: SUV汽车工厂类
 *
 * @author: lipengfei
 * @date: 17/01/2018
 */
public class SuvFactory implements AutomobileFactory {
    @Override
    public Engine createEngine() {
        return new BusEngine();
    }

    @Override
    public Seat createSeat() {
        return new SuvSeat();
    }

    @Override
    public Tyre createTyre() {
        return new SuvTyre();
    }
}
