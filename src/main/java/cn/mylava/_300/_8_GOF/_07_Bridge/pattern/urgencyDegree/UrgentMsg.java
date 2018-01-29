package cn.mylava._300._8_GOF._07_Bridge.pattern.urgencyDegree;

import cn.mylava._300._8_GOF._07_Bridge.pattern.type.MessageTypeProcessor;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 22/01/2018
 */
public class UrgentMsg extends MessageProcessor {
    public UrgentMsg(MessageTypeProcessor typeProcessor) {
        super(typeProcessor);
    }

    @Override
    public void sendMessage() {
        typeProcessor.typeProcess();
        System.out.println("urgent 消息处理");
    }
}
