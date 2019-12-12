package cn.mylava._300._8_GOF._18_Observer.gupao;

import java.lang.reflect.Method;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 30/03/2018
 */
public class Client {
    public static void main(String[] args) {
        try {
            //观察者
            Observer observer = new Observer();
            Method method = Observer.class.getMethod("advice",new Class[]{Event.class});
            //被观察者
            Subject subject = new Subject();
            subject.addListener(EventType.ON_ADD,observer,method);


            subject.add();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }


    }
}
