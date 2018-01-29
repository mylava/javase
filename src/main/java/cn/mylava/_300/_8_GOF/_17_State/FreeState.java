package cn.mylava._300._8_GOF._17_State;

/**
 * comment: 空闲状态的处理
 *
 * @author: lipengfei
 * @date: 26/01/2018
 */
public class FreeState implements RoomState {
    @Override
    public void handle() {
        System.out.println("房间空闲，可以进行[预定]或直接[入住]操作");
    }
}
