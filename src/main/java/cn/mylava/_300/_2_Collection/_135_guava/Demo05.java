package cn.mylava._300._2_Collection._135_guava;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

import java.util.Set;

/**
 * 统计单词出现的次数
 * 有两种实现方式
 * 1.之前的HashMap分拣存储-->示例120
 * 2.Multiset: 特点  无序+可重复
 * @author lipengfei
 */
public class Demo05 {
    public static void main(String[] args) {
        String str = "this is a cat and that is a mice where is the food";

        String[] array = str.split(" ");
        Multiset<String> set = HashMultiset.create();
        //存储到Multiset中
        for (String tmp : array) {
            set.add(tmp);
        }

        System.out.println(set);

        Set<String> letters = set.elementSet();
        for (String tmp:letters) {
            System.out.println(tmp+"-->"+set.count(tmp));
        }

    }
}
