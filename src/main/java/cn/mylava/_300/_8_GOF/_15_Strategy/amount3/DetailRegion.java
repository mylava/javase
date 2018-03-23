package cn.mylava._300._8_GOF._15_Strategy.amount3;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * comment: 执行顺序、以及价格区间的注解，是另外两个注解的注解，描述具体信息
 *
 * @author: lipengfei
 * @date: 23/03/2018
 */
//作用于注解
@Target(ElementType.ANNOTATION_TYPE)
@Retention(RetentionPolicy.RUNTIME) //注解保留策略
public @interface DetailRegion {
    //下限
    int lowerBound() default Integer.MIN_VALUE;
    //上限
    int upperBound() default Integer.MAX_VALUE;
    //执行顺序
    int order() default 0;
}
