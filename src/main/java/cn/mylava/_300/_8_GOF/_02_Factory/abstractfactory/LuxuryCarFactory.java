package cn.mylava._300._8_GOF._02_Factory.abstractfactory;

import cn.mylava._300._8_GOF._02_Factory.abstractfactory.engine.Engine;
import cn.mylava._300._8_GOF._02_Factory.abstractfactory.engine.LuxuryEngine;
import cn.mylava._300._8_GOF._02_Factory.abstractfactory.seat.LuxurySeat;
import cn.mylava._300._8_GOF._02_Factory.abstractfactory.seat.Seat;
import cn.mylava._300._8_GOF._02_Factory.abstractfactory.tyre.LuxuryTyre;
import cn.mylava._300._8_GOF._02_Factory.abstractfactory.tyre.Tyre;

/**
 * comment: 高端汽车工厂类
 *
 * @author: lipengfei
 * @date: 17/01/2018
 */
public class LuxuryCarFactory implements CarFactory {
    @Override
    public Engine createEngine() {
        return new LuxuryEngine();
    }

    @Override
    public Seat createSeat() {
        return new LuxurySeat();
    }

    @Override
    public Tyre createTyre() {
        return new LuxuryTyre();
    }
}
