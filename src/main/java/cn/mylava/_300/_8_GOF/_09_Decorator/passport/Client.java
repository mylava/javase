package cn.mylava._300._8_GOF._09_Decorator.passport;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 27/03/2018
 */
public class Client {
    public static void main(String[] args) {
        ISigninForThird signinForThird = new SigninForThird(new Signin());

        ResultMsg resultMsg = signinForThird.loginForQQ("12345678");
        System.out.println(resultMsg);
    }
}
