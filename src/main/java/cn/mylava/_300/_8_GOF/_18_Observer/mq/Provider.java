package cn.mylava._300._8_GOF._18_Observer.mq;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 04/05/2018
 */
public class Provider implements Observer {
    @Override
    public void response(int state) {
        System.out.println("provider收到通知 消息bean状态为:"+state);
    }
}
