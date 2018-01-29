package cn.mylava._300._8_GOF._12_ChainOfResponsibility;

/**
 * comment: 请假条
 *
 * @author: lipengfei
 * @date: 24/01/2018
 */
public class LeaveRequest {
    //请假人
    private String name;
    //天数
    private int leaveDays;
    //原因
    private String reason;

    public LeaveRequest(String name, int leaveDays, String reason) {
        this.name = name;
        this.leaveDays = leaveDays;
        this.reason = reason;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLeaveDays() {
        return leaveDays;
    }

    public void setLeaveDays(int leaveDays) {
        this.leaveDays = leaveDays;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
