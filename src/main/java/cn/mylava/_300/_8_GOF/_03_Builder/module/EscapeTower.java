package cn.mylava._300._8_GOF._03_Builder.module;

/**
 * comment: 逃逸塔
 *
 * @author: lipengfei
 * @date: 17/01/2018
 */
public class EscapeTower {
    public String name;

    public EscapeTower(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
