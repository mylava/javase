package cn.mylava._300._6_Reflect._209_CustomAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * comment: 自定义注解
 *
 * @author: lipengfei
 * @date: 03/01/2018
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    //参数值 如果参数只有一个，一般默认名称为value,这样在使用注解时可以省掉参数名直接赋值
    String studentName() default "";
    // -1表示不存在
    int id() default -1;
    //如果把defaul去掉，使用时必须指定值，不然会报错
    int age() /*default 0*/;
    //学科
    String[] subjects() default {"语文","数学"};
}
