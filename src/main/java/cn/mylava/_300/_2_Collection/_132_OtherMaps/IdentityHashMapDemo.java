package cn.mylava._300._2_Collection._132_OtherMaps;

import java.util.IdentityHashMap;
import java.util.Set;

/**
 * IdentityMap :键只以地址去重，不比较HashCode和equals
 * @author lipengfei
 */
public class IdentityHashMapDemo {
    public static void main(String[] args) {
        IdentityHashMap<String,String> map = new IdentityHashMap<>();
        //这里的key是字符串常量，存储在常量池中，地址相同
        map.put("a","a1");
        map.put("a","a2");
        //new出来的对象地址不同
        map.put(new String("a"),"a3");
        map.put(new String("a"),"a4");


        Set<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println(key + "-->" +map.get(key));
        }
    }
}
