package cn.mylava._300._8_GOF._14_Mediator;

/**
 * comment: 市场部
 *
 * @author: lipengfei
 * @date: 26/01/2018
 */
public class Market implements Department {
    private Mediator m;

    public Market(Mediator m) {
        this.m = m;
        m.register("market",this);
    }

    @Override
    public void selfAction() {
        System.out.println("努力跑订单");
    }

    @Override
    public void outAction() {
        System.out.println("汇报工作：接到项目啦，赶紧让研发做项目！");
    }
}
