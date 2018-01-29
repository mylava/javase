package cn.mylava._300._8_GOF._07_Bridge.pattern.urgencyDegree;

import cn.mylava._300._8_GOF._07_Bridge.pattern.type.MessageTypeProcessor;

/**
 * comment: 变化的一部分：消息紧急程度
 *
 * @author: lipengfei
 * @date: 22/01/2018
 */
public abstract class MessageProcessor {
    MessageTypeProcessor typeProcessor;

    MessageProcessor(MessageTypeProcessor typeProcessor) {
        this.typeProcessor = typeProcessor;
    }

    public abstract void sendMessage();
}
