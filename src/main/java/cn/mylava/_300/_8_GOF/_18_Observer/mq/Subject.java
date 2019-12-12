package cn.mylava._300._8_GOF._18_Observer.mq;

import java.util.HashMap;
import java.util.Map;

/**
 * comment: 消息对象   放入消息队列中的bean
 *
 * @author: lipengfei
 * @date: 26/01/2018
 */
public class Subject {
    private int state; // 0生产  1消费
    protected Map<Integer,Observer> map = new HashMap<>();

    public Subject(Observer provider, Observer consumer) {
        this.map.put(0,consumer);
        this.map.put(1,provider);
    }

//    public void register(Observer observer) {
//        list.add(observer);
//    }

//    public void remove(Observer observer){
//        list.remove(observer);
//    }


    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notify(this.state);
    }

    public void notify(int state) {
        map.get(state).response(state);
    }
}
