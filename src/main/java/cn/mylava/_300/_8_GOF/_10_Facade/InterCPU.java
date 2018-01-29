package cn.mylava._300._8_GOF._10_Facade;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 24/01/2018
 */
public class InterCPU implements CPU {
    @Override
    public void run() {
        System.out.println("inter cpu运行中。。。");
    }
}
