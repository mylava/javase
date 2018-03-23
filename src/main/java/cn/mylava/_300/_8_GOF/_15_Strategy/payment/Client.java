package cn.mylava._300._8_GOF._15_Strategy.payment;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 21/03/2018
 */
public class Client {
    public static void main(String[] args) {
        Order order = new Order("1","2018032100001",123.45);
        //有多种支付方式，微信支付、支付宝、银联卡等等
        //每个支付渠道的具体算法是不一样的
//        PayState payState = order.pay(PayType.ALI_PAY);
        PayState payState = order.pay(PayType.WECHAT_PAY);
        System.out.println(payState);
    }
}
