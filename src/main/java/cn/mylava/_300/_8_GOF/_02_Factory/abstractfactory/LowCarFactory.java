package cn.mylava._300._8_GOF._02_Factory.abstractfactory;

import cn.mylava._300._8_GOF._02_Factory.abstractfactory.engine.Engine;
import cn.mylava._300._8_GOF._02_Factory.abstractfactory.engine.LowEngine;
import cn.mylava._300._8_GOF._02_Factory.abstractfactory.seat.LowSeat;
import cn.mylava._300._8_GOF._02_Factory.abstractfactory.seat.Seat;
import cn.mylava._300._8_GOF._02_Factory.abstractfactory.tyre.LowTyre;
import cn.mylava._300._8_GOF._02_Factory.abstractfactory.tyre.Tyre;

/**
 * comment: 低端汽车工厂类
 *
 * @author: lipengfei
 * @date: 17/01/2018
 */
public class LowCarFactory implements CarFactory{
    @Override
    public Engine createEngine() {
        return new LowEngine();
    }

    @Override
    public Seat createSeat() {
        return new LowSeat();
    }

    @Override
    public Tyre createTyre() {
        return new LowTyre();
    }
}
