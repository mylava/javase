package cn.mylava._300._8_GOF._17_State;

/**
 * comment:  上下文环境，名字改为Room更恰当，表示房间持有房间状态
 *
 * @author: lipengfei
 * @date: 26/01/2018
 */
public class Context {
    private RoomState state;

    public void setState(RoomState state) {
        System.out.println("修改状态");
        this.state = state;
        state.handle();
    }
}
