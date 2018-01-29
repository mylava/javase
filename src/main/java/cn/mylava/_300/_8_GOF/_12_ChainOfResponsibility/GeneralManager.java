package cn.mylava._300._8_GOF._12_ChainOfResponsibility;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 24/01/2018
 */
public class GeneralManager extends Leader {
    public GeneralManager(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveRequest request) {
        if (request.getLeaveDays()<30) {
            System.out.println("员工："+request.getName()+"请假,天数:"+request.getLeaveDays()+"，理由:"+request.getReason()+"！");
            System.out.println("总经理:"+this.name+"，审批通过");
        } else {
            System.out.println("员工："+request.getName()+"竟然请假"+request.getLeaveDays()+"天，不想干了吧！");
        }
    }
}
