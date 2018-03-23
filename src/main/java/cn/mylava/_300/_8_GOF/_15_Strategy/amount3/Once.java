package cn.mylava._300._8_GOF._15_Strategy.amount3;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * comment: 本次消费金额注解
 *
 * @author: lipengfei
 * @date: 23/03/2018
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Once {
    DetailRegion value() default @DetailRegion;
}
