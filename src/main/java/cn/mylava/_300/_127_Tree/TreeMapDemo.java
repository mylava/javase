package cn.mylava._300._127_Tree;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeMap;

/**
 *  与TreeSet使用方法类似，根据Key的对比结果进行排序
 *  如果key没有实现Comparable接口，则需要在创建的时候指定Comparator比较器
 * @author lipengfei
 */
public class TreeMapDemo {
    public static void main(String[] args) {
        Person p1 = new Person("刘德华",100);
        Person p2 = new Person("张国荣 ",20);
        Person p3 = new Person("科比",90);
        Person p4 = new Person("艾弗森",90);

        //key没有实现Comparable接口，需指定Comparator
        TreeMap<Person,String> map = new TreeMap<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getScore() == o2.getScore() ? 0 :
                        o1.getScore() > o2.getScore() ? 1 : -1;
            }
        });
        map.put(p1,"演艺圈");
        map.put(p2,"演艺圈");
        map.put(p3,"NBA");
        map.put(p4,"NBA");

        //查看键
        Set<Person> persons = map.keySet();
        System.out.println(persons);
    }
}
