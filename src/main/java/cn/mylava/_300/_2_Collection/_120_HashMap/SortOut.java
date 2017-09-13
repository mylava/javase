package cn.mylava._300._2_Collection._120_HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * HashMap分拣思路
 * 计算出字符串中每个单词出现的频次
 *
 * @author lipengfei
 */
public class SortOut {

    public static void main(String[] args) {
//        test1();
        test2();
    }

    /**
     * 第一种思路：先为所有的单词创建容器，之后再计数
     */
    public static void test1() {
        String str = "this is a cat and that is a mice and where is the food";
        String[] array = str.split(" ");
        Map<String,Letter> map = new HashMap<>();
        for (String s : array) {
            if (!map.containsKey(s)){
                map.put(s,new Letter());
            }
            Letter letter = map.get(s);
            letter.setCount(letter.getCount()+1);
        }

        Set<String> keys = map.keySet();

        for (String key:keys){
            System.out.println("字母："+key+"出现的次数："+map.get(key).getCount());
        }
    }

    /**
     * 第二种思路：创建容器同时计数
     */
    public static void test2() {
        String str = "this is a cat and that is a mice and where is the food";
        String[] array = str.split(" ");
        Map<String,Letter> map = new HashMap<>();
        for (String s : array) {
            Letter letter = null;

            if (null == (letter=map.get(s))){
                letter = new Letter();
                letter.setCount(1);
                map.put(s,letter);
            } else {
                letter.setCount(letter.getCount()+1);
            }
        }

        Set<String> keys = map.keySet();

        for (String key:keys){
            System.out.println("字母："+key+"出现的次数："+map.get(key).getCount());
        }
    }
}


class Letter {
    private String name;
    private int count;

    public Letter(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public Letter() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
