package cn.mylava._300._8_GOF._15_Strategy.payment;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 21/03/2018
 */
public class UnionPay implements Payment {
    @Override
    public PayState pay(String uid, double amount) {
        System.out.println("使用[银联支付算法]支付");
        return new PayState(200,amount,"银联支付成功");
    }
}
