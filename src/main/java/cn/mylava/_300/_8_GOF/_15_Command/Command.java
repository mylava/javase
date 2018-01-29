package cn.mylava._300._8_GOF._15_Command;

/**
 * comment: 命令接口
 *
 * @author: lipengfei
 * @date: 26/01/2018
 */
public interface Command {
    /**
     * 实际项目中，可以根据需求涉及多个不同的方法
     */
    void execute();
}
