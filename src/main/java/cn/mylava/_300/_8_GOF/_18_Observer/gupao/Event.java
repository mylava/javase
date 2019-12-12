package cn.mylava._300._8_GOF._18_Observer.gupao;

import java.lang.reflect.Method;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 30/03/2018
 */
public class Event {
    //事件源（事件发起者），被观察者
    private EventListener subject;
    //通知目标，观察者
    private Observer observer;
    //回调的观察者方法
    private Method callback;
    //触发事件
    private EventType eventType;

    public Event(Observer observer, Method callback) {
        this.observer = observer;
        this.callback = callback;
    }

    public EventListener getSubject() {
        return subject;
    }

    public Event setSubject(EventListener subject) {
        this.subject = subject;
        return this;
    }

    public Observer getObserver() {
        return observer;
    }

    public Event setObserver(Observer observer) {
        this.observer = observer;
        return this;
    }

    public Method getCallback() {
        return callback;
    }

    public Event setCallback(Method callback) {
        this.callback = callback;
        return this;
    }

    public EventType getEventType() {
        return eventType;
    }

    public Event setEventType(EventType eventType) {
        this.eventType = eventType;
        return this;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Event{");
        sb.append("subject=").append(subject).append("\n");
        sb.append(", observer=").append(observer).append("\n");
        sb.append(", callback=").append(callback).append("\n");
        sb.append(", eventType=").append(eventType).append("\n");
        sb.append('}');
        return sb.toString();
    }
}
