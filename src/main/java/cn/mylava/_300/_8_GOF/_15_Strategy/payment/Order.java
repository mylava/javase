package cn.mylava._300._8_GOF._15_Strategy.payment;

/**
 * comment: 订单类
 *
 * @author: lipengfei
 * @date: 21/03/2018
 */
public class Order {
    //用户号
    private String uid;
    //订单号
    private String orderId;
    //金额
    private double amount;

    public Order(String uid, String orderId, double amount) {
        this.uid = uid;
        this.orderId = orderId;
        this.amount = amount;
    }

    public PayState pay(PayType payType) {
        return payType.get().pay(uid,amount);
    }
}
