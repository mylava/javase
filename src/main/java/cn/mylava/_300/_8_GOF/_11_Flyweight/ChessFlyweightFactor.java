package cn.mylava._300._8_GOF._11_Flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 24/01/2018
 */
public class ChessFlyweightFactor {
    //享元池
    private static Map<String,Chess> pool = new HashMap<>();

    public static Chess getChess(String color) {
        if (pool.get(color)!=null) {
            return pool.get(color);
        } else {
            Chess chess = new ConcreteChess(color);
            pool.put(color,chess);
            return chess;
        }
    }

}
