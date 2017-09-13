package cn.mylava._300._2_Collection._135_guava;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 统计每个老师负责的课程
 * Multimap: 特点  key可以重复
 * @author lipengfei
 */
public class Demo06 {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("数学","张三");
        map.put("语文","李四");
        map.put("英语","李四");
        map.put("物理","张三");
        map.put("化学","张三");
        map.put("历史","李四");

        //统计每个老师负责什么课程
        Multimap<String,String> multimap = ArrayListMultimap.create();

        Iterator<Map.Entry<String,String>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String,String> entry = iterator.next();
            multimap.put(entry.getValue(),entry.getKey());
        }

        System.out.println(multimap);
        Set<String> keys = multimap.keySet();
        for (String key:keys) {
            System.out.println(key+"-->"+multimap.get(key));
        }

    }
}

