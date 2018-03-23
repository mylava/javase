package cn.mylava._300._8_GOF._15_Strategy.amount3;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * comment: 总消费金额注解
 *
 * @author: lipengfei
 * @date: 22/03/2018
 */
//作用于类
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME) //注解保留策略
public @interface AmountRegion {
    //引用有效区间注释
    DetailRegion value() default @DetailRegion;
}
