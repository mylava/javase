package cn.mylava._300._8_GOF._02_Factory.abstractfactory.tyre;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 17/01/2018
 */
public class LowTyre implements Tyre {
    @Override
    public void sound() {
        System.out.println("低端轮胎，简直拖拉机！");
    }
}
