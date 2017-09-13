package cn.mylava._300._2_Collection._132_OtherMaps;

import java.util.EnumMap;
import java.util.Set;

/**
 * EnumMap的键必须是enum类型，创建时必须制定enum的类型
 * @author lipengfei
 */
public class EnumMapDemo {
    public static void main(String[] args) {
        EnumMap<Season,String> map = new EnumMap<>(Season.class);
        map.put(Season.SPRING,"春");
        map.put(Season.SUMMER,"夏");
        map.put(Season.AUTUMN,"秋");
        map.put(Season.WINTER,"冬");

        Set<Season> keys = map.keySet();
        for (Season key : keys) {
            System.out.println(key + "-->" +map.get(key));
        }
    }
}

enum Season {
    SPRING,SUMMER,AUTUMN,WINTER
}