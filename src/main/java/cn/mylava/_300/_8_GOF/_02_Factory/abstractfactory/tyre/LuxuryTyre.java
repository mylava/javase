package cn.mylava._300._8_GOF._02_Factory.abstractfactory.tyre;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 17/01/2018
 */
public class LuxuryTyre implements Tyre {
    @Override
    public void sound() {
        System.out.println("高端轮胎，胎噪小");
    }
}