package cn.mylava._300._8_GOF._07_Bridge.pattern;

import cn.mylava._300._8_GOF._07_Bridge.pattern.type.Inner;
import cn.mylava._300._8_GOF._07_Bridge.pattern.type.Mail;
import cn.mylava._300._8_GOF._07_Bridge.pattern.urgencyDegree.CommonMsg;
import cn.mylava._300._8_GOF._07_Bridge.pattern.urgencyDegree.MessageProcessor;
import cn.mylava._300._8_GOF._07_Bridge.pattern.urgencyDegree.UrgentMsg;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 22/01/2018
 */
public class Client {
    public static void main(String[] args) {
        //普通内部信
        MessageProcessor commonInner = new CommonMsg(new Inner());
        commonInner.sendMessage();

        //加急邮件
        MessageProcessor urgentMail = new UrgentMsg(new Mail());
        urgentMail.sendMessage();
    }
}
