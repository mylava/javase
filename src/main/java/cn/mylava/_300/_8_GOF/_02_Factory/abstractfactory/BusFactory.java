package cn.mylava._300._8_GOF._02_Factory.abstractfactory;

import cn.mylava._300._8_GOF._02_Factory.abstractfactory.engine.Engine;
import cn.mylava._300._8_GOF._02_Factory.abstractfactory.engine.SuvEngine;
import cn.mylava._300._8_GOF._02_Factory.abstractfactory.seat.BusSeat;
import cn.mylava._300._8_GOF._02_Factory.abstractfactory.seat.Seat;
import cn.mylava._300._8_GOF._02_Factory.abstractfactory.tyre.BusTyre;
import cn.mylava._300._8_GOF._02_Factory.abstractfactory.tyre.Tyre;

/**
 * comment: Bus汽车工厂类
 *
 * @author: lipengfei
 * @date: 17/01/2018
 */
public class BusFactory implements AutomobileFactory {
    @Override
    public Engine createEngine() {
        return new SuvEngine();
    }

    @Override
    public Seat createSeat() {
        return new BusSeat();
    }

    @Override
    public Tyre createTyre() {
        return new BusTyre();
    }
}
