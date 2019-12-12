package cn.mylava._300._8_GOF._17_State.pattern.tv_state;

/**
 * comment: 定义状态上下文环境，用来切换状态，可以理解为状态的代理
 *
 * @author: lipengfei
 * @date: 01/08/2019
 */
public class TvContext {
    TvState tvState;

    public void setTvState(TvState tvState) {
        this.tvState = tvState;
    }

    public void  powerOn() {
        System.out.println("开机操作，这里可以执行一些before check");
        setTvState(new PowerOnState());
        System.out.println("开机操作，这里可以执行一些after action");
    }

    public void  powerOff() {
        System.out.println("关机操作，这里可以执行一些before check");
        setTvState(new PowerOffState());
        System.out.println("关机操作，这里可以执行一些after action");
    }

    public void nextChannel() {
        tvState.nextChannel();
    }

    public void prevChannel() {
        tvState.prevChannel();
    }

    public void turnUp() {
        tvState.turnUp();
    }

    public void turnDown() {
        tvState.turnDown();
    }
}
