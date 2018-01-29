package cn.mylava._300._8_GOF._05_Adapter;

/**
 * comment: 客户端类，需要调用Adpatee类的process方法
 *
 * @author: lipengfei
 * @date: 22/01/2018
 */
public class Client {
    public void request(Target t) {
        t.process();
    }

    public static void main(String[] args) {
        Client c = new Client();

        Adapter t = new Adapter(new Adaptee());
        c.request(t);
    }
}
