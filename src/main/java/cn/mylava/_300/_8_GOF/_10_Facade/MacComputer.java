package cn.mylava._300._8_GOF._10_Facade;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 24/01/2018
 */
public class MacComputer extends Computer {

    public MacComputer() {
        cpu = new InterCPU();
        memory = new KingstonMemory();
        disk = new ToshibaDisk();
    }

    @Override
    public void start() {
        cpu.run();
        memory.read();
        memory.write();
        disk.read();
        disk.write();
    }
}
