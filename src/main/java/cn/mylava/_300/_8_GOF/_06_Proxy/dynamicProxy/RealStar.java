package cn.mylava._300._8_GOF._06_Proxy.dynamicProxy;

/**
 * comment: 真实角色
 *
 * @author: lipengfei
 * @date: 22/01/2018
 */
public class RealStar implements Star {
    @Override
    public void confer() {
        System.out.println("realStar.confer()");
    }

    @Override
    public void signContract() {
        System.out.println("realStar.signContract()");
    }

    @Override
    public void bookTicket() {
        System.out.println("realStar.bookTicket()");
    }

    @Override
    public void sing() {
        System.out.println("realStar.sing()---->jdk真实对象演唱");
    }

    @Override
    public void collectMoney() {
        System.out.println("realStar.collectMoney()");
    }
}
