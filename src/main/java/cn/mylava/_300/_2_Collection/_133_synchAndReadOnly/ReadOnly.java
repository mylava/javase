package cn.mylava._300._2_Collection._133_synchAndReadOnly;

import java.util.*;

/**
 * Collections提供三种方法使容器只读，即不能修改容器中的元素。
 * 1.emptyXxx() 空的不可变的集合（比如避免出现空指针异常时可以将引用emptyXxx）
 * 2.singletonXxx() 一个元素的不可变集合
 * 3.unmodifiableXxx() 不可变容器
 * @author lipengfei
 */
public class ReadOnly {
    public static void main(String[] args) {
        //EmptySet
        Set<String> set = Collections.emptySet();
        System.out.println(set);
        //Collections.emptySet()
        System.out.println(oper(null));


        List<String> list = Collections.singletonList("张三");
        //java.lang.UnsupportedOperationException
//        list.add("李四");
        System.out.println(list);

        Map<String,String> map = new HashMap<>();
        map.put("a","A");
        map.put("b","B");
        Map<String, String> readOnlyMap = Collections.unmodifiableMap(map);
        //java.lang.UnsupportedOperationException
//        readOnlyMap.put("c","C");


        Set<String> keys = readOnlyMap.keySet();
        for (String key : keys) {
            System.out.println(key + "-->" +map.get(key));
        }
        System.out.println("------>不安全，修改原来的map，只读的map也会跟着变");
        //unmodifiableXxx方法返回的是原来对象的快照，或者镜像，并不安全，修改原来的map，镜像跟着变
        map.put("c","C");

        keys = readOnlyMap.keySet();
        for (String key : keys) {
            System.out.println(key + "-->" +map.get(key));
        }
    }
    //emptyXxx的使用场景
    public static Set<String> oper(Set<String> set) {
        if (null == set) {
            return Collections.emptySet();
        }
        //oper...
        return set;
    }
}
