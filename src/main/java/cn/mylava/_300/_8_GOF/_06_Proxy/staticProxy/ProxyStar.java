package cn.mylava._300._8_GOF._06_Proxy.staticProxy;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 22/01/2018
 */
public class ProxyStar implements Star {
    private RealStar realStar;

    public ProxyStar(RealStar realStar) {
        this.realStar = realStar;
    }

    @Override
    public void confer() {
        System.out.println("proxyStar.confer()");
    }

    @Override
    public void signContract() {
        System.out.println("proxyStar.signContract()");
    }

    @Override
    public void bookTicket() {
        System.out.println("proxyStar.bookTicket()");
    }

    @Override
    public void sing() {
        realStar.sing();
    }

    @Override
    public void collectMoney() {
        System.out.println("proxyStar.collectMoney()");
    }
}
