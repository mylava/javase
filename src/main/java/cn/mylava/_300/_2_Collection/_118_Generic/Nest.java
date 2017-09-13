package cn.mylava._300._2_Collection._118_Generic;

/**
 * 泛型的嵌套
 *
 * @author lipengfei
 */
public class Nest<T> {

    T stu;

    public static void main(String[] args) {
        //嵌套
        Nest<Student<String>> nest = new Nest<>();
    }
}
