package cn.mylava._300._8_GOF._10_Facade;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 24/01/2018
 */
public class Client {
    public static void main(String[] args) {
        Computer computer = new MacComputer();

        computer.start();
    }
}
