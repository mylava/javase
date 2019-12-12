package cn.mylava._300._8_GOF._18_Observer.gupao;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 30/03/2018
 */
public class Subject extends EventListener{
    //通常使用动态代理实现事件日志记录，避免代码侵入，这里使用观察者只是为了演示
    public void add() {
        System.out.println("添加方法");
        trigger(EventType.ON_ADD);
    }

    public void remove() {
        System.out.println("删除方法");
        trigger(EventType.ON_REMOVE);
    }


}
