package cn.mylava._300._8_GOF._15_Command;

/**
 * comment: 命令调用者
 *
 * @author: lipengfei
 * @date: 26/01/2018
 */
public class Invoker {
    //也可以通过容器容纳很多命令，进而组织成为批处理。数据库底层的事务管理就是类似的结构。
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void Call() {
        //可以在命令执行前后添加相关操作，如记录状态
        System.out.println("记录命令调用者……");
        command.execute();
    }
}
