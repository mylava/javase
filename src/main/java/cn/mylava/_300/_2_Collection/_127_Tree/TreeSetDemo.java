package cn.mylava._300._2_Collection._127_Tree;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * TreeSet的使用
 *
 *  TreeSet是SortedSet接口的唯一实现类，TreeSet可以确保集合元素处于排序状态。
 *  TreeSet判断两个对象不相等的方式是compareTo或compare方法，而不是hashcode和equals方法。
 *
 *  对比：HashSet元素必须重写hashcode和equals方法。
 *
 *  因为需要排序，所以需要提供排序的方法
 *  排序的方法有两种 1.元素类实现了Comparable接口   2.提供额外的比较器Comparator
 * @author lipengfei
 */
public class TreeSetDemo {
    public static void main(String[] args) {
        Person p1 = new Person("刘德华",100);
        Person p2 = new Person("张国荣 ",20);
        Person p3 = new Person("科比",90);
        Person p4 = new Person("艾弗森",90);

        //运行时报错java.lang.ClassCastException: Person cannot be cast to java.lang.Comparable
        TreeSet<Person> persons = new TreeSet<>();
        //正确用法1.Person类实现Comparable接口 ； 2.在TreeSet中提供一个Comparator
        //第二种示例
        persons = new TreeSet<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getScore() == o2.getScore() ? 0 :
                        o1.getScore() > o2.getScore() ? 1 : -1;
            }
        });
        //TreeSet在添加数据时排序，添加之后修改数据不再排序
        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
        persons.add(p4);

        System.out.println(persons);
        //数据更改不会影响TreeSet中数据原来的顺序，应该尽量避免修改数据这样的操作，否则TreeSet中可能存在重复数据
        //在变量中使用final修饰符，禁止修改数据
//        p3.setScore(100);
    }
}

