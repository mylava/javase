package cn.mylava._300._8_GOF._03_Builder.module;

/**
 * comment: 飞船的轨道舱模块
 *
 * @author: lipengfei
 * @date: 17/01/2018
 */
public class OrbitalModule {
    private String name;

    public OrbitalModule(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
