package cn.mylava._300._8_GOF._10_Facade;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 24/01/2018
 */
public class KingstonMemory implements Memory {
    @Override
    public void read() {
        System.out.println("kingston memory read...");
    }

    @Override
    public void write() {
        System.out.println("kingston memory write...");
    }
}
