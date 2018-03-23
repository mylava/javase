package cn.mylava._300._8_GOF._15_Strategy.amount1;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 26/01/2018
 */
public class GoldMember implements Strategy{
    @Override
    public double getPrice(double standardPrice) {
        System.out.println("金牌会员，8折");
        return standardPrice*0.8;
    }
}
