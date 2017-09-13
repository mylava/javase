package cn.mylava._300._4_Thread._181_ProducerConsumer;

/**
 * @author lipengfei
 */
public class App {
    public static void main(String[] args) {
        Movie m = new Movie();

        Player p = new Player(m);
        Watcher w = new Watcher(m);

        new Thread(p).start();
        new Thread(w).start();

    }
}
