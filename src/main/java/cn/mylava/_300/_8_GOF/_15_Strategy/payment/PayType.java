package cn.mylava._300._8_GOF._15_Strategy.payment;

/**
 * comment: 这里使用枚举类承担了上下文环境类的部分责任(与具体的策略类交互)
 *
 * @author: lipengfei
 * @date: 21/03/2018
 */
public enum PayType {
    //具体的支付形式还可以通过工厂获取 如：ALI_PAY(PayFactory.getAliPay())
    ALI_PAY(new AliPay()),
    WECHAT_PAY(new WechatPay()),
    UNION_PAY(new UnionPay());

    private Payment payment;

    PayType(Payment payment) {
        this.payment = payment;
    }

    public Payment get() {
        return payment;
    }
}
