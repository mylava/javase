package cn.mylava._300._8_GOF._05_Adapter.passport;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 27/03/2018
 */
public class Client {
    public static void main(String[] args) {
        SigninForThird service = new SigninForThird();
        //这里可以添加一层策略模式
        ResultMsg resultMsg = service.loginForQQ("12345678");
        System.out.println(resultMsg);
    }
}
