package cn.mylava._300._8_GOF._16_Template;

/**
 * comment: 通常实现模板方法采用匿名内部类实现
 *
 * @author: lipengfei
 * @date: 26/01/2018
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("外部类具体实现-----------");
        Bank bank1 = new DrawMoney();
        bank1.process();

        System.out.println("匿名内部类-----------");
        Bank bank2 = new BankTemplateMethod() {
            @Override
            public void transact() {
                System.out.println("2.办理存款业务");
            }
        };
        bank2.process();

    }
}
