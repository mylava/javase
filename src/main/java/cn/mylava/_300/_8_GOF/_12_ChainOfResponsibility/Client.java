package cn.mylava._300._8_GOF._12_ChainOfResponsibility;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 24/01/2018
 */
public class Client {
    public static void main(String[] args) {
        Leader a = new Director("张三");
        Leader b = new Manager("李四");
        Leader c = new GeneralManager("王五");
        //组织责任链对象关系-------生产环境通常通过配置文件注入责任链关系，也可以专门声明一个责任链对象，将这些关系封装到对象中
        a.setNextLeader(b);
        b.setNextLeader(c);

        //开始请假操作
        LeaveRequest request = new LeaveRequest("tom",5,"回家探亲");
        a.handleRequest(request);

    }
}
