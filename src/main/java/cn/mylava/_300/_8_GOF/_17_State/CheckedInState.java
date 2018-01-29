package cn.mylava._300._8_GOF._17_State;

/**
 * comment: 空闲状态的处理
 *
 * @author: lipengfei
 * @date: 26/01/2018
 */
public class CheckedInState implements RoomState {
    @Override
    public void handle() {
        System.out.println("房间已入住，可以进行[续房]或直接[退房]操作");
    }
}
