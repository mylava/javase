package cn.mylava._300._8_GOF._07_Bridge.pattern.type;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 22/01/2018
 */
public class Inner implements MessageTypeProcessor {
    @Override
    public void typeProcess() {
        System.out.println("inner 消息处理");
    }
}
