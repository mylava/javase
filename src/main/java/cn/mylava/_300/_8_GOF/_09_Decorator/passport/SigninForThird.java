package cn.mylava._300._8_GOF._09_Decorator.passport;

/**
 * comment: 后期添加的适配器，用于适配第三方账号登录
 *
 * @author: lipengfei
 * @date: 27/03/2018
 */
public class SigninForThird implements ISigninForThird {
    private ISignin iSignin;

    public SigninForThird(ISignin iSignin) {
        this.iSignin = iSignin;
    }

    @Override
    public ResultMsg regist(String username, String password) {
        return iSignin.regist(username,password);
    }

    @Override
    public ResultMsg login(String username, String password) {
        return iSignin.login(username,password);
    }

    public ResultMsg loginForQQ(String openId) {
        //1.openId是全局唯一，可以使用 渠道+openId 作为一个用户名
        openId = "QQ"+openId;//可以使用枚举
        //2.密码默认为QQ_EMPTY
        String pwd = "QQ_EMPTY";//可以使用枚举
        //3.注册(在原有的系统里面创建一个用户)
        ResultMsg registMsg = this.regist(openId, pwd);
        //4.调用原来的登录方法
        ResultMsg loginMsg = this.login(openId, pwd);
        return loginMsg;
    }

    public ResultMsg loginForWechat(String openId) {
        //实现思路同QQ登录
        return null;
    }

    public ResultMsg loginForToken(String openId) {
        //通过token拿到用户信息，再重新登录一次即可
        return null;
    }

    public ResultMsg loginForTelphone(String telphone, String code) {
        //手机号作为用户名，密码为空
        return null;
    }

    //注册后直接登录
    public ResultMsg loginForRegist(String username, String password) {
        ResultMsg registMsg = this.regist(username, password);
        //4.调用原来的登录方法
        ResultMsg loginMsg = this.login(username, password);
        return loginMsg;
    }

}
