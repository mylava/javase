package cn.mylava._300._8_GOF._14_Mediator;

/**
 * comment: 部门接口
 *
 * @author: lipengfei
 * @date: 26/01/2018
 */
public interface Department {
    //做本部门的事情
    void selfAction();
    //向中介者发出申请，由中介者协调做某事
    void outAction();
}
