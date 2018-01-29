package cn.mylava._300._8_GOF._15_Command;

/**
 * comment: 命令的具体实现
 *
 * @author: lipengfei
 * @date: 26/01/2018
 */
public class ConcreteCommand implements Command {
    private Receiver receiver;

    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        //执行命令前后可以进行相关的处理，比如记录日志，记录事务开始前后状态等
        System.out.println("记录命令执行前数据状态。。。");
        receiver.action();
    }
}
