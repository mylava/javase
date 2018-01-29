package cn.mylava._300._8_GOF._03_Builder.builder;

import cn.mylava._300._8_GOF._03_Builder.module.Engine;
import cn.mylava._300._8_GOF._03_Builder.module.EscapeTower;
import cn.mylava._300._8_GOF._03_Builder.module.OrbitalModule;

/**
 * comment: 神州一号构造器
 *
 * @author: lipengfei
 * @date: 17/01/2018
 */
public class Shenzhou1Builder implements AirShipBuilder{//常见的有StringBuilder，DomBuilder，SaxBuilder
    @Override
    public Engine builderEngine() {
        //这里是直接new出来的，通常是和工厂模式结合起来，这里从工厂获取
        return new Engine("神州一号发动机");
    }

    @Override
    public OrbitalModule builderOrbitalModule() {
        //这里是直接new出来的，通常是和工厂模式结合起来，这里从工厂获取
        return new OrbitalModule("神州一号轨道舱");
    }

    @Override
    public EscapeTower builderEscapeTower() {
        //这里是直接new出来的，通常是和工厂模式结合起来，这里从工厂获取
        return new EscapeTower("神州一号逃逸塔");
    }
}
