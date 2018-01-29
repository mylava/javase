package cn.mylava._300._8_GOF._15_Command;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 26/01/2018
 */
public class Client {
    public static void main(String[] args) {
        Command command = new ConcreteCommand(new Receiver());
        Invoker invoker = new Invoker(command);

        invoker.Call();
    }
}
