package cn.mylava._300._8_GOF._02_Factory.abstractfactory.engine;

/**
 * comment: 低端发动机
 *
 * @author: lipengfei
 * @date: 17/01/2018
 */
public class LowEngine implements Engine{
    @Override
    public void run() {
        System.out.println("低端发动机run");
    }

    @Override
    public void start() {
        System.out.println("低端发动机start");
    }
}
