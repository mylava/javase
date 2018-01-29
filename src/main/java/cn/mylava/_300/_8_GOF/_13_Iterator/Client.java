package cn.mylava._300._8_GOF._13_Iterator;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 26/01/2018
 */
public class Client {
    public static void main(String[] args) {
        Aggregate aggregate = new Aggregate();
        aggregate.addObject("a");
        aggregate.addObject("b");
        aggregate.addObject("c");

        MyIterator iterator = aggregate.createIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.getCurrentObj());
            iterator.next();
        }
        iterator.getCurrentObj();
    }
}
