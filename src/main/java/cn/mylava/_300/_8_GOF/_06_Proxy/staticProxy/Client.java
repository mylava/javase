package cn.mylava._300._8_GOF._06_Proxy.staticProxy;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 22/01/2018
 */
public class Client {
    public static void main(String[] args) {
        Star proxy = new ProxyStar(new RealStar());

        proxy.confer();
        proxy.signContract();
        proxy.bookTicket();
        proxy.sing();
        proxy.collectMoney();
    }
}
