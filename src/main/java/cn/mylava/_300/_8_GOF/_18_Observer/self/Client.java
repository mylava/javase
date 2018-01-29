package cn.mylava._300._8_GOF._18_Observer.self;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 26/01/2018
 */
public class Client {
    public static void main(String[] args) {
        //目标对象
        SubjectA subject = new SubjectA();

        //观察者
        ObserverA obs1 = new ObserverA();
        ObserverA obs2 = new ObserverA();
        ObserverA obs3 = new ObserverA();
        subject.register(obs1);
        subject.register(obs2);
//        subject.register(obs3);

        //改变subject状态
        subject.setState(3000);

        System.out.println(obs1.getMystate());
        System.out.println(obs2.getMystate());
        System.out.println(obs3.getMystate());

        subject.register(obs3);

        subject.setState(5000);
        System.out.println(obs3.getMystate());


    }
}
