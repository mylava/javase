package cn.mylava._300._8_GOF._15_Strategy.amount1;

/**
 * comment: 模拟购物折扣计算,策略对象：会员类型
 *
 * @author: lipengfei
 * @date: 26/01/2018
 */
public class Client {
    public static void main(String[] args) {
        Strategy common = new CommonMember();
        Context ctx = new Context(common);

        ctx.printPrice(998);
    }
}
