package cn.mylava._300._8_GOF._09_Decorator.passport;

/**
 * comment: 将适配器模式中的Signin类抽象出一个接口
 *
 * @author: lipengfei
 * @date: 27/03/2018
 */
public interface ISignin {
    /**
     * 注册方法
     * @param username
     * @param password
     * @return
     */
    public ResultMsg regist(String username, String password);

    /**
     * 登录方法
     * @param username
     * @param password
     * @return
     */
    public ResultMsg login(String username, String password);
}
