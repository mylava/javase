package cn.mylava._300._6_Reflect._210_ORM;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * comment: 用于描述字段属性的注解
 *
 * @author: lipengfei
 * @date: 03/01/2018
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {
    //列名
    String columnName();
    //类型
    String type();
    //长度
    int length();
}
