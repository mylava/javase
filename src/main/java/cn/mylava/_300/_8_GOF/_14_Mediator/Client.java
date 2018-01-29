package cn.mylava._300._8_GOF._14_Mediator;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 26/01/2018
 */
public class Client {
    public static void main(String[] args) {
        Mediator m = new President();

        Department market = new Market(m);
        Department development = new Development(m);
        Department finacial = new Finacial(m);

        market.selfAction();
        market.outAction();
        m.command("development");
        development.outAction();
        m.command("finacial");
        finacial.outAction();
        m.command("market");


    }
}
