package cn.mylava._300._8_GOF._18_Observer.gupao;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * comment: 被观察者父类，定义容器与接口
 *
 * @author: lipengfei
 * @date: 30/03/2018
 */
public class EventListener {
    //观察者容器  只能添加一个观察者，添加多个可以将Event改为容器
    protected Map<EventType,Event> events = new HashMap<>();

    //针对某个事件，添加监听
    public void addListener(EventType eventType, Observer observer, Method callback) {
        //注册事件
        events.put(eventType,new Event(observer,callback));
    }

    //触发监听事件
    protected void trigger(EventType eventType) {
        if (!this.events.containsKey(eventType)) {
            return;
        }
        this.trigger(this.events.get(eventType).setEventType(eventType));
    }
    //具体事件的处理
    private void trigger(Event event) {
        event.setSubject(this);
        try {
            event.getCallback().invoke(event.getObserver(),event);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
