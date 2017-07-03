package cn.mylava._300._118_Generic;

/**
 * 没有泛型数组
 *
 * 声明时可以使用，但是创建失败
 *
 * @author lipengfei
 */
public class Array {
    public static void main(String[] args) {
        Integer[] arr = new Integer[4];
        //声明可以通过编译，但是创建失败
//        Student<String>[] stus = new Student<String>[10];

        Student<String>[] stus = new Student[10];

    }
}
