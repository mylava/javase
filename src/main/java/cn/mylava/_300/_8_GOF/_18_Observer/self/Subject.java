package cn.mylava._300._8_GOF._18_Observer.self;

import java.util.ArrayList;
import java.util.List;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 26/01/2018
 */
public class Subject {
    protected List<Observer> list = new ArrayList<>();

    public void register(Observer observer) {
        list.add(observer);
    }

    public void remove(Observer observer){
        list.remove(observer);
    }

    public void notifyAllObservers() {
        for (Observer observer : list) {
            observer.update(this);
        }
    }
}
