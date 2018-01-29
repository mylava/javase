package cn.mylava._300._8_GOF._08_Composite;

import java.util.ArrayList;
import java.util.List;

/**
 * comment: 文件夹，对应容器组件
 *
 * @author: lipengfei
 * @date: 24/01/2018
 */
public class Folder implements AbstractFile {
    private String name;
    //定义容器，用来存放子节点
    private List<AbstractFile> list = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void add(AbstractFile file) {
        list.add(file);
    }

    public void remove(AbstractFile file) {
        list.remove(file);
    }

    public AbstractFile getChild(int index) {
        return list.get(index);
    }

    @Override
    public void killvirus() {
        System.out.println("---------文件夹"+name+",进行查杀！");
        for (AbstractFile file : list) {
            file.killvirus();
        }
    }
}
