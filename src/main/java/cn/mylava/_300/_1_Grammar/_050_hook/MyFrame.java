package cn.mylava._300._1_Grammar._050_hook;

/**
 * 16/3/14.
 */
public class MyFrame {
    public void paint() {
        System.out.println("MyFrame.paint()");
    }
}

class GameFrame extends MyFrame{
    @Override
    public void paint() {
        System.out.println("GameFrame.paint()");
    }
}