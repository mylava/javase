package cn.mylava._300._135_guava;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/** 函数式编程
 * 1.Predicate
 * 2.Function
 * @author lipengfei
 */
public class Demo02 {
    public static void main(String[] args) {
        predicate();

        function();

        compose();

    }

    //需求：找出回文，这里采用guave过滤器的函数式编程进行实现
    public static void predicate() {
        //使用guava类进行初始化
        List<String> list = Lists.newArrayList("moom","son","refer","dad");
        //注意返回类型是Collection类型，所以不能用List接收，因为泛型没有多态，只能使用Collection接收
        Collection<String> result = Collections2.filter(list, new Predicate<String>() {
            @Override
            public boolean apply(String input) {
                //将List中的字符串反转，如果等于自身，就是回文
                return new StringBuilder(input).reverse().toString().equals(input);
            }
        });
        for (String tmp : result) {
            System.out.println(tmp);
        }

        System.out.println("-------------------------------------->");
    }

    //需求：类型转换，将容器中的long类型表示的时间转换成字符串类型
    public static void function() {
        //
        Set<Long> timeSet = Sets.newHashSet();
        timeSet.add(1000000L);
        timeSet.add(999999999L);
        timeSet.add(200000000000L);

        Collection<String> result = Collections2.transform(timeSet, new Function<Long, String>() {
            @Override
            public String apply(Long input) {
                return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(input);
            }
        });

        for (String tmp : result) {
            System.out.println(tmp);
        }
        System.out.println("-------------------------------------->");
    }

    //需求：确保容器中的字符串长度不超过5，超过长度进行截取，然后全部大写
    //分解需求，第一步进行过滤，第二部进行转换
    public static void compose() {
        List<String> list = Lists.newArrayList("chinese","tomorrow","will","celebrate","for","victory");
        //确保容器中的字符串长度不超过5，超过进行截取
        Function<String,String> f1 = new Function<String, String>() {
            @Override
            public String apply(String input) {
                return input.length()>5?input.substring(0,5):input;
            }
        };
        //转成大写
        Function<String,String> f2 = new Function<String, String>() {
            @Override
            public String apply(String input) {
                return input.toUpperCase();
            }
        };

        //组合使用 String = f2(f1(string))
        Function<String,String> f = Functions.compose(f1,f2);

        Collection<String> result = Collections2.transform(list,f);
        for (String tmp : result) {
            System.out.println(tmp);
        }
        System.out.println("-------------------------------------->");

    }


}
