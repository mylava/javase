package cn.mylava._300._8_GOF._13_Iterator;

/**
 * comment: 迭代器接口
 *
 * @author: lipengfei
 * @date: 24/01/2018
 */
public interface MyIterator {
    //将游标指向第一个元素
    void first();
    //将游标指向下一个元素
    void next();
    //判断是否存在下一个元素
    boolean hasNext();

    boolean isFirst();
    boolean isLast();

    //获取当前游标指向的对象
    Object getCurrentObj();
}
