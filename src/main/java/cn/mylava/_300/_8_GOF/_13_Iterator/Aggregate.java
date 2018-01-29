package cn.mylava._300._8_GOF._13_Iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * comment: 聚合类
 *
 * @author: lipengfei
 * @date: 24/01/2018
 */
public class Aggregate {
    private List<Object> list = new ArrayList();

    public void addObject(Object obj) {
        this.list.add(obj);
    }

    public void removeObject(Object obj) {
        this.list.remove(obj);
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    private class ConcreteIterator implements MyIterator {
        //定义游标，用于记录遍历时的位置
        private int cursor;
        @Override
        public void first() {
            cursor=0;
        }

        @Override
        public void next() {
            if (cursor<list.size()) {
                cursor++;
            }
        }

        @Override
        public boolean hasNext() {
            return cursor < list.size();
        }

        @Override
        public boolean isFirst() {
            return cursor == 0;
        }

        @Override
        public boolean isLast() {
            return cursor==(list.size()-1);
        }

        @Override
        public Object getCurrentObj() {
            if (hasNext()) {
                return list.get(cursor);
            }
            return null;
        }

    }
    public MyIterator createIterator() {
        return new ConcreteIterator();
    }
}
