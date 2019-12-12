package cn.mylava._300._8_GOF._17_State.pattern.tv_state;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 01/08/2019
 */
public class PowerOffState implements TvState {
    @Override
    public void nextChannel() {
        System.out.println("关机状态，do nothing");
    }

    @Override
    public void prevChannel() {
        System.out.println("关机状态，do nothing");
    }

    @Override
    public void turnUp() {
        System.out.println("关机状态，do nothing");
    }

    @Override
    public void turnDown() {
        System.out.println("关机状态，do nothing");
    }
}
