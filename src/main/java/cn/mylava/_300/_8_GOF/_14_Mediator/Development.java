package cn.mylava._300._8_GOF._14_Mediator;

/**
 * comment: 研发部门
 *
 * @author: lipengfei
 * @date: 26/01/2018
 */
public class Development implements Department {
    //持有中介者的引用
    private Mediator m;
    //创建时传入
    public Development(Mediator m) {
        this.m = m;
        m.register("development",this);
    }

    @Override
    public void selfAction() {
        System.out.println("专心做项目");
    }

    @Override
    public void outAction() {
        System.out.println("汇报工作：申请活动资金，晚上打球！");
    }
}
