package cn.mylava._300._8_GOF._07_Bridge.nopartten;

/**
 * comment: 客户端
 * 思考：服务端没有将变化因素抽象，如果新增其他类型信息处理器，又要新增具体实现类，将会导致代码臃肿
 *
 * @author: lipengfei
 * @date: 22/01/2018
 */
public class Client {
    public static void main(String[] args) {
        //普通站内消息
        MessageProcessor innerCommonMsg = new InnerCommonMsg();
        innerCommonMsg.sendMessage();

        //加急邮件
        MessageProcessor urgentMail = new UrgentMail();
        urgentMail.sendMessage();

    }
}
