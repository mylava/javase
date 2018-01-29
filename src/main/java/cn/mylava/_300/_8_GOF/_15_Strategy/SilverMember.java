package cn.mylava._300._8_GOF._15_Strategy;

/**
 * comment: 银牌会员价格计算
 *
 * @author: lipengfei
 * @date: 26/01/2018
 */
public class SilverMember implements Strategy{
    @Override
    public double getPrice(double standardPrice) {
        System.out.println("银牌会员，9折");
        return standardPrice*0.9;
    }
}
