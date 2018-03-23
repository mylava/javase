package cn.mylava._300._8_GOF._15_Strategy.payment;

/**
 * comment: 支付结果
 *
 * @author: lipengfei
 * @date: 21/03/2018
 */
public class PayState {
    //状态码
    private int code;
    //交易详情数据
    private Object data;

    private String msg;

    public PayState(int code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("PayState{");
        sb.append("code=").append(code);
        sb.append(", data=").append(data);
        sb.append(", msg='").append(msg).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
