package cn.mylava._300._8_GOF._02_Factory.abstractfactory;

import cn.mylava._300._8_GOF._02_Factory.abstractfactory.engine.Engine;
import cn.mylava._300._8_GOF._02_Factory.abstractfactory.seat.Seat;
import cn.mylava._300._8_GOF._02_Factory.abstractfactory.tyre.Tyre;

/**
 * comment: 汽车工厂类
 *
 * @author: lipengfei
 * @date: 17/01/2018
 */
public interface CarFactory {
    Engine createEngine();
    Seat createSeat();
    Tyre createTyre();
}
