package cn.mylava._300._2_Collection._129_Queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 基于Deque实现的Stack
 *
 * 栈的特点是后进先出，常用的有三个操作，pop、push、peek
 * 压栈时候使用offerLast，弹栈时候使用pollLast
 *
 * @author lipengfei
 */
public class MyStack<E> {

    public static void main(String[] args) {
        //模拟浏览器的历史记录
        MyStack<String> backHistory = new MyStack<>(3);
        backHistory.push("www.baidu.com");
        backHistory.push("www.google.com");
        backHistory.push("www.taobao.com");
        //压栈失败
        backHistory.push("www.sina.com");

        String item = null;
        while (null != (item=backHistory.pop())) {
            System.out.println(item);
        }


    }



    //容器
    private Deque<E> container = new ArrayDeque<>();
    //容量
    private int cap;

    public MyStack(int cap) {
        this.cap = cap;
    }

    //压栈
    public boolean push(E e) {
        if (container.size()+1>cap) {
            return false;
        }
        return container.offerLast(e);
    }
    //弹栈
    public E pop() {
        return container.pollLast();
    }

    //获取
    public E peek() {
        return container.peekLast();
    }

    public int size() {
        return this.container.size();
    }
}
