package cn.mylava._300._162_Decorator;

/**
 * 扩音器
 * 装饰模式  装饰类，对Voice功能进行增强
 * @author lipengfei
 */
public class LoudSpeaker {
    private Voice voice;

    public LoudSpeaker() {
    }

    public LoudSpeaker(Voice voice) {
        this.voice = voice;
    }

    public void say() {
        System.out.println(voice.getVolume()*1000);
    }
}
