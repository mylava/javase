package cn.mylava._300._8_GOF._12_ChainOfResponsibility;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 24/01/2018
 */
public abstract class Leader {
    protected String name;
    protected Leader nextLeader;

    public Leader(String name) {
        this.name = name;
    }

    public void setNextLeader(Leader nextLeader) {
        this.nextLeader = nextLeader;
    }
    //处理请假请求
    public abstract void handleRequest(LeaveRequest request);
}
