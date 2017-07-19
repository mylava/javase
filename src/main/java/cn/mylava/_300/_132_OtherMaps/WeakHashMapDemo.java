package cn.mylava._300._132_OtherMaps;

import java.util.Set;
import java.util.WeakHashMap;

/**
 * WeakHashMap演示
 * WeakHashMap特点：键为弱引用的时候，在GC回收键对象之后，map会自动删除key-value对象
 * 场景：加入map被用作缓存，在map的数据量过大时，运行gc会自动清除弱引用的数据，而其他map做不到。
 * @author lipengfei
 */
public class WeakHashMapDemo {
    public static void main(String[] args) {
        WeakHashMap<String,String> map = new WeakHashMap<>();
        //key为常量池对象，即强引用类型
        map.put("强引用1","强引用1");
        map.put("强引用2","强引用2");
        //key为弱引用类型
        map.put(new String("弱引用1"),"弱引用1");
        map.put(new String("弱引用2"),"弱引用2");

        //通知回收
        System.gc();
        System.runFinalization();

        Set<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println(key + "-->" +map.get(key));
        }


    }
}
