package cn.mylava._300._8_GOF._18_Observer.jdk;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 29/01/2018
 */
public class Client {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();

        ConcreteObserver observer1 = new ConcreteObserver();
        ConcreteObserver observer2 = new ConcreteObserver();
        ConcreteObserver observer3 = new ConcreteObserver();

        subject.addObserver(observer1);
        subject.addObserver(observer2);
        subject.addObserver(observer3);

        subject.setState(3000);

        subject.deleteObserver(observer1);

        subject.setState(5000);
    }
}
