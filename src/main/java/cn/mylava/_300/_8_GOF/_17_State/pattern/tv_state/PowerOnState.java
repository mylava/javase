package cn.mylava._300._8_GOF._17_State.pattern.tv_state;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 01/08/2019
 */
public class PowerOnState implements TvState {
    @Override
    public void nextChannel() {
        System.out.println("切换到下一个频道");
    }

    @Override
    public void prevChannel() {
        System.out.println("切换到上一个频道");
    }

    @Override
    public void turnUp() {
        System.out.println("调高音量");
    }

    @Override
    public void turnDown() {
        System.out.println("调低音量");
    }
}
