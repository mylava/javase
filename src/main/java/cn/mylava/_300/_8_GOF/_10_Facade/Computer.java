package cn.mylava._300._8_GOF._10_Facade;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 24/01/2018
 */
public abstract class Computer {
    protected CPU cpu;
    protected Memory memory;
    protected Disk disk;

    abstract void start();
}
