package cn.mylava._300._8_GOF._18_Observer.gupao;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 30/03/2018
 */
public class Observer {
    public void advice(Event event) {
        System.out.println("========触发事件，打印日志========\n"+event);
    }

}
