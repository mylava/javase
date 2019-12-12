package cn.mylava._300._8_GOF._17_State.pattern.tv_state;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 01/08/2019
 */
public class Client {
    public static void main(String[] args) {
        TvContext context = new TvContext();
        context.powerOn();
        context.nextChannel();
        context.turnDown();

        context.powerOff();
        context.prevChannel();
    }
}
