package cn.mylava._300._8_GOF._18_Observer.event;

import java.lang.reflect.Method;

/**
 * comment: 时间驱动模型 事件基类
 *
 * @author: lipengfei
 * @date: 02/04/2018
 */
public class MouseEvent{
    //事件源（事件发起者）
    private Mouse source;
    //通知目标，观察者 如果需要多个目标，使用容器
    private Target target;
    //被通知目标回调方法
    private Method callback;
    //事件类型
    private MouseEventType mouseEventType;

    public MouseEvent(Mouse source, Target target, Method callback) {
        this.source=source;
        this.target=target;
        this.callback = callback;
    }

    public Mouse getSource() {
        return source;
    }

    public MouseEvent setSource(Mouse source) {
        this.source = source;
        return this;
    }

    public Target getTarget() {
        return target;
    }

    public MouseEvent setTarget(Target target) {
        this.target = target;
        return this;
    }

    public Method getCallback() {
        return callback;
    }

    public MouseEvent setCallback(Method callback) {
        this.callback = callback;
        return this;
    }

    public MouseEventType getMouseEventType() {
        return mouseEventType;
    }

    public MouseEvent setMouseEventType(MouseEventType mouseEventType) {
        this.mouseEventType = mouseEventType;
        return this;
    }
}
