package cn.mylava._300._119_iterator;


/**
 * 迭代器实现思路
 *
 * @author lipengfei
 */
public class MyArrayList {
    //模拟ArrayList容器
    private String[] elem = {"a", "b", "c", "d", "e", "f", "g"};
    int size = elem.length;


    //游标初始位置
    private int cursor = -1;

    public boolean hasNext() {
        return cursor + 1 < size;
    }

    public Object next() {
        cursor++;//先移动，再获取
        return elem[cursor];
    }

    public void remove() {

    }

    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();
        while (list.hasNext()) {
            System.out.println(list.next());
        }
    }
}
