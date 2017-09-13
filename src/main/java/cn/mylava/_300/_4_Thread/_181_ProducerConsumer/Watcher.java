package cn.mylava._300._4_Thread._181_ProducerConsumer;

/**
 * 消费者
 * @author lipengfei
 */
public class Watcher implements Runnable{
    private Movie movie;

    public Watcher(Movie movie) {
        this.movie = movie;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            movie.watch();
        }
    }
}
