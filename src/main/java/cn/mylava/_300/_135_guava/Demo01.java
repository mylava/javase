package cn.mylava._300._135_guava;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Guava的只读设置
 * @author lipengfei
 */
public class Demo01 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        //使用Collections生成的只读容器不够安全
        List<String> readList = Collections.unmodifiableList(list);
        list.add("c");
        //使用guava生成的只读容器安全，简单
        List<String> immutableList = ImmutableList.of("a","b");
        immutableList.add("c");
    }
}
