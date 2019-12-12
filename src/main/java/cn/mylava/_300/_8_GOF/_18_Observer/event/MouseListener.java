package cn.mylava._300._8_GOF._18_Observer.event;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.EventListener;
import java.util.HashMap;
import java.util.Map;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 02/04/2018
 */
public class MouseListener implements EventListener {

    /**
     * 1.事件类型type和事件event一一对应，通过type可以查找到event，type用于对外交互，将具体事件封装隐藏起来
     * 2.将type和event封装到容器中，这个容器用于add/remove事件监听
     * 3.客户端通过type绑定callback方法，将callback方法封装到event事件中
     * 4.使用反射调用callback方法
     */

    protected Map<MouseEventType,MouseEvent> eventMap = new HashMap<>();

    //针对某个事件注册，添加监听
    public void addListener(MouseEventType mouseEventType, Mouse source, Target target, Method callback) {
        //添加监听的时候设置 触发对象、通知目标、回调方法
        eventMap.put(mouseEventType,new MouseEvent(source,target,callback));
    }

    //触发监听事件
    protected void trigger(MouseEventType mouseEventType) {
        if (!this.eventMap.containsKey(mouseEventType)) {
            System.out.println("事件类型"+ mouseEventType +"尚未注册！");
        } else {
            this.trigger(this.eventMap.get(mouseEventType).setMouseEventType(mouseEventType));
        }
    }
    //具体事件的处理
    private void trigger(MouseEvent mouseEvent) {
        try {
            mouseEvent.getCallback().invoke(mouseEvent.getTarget(), mouseEvent);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}