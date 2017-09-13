package cn.mylava._300._4_Thread._181_ProducerConsumer;

/**
 * 生产者
 * @author lipengfei
 */
public class Player implements Runnable{
    private Movie movie;

    public Player(Movie movie) {
        this.movie = movie;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (0==i%2) {
                movie.play(i+"<<<<<<<<<<左青龙");
            } else {
                movie.play(i+">>>>>>>>>>>>>>>右白虎");
            }
        }
    }
}
