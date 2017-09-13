package cn.mylava._300._2_Collection._119_iterator;

import java.util.Iterator;

/**
 * 继续延伸
 *
 * 1.因为迭代器类只使用了一次，可以考虑：使用匿名内部类
 * 2.使用增强for循环 --> 需要实现Iterable接口,注意指定Iterable的泛型类型
 *
 * @author lipengfei
 */
public class MyArrayList3 implements Iterable<String>{
    //模拟ArrayList容器
    private String[] elem = {"a","b","c","d","e","f","g"};
    int size = elem.length;


    //提供公共访问接口-----> 匿名内部类
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            //游标初始位置
            private int cursor = -1;

            @Override
            public boolean hasNext() {
                return cursor+1<size;
            }

            @Override
            public String next() {
                cursor++;//先移动，再获取
                return elem[cursor];
            }

            @Override
            public void remove() {

            }
        };
    }

    public static void main(String[] args) {
        MyArrayList3 list = new MyArrayList3();
        for (String str : list) {
            System.out.println(str);
        }
    }
}
