package cn.mylava._300._3_IO._162_Decorator;

/**
 * 装饰模式   被装饰的类
 * @author lipengfei
 */
public class Voice {
    private int volume = 10;

    public Voice() {
    }
    public Voice(int volume) {
        this.volume = volume;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void say() {
        System.out.println(volume);
    }
}
