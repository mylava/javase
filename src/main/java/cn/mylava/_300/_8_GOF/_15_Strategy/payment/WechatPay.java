package cn.mylava._300._8_GOF._15_Strategy.payment;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 21/03/2018
 */
public class WechatPay implements Payment {
    @Override
    public PayState pay(String uid, double amount) {
        System.out.println("使用[微信支付算法]支付");
        return new PayState(200,amount,"微信支付成功");
    }
}
