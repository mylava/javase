package cn.mylava._300._8_GOF._16_Template;

/**
 * comment: 银行办理业务的模板方法
 *
 * @author: lipengfei
 * @date: 26/01/2018
 */
public abstract class BankTemplateMethod {
    public void takeNumber() {
        System.out.println("1.取号排队");
    }
    //办理具体业务
    public abstract void transact();

    public void evaluate() {
        System.out.println("3.反馈评分");
    }
    //模板方法
    public final void process() {
        this.takeNumber();
        this.transact();
        this.evaluate();
    }
}
