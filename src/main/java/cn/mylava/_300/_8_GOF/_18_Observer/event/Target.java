package cn.mylava._300._8_GOF._18_Observer.event;

/**
 * comment: 被通知者
 *
 * @author: lipengfei
 * @date: 02/04/2018
 */
public class Target {
    public void receive(MouseEvent event){
        System.out.println("收到通知，\n事件源为："+event.getSource()+"，\n事件类型为："+event.getMouseEventType()+
        ",\n通知目标为："+event.getTarget()+",\n回调方法为："+event.getCallback());
    }
}
