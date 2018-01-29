package cn.mylava._300._8_GOF._07_Bridge.nopartten;

/**
 * comment: 发送消息的组件
 * 需求：1.可以发送普通消息、加急消息和特急消息
 *      2.可以支持多种方式如：站内信、邮件、手机短信等
 * 思考：消息组件中可能扩展的地方：消息的类型：如增加严重级别的消息
 *      发送方式：通过WebService通知“核心系统”某消息
 * @author: lipengfei
 * @date: 22/01/2018
 */
public interface MessageProcessor {
    void sendMessage();
}
//普通消息处理器
class CommonMsg implements MessageProcessor {
    @Override
    public void sendMessage() {
        System.out.println("发送普通消息处理，具体业务逻辑处理中.....");
    }
}
//加急消息处理器
class UrgentMsg implements MessageProcessor {
    @Override
    public void sendMessage() {
        System.out.println("发送加急消息处理，具体业务逻辑处理中.....");
    }
}
//普通站内信------->缺点：违反单一原则，有两个引起类变化的原因：消息紧急程度、消息类型，不能封装到一个类中
class InnerCommonMsg extends CommonMsg {
    @Override
    public void sendMessage() {
        System.out.println("发送Common InnerMsg处理，具体业务逻辑处理中.....");
    }
}
//加急站内信
class UrgentCommonMsg extends UrgentMsg {
    @Override
    public void sendMessage() {
        System.out.println("发送Urgent InnerMsg处理，具体业务逻辑处理中.....");
    }
}

//普通邮件处理器
class InnerMail extends CommonMsg {
    @Override
    public void sendMessage() {
        System.out.println("发送Common Mail处理，具体业务逻辑处理中.....");
    }
}
//加急邮件处理器
class UrgentMail extends UrgentMsg {
    @Override
    public void sendMessage() {
        System.out.println("发送Urgent Mail处理，具体业务逻辑处理中.....");
    }
}



