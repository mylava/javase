package cn.mylava._300._8_GOF._03_Builder.director;

import cn.mylava._300._8_GOF._03_Builder.builder.AirShipBuilder;
import cn.mylava._300._8_GOF._03_Builder.module.AirShip;
import cn.mylava._300._8_GOF._03_Builder.module.Engine;
import cn.mylava._300._8_GOF._03_Builder.module.EscapeTower;
import cn.mylava._300._8_GOF._03_Builder.module.OrbitalModule;

/**
 * comment: 神州一号装配器
 *
 * @author: lipengfei
 * @date: 17/01/2018
 */
public class Shenzhou1Director implements AirShipDirector{
    private AirShipBuilder builder;

    public Shenzhou1Director(AirShipBuilder builder) {
        this.builder = builder;
    }

    @Override
    public AirShip directAirShip() {
        Engine engine = builder.builderEngine();
        OrbitalModule orbitalModule = builder.builderOrbitalModule();
        EscapeTower escapeTower = builder.builderEscapeTower();
        AirShip airShip = new AirShip();
        airShip.setEngine(engine);
        airShip.setOrbitalModule(orbitalModule);
        airShip.setEscapeTower(escapeTower);
        return airShip;
    }
}
