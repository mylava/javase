package cn.mylava._300._2_Collection._110_MyHashSet;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by lpf on 16/8/10.
 */
public class TestSet {

    public static void main(String[] args) {
        Set set = new TreeSet<>();
        set.add("aaa");
        set.add("bbb");
        System.out.println(set.size());
    }

}
