package cn.mylava._300._6_Reflect._208_InnerAnnotation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * comment: 常用JDK内置注解的使用示例
 *
 * @author: lipengfei
 * @date: 03/01/2018
 */
public class InnerAnnotation {
    /**
     * @Override 表示重写了父类的方法，作用域只能是方法
     *
     * return
     */
    @Override
    public String toString() {
        return super.toString();
    }

    /**
     *  Deprecated 表示方法或字段过期，作用域只能是方法
     */
    @Deprecated
    public void test() {
    }

    /**
     * 有注解
     * @SuppressWarnings 作用域为 TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE
     * @return
     */
    @SuppressWarnings("unchecked")
    public static List getList() {
        List list = new ArrayList();
        list.add("1");
        list.add(2);
        return list;
    }

    /**
     * 没有注解报错
     * @param map
     */
    void function(HashMap map) {
        map.put("key", "value");
    }

    public static void main(String[] args) {
        getList();
    }
}
