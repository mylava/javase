package cn.mylava._300._8_GOF._02_Factory.abstractfactory.engine;

/**
 * comment: 高级发动机实现类
 * luxury 美  ['lʌɡʒəri] 奢侈，奢华
 * @author: lipengfei
 * @date: 17/01/2018
 */
public class LuxuryEngine implements Engine {
    @Override
    public void run() {
        System.out.println("高级发动机run");
    }

    @Override
    public void start() {
        System.out.println("高级发动机start");
    }
}
