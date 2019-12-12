package cn.mylava._300._8_GOF._09_Decorator.passport;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 27/03/2018
 */
public interface ISigninForThird extends ISignin{

    ResultMsg loginForQQ(String openId);

    ResultMsg loginForWechat(String openId);

    ResultMsg loginForToken(String openId);

    ResultMsg loginForTelphone(String telphone, String code);

    //注册后直接登录
    ResultMsg loginForRegist(String username, String password);
}
