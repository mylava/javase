package cn.mylava._300._135_guava;

import com.google.common.collect.Sets;

import java.util.Set;

/**
 * 集合操作：交集、差集、并集
 * @author lipengfei
 */
public class Demo03 {
    public static void main(String[] args) {
        Set<Integer> set1 = Sets.newHashSet(1,2,3,4,5,6);
        Set<Integer> set2 = Sets.newHashSet(3,4,5,6,7,8,9);

        Set<Integer> result1 = Sets.intersection(set1,set2);
        System.out.println("交集为："+result1);

        Set<Integer> result2 = Sets.difference(set1,set2);
        System.out.println("差集为："+result2);

        Set<Integer> result3 = Sets.union(set1,set2);
        System.out.println("并集为："+result3);
    }
}

