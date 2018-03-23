package cn.mylava._300._8_GOF._15_Strategy.payment;

/**
 * comment: 支付渠道
 *
 * @author: lipengfei
 * @date: 21/03/2018
 */
public interface Payment {
    public PayState pay(String uid,double amount);
}
