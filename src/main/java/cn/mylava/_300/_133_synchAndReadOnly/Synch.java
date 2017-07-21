package cn.mylava._300._133_synchAndReadOnly;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 使用Collections 管理容器的同步
 * synchronizedList()
 * synchronizedSet()
 * synchronizedMap()
 * @author lipengfei
 */
public class Synch {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        //本质是在容器的各个方法上添加synchronized关键字进行加锁
        List<String> synlist = Collections.synchronizedList(list);
        System.out.println("通过synchronizedList方法生成一个线程安全的list");
    }
}
