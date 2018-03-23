package cn.mylava._300._8_GOF._15_Strategy.amount2;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 23/03/2018
 */
public class Client {
    public static void main(String[] args) {
        double price1 = StrategyFactory.getInstance().createStrategy(1000).getPrice(1000D);
        double price2 = StrategyFactory.getInstance().createStrategy(2000).getPrice(2000D);
        double price3 = StrategyFactory.getInstance().createStrategy(5000).getPrice(5000D);

        System.out.println(price1);
        System.out.println(price2);
        System.out.println(price3);
    }
}
