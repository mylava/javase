package cn.mylava._300._2_Collection._116_Generic.generic;

/**
 * 泛型接口
 * 接口中泛型字母只能使用在方法中,不能使用在常量中,因为接口中的常量默认就是static的
 *
 *  Created by lpf on 16/8/10.
 */
public interface MyInterface<T,R> {
    R test(T t);
}
