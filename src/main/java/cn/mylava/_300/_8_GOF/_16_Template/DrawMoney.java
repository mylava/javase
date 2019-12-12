package cn.mylava._300._8_GOF._16_Template;

/**
 * comment: 取款业务
 *
 * @author: lipengfei
 * @date: 26/01/2018
 */
public class DrawMoney extends BankTemplateMethod {
    @Override
    protected void transact() {
        System.out.println("2.办理取款业务");
    }
}
