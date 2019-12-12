package cn.mylava._300._8_GOF._18_Observer.event;

import java.lang.reflect.Method;

/**
 * comment: 事件源，被监听对象
 * 事件源发起事件，触发监听器
 *
 * @author: lipengfei
 * @date: 02/04/2018
 */
public class Mouse {
    private MouseListener listener;

    public Mouse(MouseListener listener) {
        this.listener = listener;
    }
    public MouseListener getListener() {
        return listener;
    }

    public void click() {
        System.out.println("-----------鼠标单击-----------");
        this.listener.trigger(MouseEventType.ON_CLICK);
    }

    public void dbClick() {
        System.out.println("-----------鼠标双击-----------");
        this.listener.trigger(MouseEventType.ON_DBCLICK);
    }

    public void addListener(MouseEventType mouseEventType, Target target, Method callback) {
        //添加监听的时候设置 触发对象、通知目标、回调方法
        listener.addListener(mouseEventType,this,target,callback);
    }
}
