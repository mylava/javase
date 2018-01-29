package cn.mylava._300._8_GOF._03_Builder;

import cn.mylava._300._8_GOF._03_Builder.builder.AirShipBuilder;
import cn.mylava._300._8_GOF._03_Builder.builder.Shenzhou1Builder;
import cn.mylava._300._8_GOF._03_Builder.director.AirShipDirector;
import cn.mylava._300._8_GOF._03_Builder.director.Shenzhou1Director;
import cn.mylava._300._8_GOF._03_Builder.module.AirShip;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 17/01/2018
 */
public class Client {
    public static void main(String[] args) {
        AirShipBuilder builder = new Shenzhou1Builder();
        AirShipDirector director = new Shenzhou1Director(builder);
        AirShip shenzhou1 = director.directAirShip();
        System.out.println(shenzhou1.getEngine().getName());
        System.out.println(shenzhou1.getEscapeTower().getName());
        System.out.println(shenzhou1.getOrbitalModule().getName());

        //具体的业务逻辑
        shenzhou1.launch();
    }
}
