package cn.mylava._300._8_GOF._15_Strategy.amount2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * comment: 金额对应会员级别的注解，用于判断会员消费金额达到什么级别
 *
 * @author: lipengfei
 * @date: 22/03/2018
 */
@Target(ElementType.TYPE) //这个注解只能作用于类
@Retention(RetentionPolicy.RUNTIME) //注解保留策略
public @interface AmountRegion {
    //下限
    int lowerBound() default Integer.MIN_VALUE;
    //上限
    int upperBound() default Integer.MAX_VALUE;
}
