package cn.mylava.collection.linkedHashMap;

import cn.mylava.collection.hashMap.MyHashMap;

import java.util.*;

/**
 * LinkedHashMap源码剖析
 * @author lipengfei
 */
public class MyLinkedHashMap<K,V>
        extends MyHashMap<K,V>
        implements Map<K,V>
{

    private static final long serialVersionUID = 3801124242820219131L;

    //双向循环链表的头结点，整个LinkedHashMap中只有一个header，
    //它将哈希表中所有的Entry贯穿起来，header中不保存key-value对，只保存前后节点的引用
    private transient Entry<K,V> header;

    //双向链表中元素排序规则的标志位。
    //accessOrder为false，表示按插入顺序排序
    //accessOrder为true，表示按访问顺序排序
    private final boolean accessOrder;

    //调用HashMap的构造方法来构造底层的数组
    public MyLinkedHashMap(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
        //链表中的元素默认按照插入顺序排序
        accessOrder = false;
    }

    public MyLinkedHashMap(int initialCapacity) {
        super(initialCapacity);
        accessOrder = false;
    }

    public MyLinkedHashMap() {
        super();
        accessOrder = false;
    }

    public MyLinkedHashMap(Map<? extends K, ? extends V> m) {
        super(m);
        accessOrder = false;
    }

    //该构造方法可以指定链表中的元素排序的规则
    public MyLinkedHashMap(int initialCapacity,
                         float loadFactor,
                         boolean accessOrder) {
        super(initialCapacity, loadFactor);
        this.accessOrder = accessOrder;
    }

    //覆写父类的init()方法（HashMap中的init方法为空），
    //该方法在父类的构造方法和Clone、readObject中在插入元素前被调用，
    //初始化一个空的双向循环链表，头结点中不保存数据，头结点的下一个节点才开始保存数据。
    void init() {
        header = new Entry<>(-1, null, null, null);
        header.before = header.after = header;
    }

    //覆写HashMap中的transfer方法，它在父类的resize方法中被调用，
    //扩容后，将key-value对重新映射到新的newTable中
    //覆写该方法的目的是为了提高复制的效率，
    //这里充分利用双向循环链表的特点进行迭代，不用对数组外层进行循环。
    void transfer(MyHashMap.Entry[] newTable, boolean rehash) {
        int newCapacity = newTable.length;
        for (Entry<K,V> e = header.after; e != header; e = e.after) {
            if (rehash)
                e.hash = (e.key == null) ? 0 : hash(e.key);
            int index = indexFor(e.hash, newCapacity);
            e.next = newTable[index];
            newTable[index] = e;
        }
    }


    //覆写HashMap中的containsValue方法，
    //覆写该方法的目的同样是为了提高查询的效率，
    //利用双向循环链表的特点进行查询，少了对数组的外层for循环
    public boolean containsValue(Object value) {
        // Overridden to take advantage of faster iterator
        if (value==null) {
            for (Entry e = header.after; e != header; e = e.after)
                if (e.value==null)
                    return true;
        } else {
            for (Entry e = header.after; e != header; e = e.after)
                if (value.equals(e.value))
                    return true;
        }
        return false;
    }

    //覆写HashMap中的get方法，通过getEntry方法获取Entry对象。
    //注意这里的recordAccess方法，
    //如果链表中元素的排序规则是按照插入的先后顺序排序的话，该方法什么也不做，
    //如果链表中元素的排序规则是按照访问的先后顺序排序的话，则将e移到链表的末尾处。
    public V get(Object key) {
        Entry<K,V> e = (Entry<K,V>)getEntry(key);
        if (e == null)
            return null;
        e.recordAccess(this);
        return e.value;
    }

    //清空HashMap，并将双向链表还原为只有头结点的空链表
    public void clear() {
        super.clear();
        header.before = header.after = header;
    }

    //Enty的数据结构，多了两个指向前后节点的引用
    private static class Entry<K,V> extends MyHashMap.Entry<K,V> {
        // These fields comprise the doubly linked list used for iteration.
        Entry<K,V> before, after;

        Entry(int hash, K key, V value, MyHashMap.Entry<K,V> next) {
            super(hash, key, value, next);
        }

        //双向循环链表中，删除当前的Entry
        private void remove() {
            before.after = after;
            after.before = before;
        }

        //双向循环立链表中，将当前的Entry插入到existingEntry的前面
        private void addBefore(Entry<K,V> existingEntry) {
            after  = existingEntry;
            before = existingEntry.before;
            before.after = this;
            after.before = this;
        }

        //覆写HashMap中的recordAccess方法（HashMap中该方法为空），
        //当调用父类的put方法，在发现插入的key已经存在时，会调用该方法，
        //调用LinkedHashmap覆写的get方法时，也会调用到该方法，
        //该方法提供了LRU算法的实现，它将最近使用的Entry放到双向循环链表的尾部，
        //accessOrder为true时，get方法会调用recordAccess方法
        //put方法在覆盖key-value对时也会调用recordAccess方法
        //它们导致Entry最近使用，因此将其移到双向链表的末尾
        void recordAccess(MyHashMap<K,V> m) {
            MyLinkedHashMap<K,V> lm = (MyLinkedHashMap<K,V>)m;
            //如果链表中元素按照访问顺序排序，则将当前访问的Entry移到双向循环链表的尾部，
            //如果是按照插入的先后顺序排序，则不做任何事情。
            if (lm.accessOrder) {
                lm.modCount++;
                //移除当前访问的Entry
                remove();
                //将当前访问的Entry插入到链表的尾部
                addBefore(lm.header);
            }
        }

        void recordRemoval(HashMap<K,V> m) {
            remove();
        }
    }

    //迭代器  
    private abstract class LinkedHashIterator<T> implements Iterator<T> {
        Entry<K,V> nextEntry    = header.after;
        Entry<K,V> lastReturned = null;

        /**
         * The modCount value that the iterator believes that the backing
         * List should have.  If this expectation is violated, the iterator
         * has detected concurrent modification.
         */
        int expectedModCount = modCount;

        public boolean hasNext() {
            return nextEntry != header;
        }

        public void remove() {
            if (lastReturned == null)
                throw new IllegalStateException();
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();

            MyLinkedHashMap.this.remove(lastReturned.key);
            lastReturned = null;
            expectedModCount = modCount;
        }

        //从head的下一个节点开始迭代
        MyLinkedHashMap.Entry<K,V> nextEntry() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
            if (nextEntry == header)
                throw new NoSuchElementException();

            MyLinkedHashMap.Entry<K,V> e = lastReturned = nextEntry;
            nextEntry = e.after;
            return e;
        }
    }

    //key迭代器
    private class KeyIterator extends LinkedHashIterator<K> {
        public K next() { return nextEntry().getKey(); }
    }

    //value迭代器
    private class ValueIterator extends LinkedHashIterator<V> {
        public V next() { return nextEntry().value; }
    }

    //Entry迭代器
    private class EntryIterator extends LinkedHashIterator<Map.Entry<K,V>> {
        public Map.Entry<K,V> next() { return nextEntry(); }
    }

    // These Overrides alter the behavior of superclass view iterator() methods
    Iterator<K> newKeyIterator()   { return new MyLinkedHashMap.KeyIterator();   }
    Iterator<V> newValueIterator() { return new MyLinkedHashMap.ValueIterator(); }
    Iterator<Map.Entry<K,V>> newEntryIterator() { return new MyLinkedHashMap.EntryIterator(); }

    //覆写HashMap中的addEntry方法，LinkedHashmap并没有覆写HashMap中的put方法，
    //而是覆写了put方法所调用的addEntry方法和recordAccess方法，
    //put方法在插入的key已存在的情况下，会调用recordAccess方法，
    //在插入的key不存在的情况下，要调用addEntry插入新的Entry
    protected void addEntry(int hash, K key, V value, int bucketIndex) {
        //创建新的Entry，并插入到LinkedHashMap中
        super.addEntry(hash, key, value, bucketIndex);

        // 双向链表的第一个有效节点（header后的那个节点）为近期最少使用的节点
        MyLinkedHashMap.Entry<K,V> eldest = header.after;
        //如果有必要，则删除掉该近期最少使用的节点，
        //这要看对removeEldestEntry的覆写,由于默认为false，因此默认是不做任何处理的。
        if (removeEldestEntry(eldest)) {
            removeEntryForKey(eldest.key);
        }
    }


    void createEntry(int hash, K key, V value, int bucketIndex) {
        //创建新的Entry，并将其插入到数组对应槽的单链表的头结点处，这点与HashMap中相同
        MyHashMap.Entry<K,V> old = table[bucketIndex];
        MyLinkedHashMap.Entry<K,V> e = new MyLinkedHashMap.Entry<>(hash, key, value, old);
        table[bucketIndex] = e;
        //每次插入Entry时，都将其移到双向链表的尾部，
        //这便会按照Entry插入LinkedHashMap的先后顺序来迭代元素，
        //同时，新put进来的Entry是最近访问的Entry，把其放在链表末尾 ，符合LRU算法的实现
        e.addBefore(header);
        size++;
    }

    //该方法是用来被覆写的，一般如果用LinkedHashmap实现LRU算法，就要覆写该方法，
    //一般的实现是，当设定的内存（这里指节点个数）达到最大值时，返回true，这样put新的Entry
    // （该Entry的key在哈希表中没有已经存在）时，就会调用removeEntryForKey方法，将最近最少使用的节点删除
    // （head后面的那个节点，实际上是最近没有使用）。
    protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
        return false;
    }
}
