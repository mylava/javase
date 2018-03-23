package cn.mylava._300._8_GOF._02_Factory.abstractfactory.seat;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 17/01/2018
 */
public class BusSeat implements Seat{
    @Override
    public void massage() {
        System.out.println("联排座椅，没有按摩");
    }
}
