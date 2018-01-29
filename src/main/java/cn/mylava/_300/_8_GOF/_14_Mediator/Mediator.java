package cn.mylava._300._8_GOF._14_Mediator;

/**
 * comment: 中介者接口
 *
 * @author: lipengfei
 * @date: 26/01/2018
 */
public interface Mediator {
    //将部门注册到中介，中介就可以管理部门了
    void register(String dname,Department d);
    //向注册到中介者的部门发送命令，由不同部门执行
    void command(String dname);
}
