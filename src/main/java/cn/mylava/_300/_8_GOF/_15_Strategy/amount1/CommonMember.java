package cn.mylava._300._8_GOF._15_Strategy.amount1;

/**
 * comment: 普通会员价格计算
 *
 * @author: lipengfei
 * @date: 26/01/2018
 */
public class CommonMember implements Strategy{
    @Override
    public double getPrice(double standardPrice) {
        System.out.println("普通会员，95折");
        return standardPrice*0.95;
    }
}
