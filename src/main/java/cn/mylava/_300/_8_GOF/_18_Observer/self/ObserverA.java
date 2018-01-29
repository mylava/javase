package cn.mylava._300._8_GOF._18_Observer.self;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 26/01/2018
 */
public class ObserverA implements Observer {
    //mystate的值需要跟目标对象的值保持一致
    private int mystate;

    public int getMystate() {
        return mystate;
    }

    public void setMystate(int mystate) {
        this.mystate = mystate;
    }

    @Override
    public void update(Subject subject) {
        mystate = ((SubjectA)subject).getState();
    }
}
