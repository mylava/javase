package cn.mylava._300._8_GOF._08_Composite;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 24/01/2018
 */
public class Client {
    public static void main(String[] args) {
        AbstractFile f2,f3,f5,f6;
        Folder f1 = new Folder("我的收藏");
        f2 = new ImageFile("我的大头像.jpg");
        f3 = new TxtFile("hello.txt");
        f1.add(f2);
        f1.add(f3);

        Folder f4 = new Folder("电影");
        f5 = new VedioFile("英雄本色.mp4");
        f6 = new VedioFile("纵横四海.mp4");
        f4.add(f5);
        f4.add(f6);

        f1.add(f4);

        f1.killvirus();

    }
}
