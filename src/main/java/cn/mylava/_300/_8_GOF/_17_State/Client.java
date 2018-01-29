package cn.mylava._300._8_GOF._17_State;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 26/01/2018
 */
public class Client {
    public static void main(String[] args) {
        Context ctx = new Context();
        ctx.setState(new FreeState());
        ctx.setState(new BookedState());
        ctx.setState(new CheckedInState());
    }
}
