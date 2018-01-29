package cn.mylava._300._8_GOF._03_Builder.module;

/**
 * comment: 建造者模式  飞船由各个模块组成
 *
 * @author: lipengfei
 * @date: 17/01/2018
 */
public class AirShip {
    private OrbitalModule orbitalModule;
    private Engine engine;
    private EscapeTower escapeTower;

    public OrbitalModule getOrbitalModule() {
        return orbitalModule;
    }

    public void setOrbitalModule(OrbitalModule orbitalModule) {
        this.orbitalModule = orbitalModule;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public EscapeTower getEscapeTower() {
        return escapeTower;
    }

    public void setEscapeTower(EscapeTower escapeTower) {
        this.escapeTower = escapeTower;
    }

    //具体的业务逻辑
    public void launch() {
        System.out.println("火箭发射--->调用引擎--->进入轨道-->进入逃逸塔");
    }
}
