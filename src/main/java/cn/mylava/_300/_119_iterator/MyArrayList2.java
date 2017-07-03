package cn.mylava._300._119_iterator;

import java.util.Iterator;

/**
 * 迭代器真正实现
 *
 * 与实现思路不一样的是，将具体实现封装到私有内部类中，提供公共接口以供访问
 * 这样游标的初始位置就被封装在多个对象中，不会出现游标错乱
 *
 * 注意封装的思想
 *
 * @author lipengfei
 */
public class MyArrayList2 {
    //模拟ArrayList容器
    private String[] elem = {"a","b","c","d","e","f","g"};
    int size = elem.length;

    //内部类 私有化 只能自己访问
    private class MyIt implements Iterator<String> {
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
    }

    //提供公共访问接口
    public Iterator<String> iterator() {
        return new MyIt();
    }

    public static void main(String[] args) {
        MyArrayList2 list = new MyArrayList2();
        Iterator<String> it = list.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
