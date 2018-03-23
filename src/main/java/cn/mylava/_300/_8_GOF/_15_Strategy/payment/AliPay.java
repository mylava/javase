package cn.mylava._300._8_GOF._15_Strategy.payment;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 21/03/2018
 */
public class AliPay implements Payment {
    @Override
    public PayState pay(String uid, double amount) {
        System.out.println("使用[支付宝算法]支付");
        return new PayState(200,amount,"支付宝支付成功");
    }
}
