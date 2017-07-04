package cn.mylava._300._125_Compare;

import java.util.*;

/**
 * Comparable接口和Comparator接口对比
 *
 * Comparable是对象内部实现的对比
 * Comparator是在对象外部实现的比较器，解耦程度高
 *
 * 两者都只是指定排序规则，在具体的排序算法中使用规则对对象进行排序
 * @author lipengfei
 */
public class ComparatorImpl implements Comparator<Person>{
    /**
     * Comparator按照工资多少进行对比
     * @param o1
     * @param o2
     * @return
     */
    @Override
    public int compare(Person o1, Person o2) {
        if (o1.salary == o2.salary) {
            return 0;
        } else {
            return o1.salary-o2.salary > 0 ? 1 : -1;
        }
    }


    public static void main(String[] args) {
        Person p1 = new Person(26,13500d);
        Person p2 = new Person(29,9500d);

        List<Person> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);

        //使用内部比较器
        System.out.println(p1.compareTo(p2));
        Collections.sort(list);
        System.out.println(list);

        ComparatorImpl comparator = new ComparatorImpl();
        //使用外部比较器
        System.out.println(comparator.compare(p1,p2));
        Collections.sort(list,new ComparatorImpl());
        System.out.println(list);
    }
}


class Person implements Comparable<Person> {
    int age;
    double salary;

    public Person(int age, double salary) {
        this.age = age;
        this.salary = salary;
    }

    /**
     *  Person已经实现了Comparable接口：按照年龄大小排序
     * @param person
     * @return
     */
    @Override
    public int compareTo(Person person) {
        if (this.age == person.age) {
            return 0;
        } else {
            return this.age-person.age>0 ? 1 : -1;
        }
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Person{");
        sb.append("age=").append(age);
        sb.append(", salary=").append(salary);
        sb.append('}');
        return sb.toString();
    }
}