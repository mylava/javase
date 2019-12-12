package cn.mylava._300._8_GOF._05_Adapter.passport;

/**
 * comment: 老的登录接口(adaptee)，使用用户名和密码注册、登录，很稳定，已有大量用户
 *
 * @author: lipengfei
 * @date: 27/03/2018
 */
@Deprecated
public class Signin {
    /**
     * 注册方法
     * @param username
     * @param password
     * @return
     */
    public ResultMsg regist(String username,String password) {
        return new ResultMsg(200,"注册成功",new Member(username,password));
    }

    /**
     * 登录方法
     * @param username
     * @param password
     * @return
     */
    public ResultMsg login(String username,String password) {
        System.out.println("执行登录判断……");
        if (username.contains("QQ")) {
            return new ResultMsg(200,"用户登录成功","QQ授权登录");
        }
        return null;
    }
}
