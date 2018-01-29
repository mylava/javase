package cn.mylava._300._8_GOF._18_Observer.jdk;

import java.util.Observable;
import java.util.Observer;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 29/01/2018
 */
public class ConcreteObserver implements Observer{

    private int myState;

    @Override
    public void update(Observable o, Object arg) {
        myState = ((ConcreteSubject)o).getState();
    }

    public int getMyState() {
        return myState;
    }

    public void setMyState(int myState) {
        this.myState = myState;
    }
}
