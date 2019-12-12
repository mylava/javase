package cn.mylava._300._8_GOF._17_State.pattern.tv_state;

/**
 * comment: 电视机状态
 *
 * @author: lipengfei
 * @date: 01/08/2019
 */
public interface TvState {
    void nextChannel();
    void prevChannel();
    void turnUp();
    void turnDown();
}
