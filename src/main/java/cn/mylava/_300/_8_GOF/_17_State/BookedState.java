package cn.mylava._300._8_GOF._17_State;

/**
 * comment: 已预订状态的处理
 *
 * @author: lipengfei
 * @date: 26/01/2018
 */
public class BookedState implements RoomState {
    @Override
    public void handle() {
        System.out.println("房间已预订，可以进行[入住]或[退房]操作");
    }
}
