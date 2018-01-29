package cn.mylava._300._8_GOF._08_Composite;

/**
 * comment: 抽象组件
 *
 * @author: lipengfei
 * @date: 24/01/2018
 */
public interface AbstractFile {
    void killvirus();
}

//具体的文件是叶子组件
class ImageFile implements AbstractFile {
    private String name;

    public ImageFile(String name) {
        this.name = name;
    }

    @Override
    public void killvirus() {
        System.out.println("---------图像文件"+name+",进行查杀！");
    }
}
//具体的文件是叶子组件
class TxtFile implements AbstractFile {

    private String name;

    public TxtFile(String name) {
        this.name = name;
    }

    @Override
    public void killvirus() {
        System.out.println("---------文本文件"+name+",进行查杀！");
    }
}
//具体的文件是叶子组件
class VedioFile implements AbstractFile {
    private String name;

    public VedioFile(String name) {
        this.name = name;
    }

    @Override
    public void killvirus() {
        System.out.println("---------影像 文件"+name+",进行查杀！");
    }
}