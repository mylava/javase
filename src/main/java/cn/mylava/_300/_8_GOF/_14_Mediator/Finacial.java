package cn.mylava._300._8_GOF._14_Mediator;

/**
 * comment:财务部
 *
 * @author: lipengfei
 * @date: 26/01/2018
 */
public class Finacial implements Department {
    private Mediator m;

    public Finacial(Mediator m) {
        this.m = m;
        m.register("finacial",this);
    }

    @Override
    public void selfAction() {
        System.out.println("给xx部门发钱");
    }

    @Override
    public void outAction() {
        System.out.println("汇报工作：1.钱太多了，怎么花？ 2.市场部该收项目款啦！");
    }
}
