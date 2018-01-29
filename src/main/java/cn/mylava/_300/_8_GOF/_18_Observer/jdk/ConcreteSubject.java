package cn.mylava._300._8_GOF._18_Observer.jdk;

import java.util.Observable;

/**
 * comment: 目标对象，继承Observable对象
 *
 * @author: lipengfei
 * @date: 29/01/2018
 */
public class ConcreteSubject extends Observable {
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        //目标对象做了更改
        setChanged();
        //通知所有观察者
        notifyObservers(state);
    }


}
