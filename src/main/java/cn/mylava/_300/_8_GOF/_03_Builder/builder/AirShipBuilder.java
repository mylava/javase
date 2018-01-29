package cn.mylava._300._8_GOF._03_Builder.builder;

import cn.mylava._300._8_GOF._03_Builder.module.Engine;
import cn.mylava._300._8_GOF._03_Builder.module.EscapeTower;
import cn.mylava._300._8_GOF._03_Builder.module.OrbitalModule;

/**
 * comment: 飞船构造器
 *
 * @author: lipengfei
 * @date: 17/01/2018
 */
public interface AirShipBuilder {
    Engine builderEngine();
    OrbitalModule builderOrbitalModule();
    EscapeTower builderEscapeTower();
}
