package cn.mylava._300._8_GOF._18_Observer.self;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 26/01/2018
 */
public class SubjectA extends Subject {
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        super.notifyAllObservers();
    }
}
