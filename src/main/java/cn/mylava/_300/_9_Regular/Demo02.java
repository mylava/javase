package cn.mylava._300._9_Regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 05/02/2018
 */
public class Demo02 {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("([a-z]+)([0-9]+)");
        Matcher m = p.matcher("aa12**bcd56**efg78");
        //find
        while (m.find()) {
            //第一个匹配的字符串
            System.out.println("group:"+m.group());
            //第一个匹配字符串中，第一个括号的反向引用，相当于\1
            System.out.println("子集1："+m.group(1));
            //相当于\2
            System.out.println("子集2："+m.group(2));
        }

        //替换
        String newStr = m.replaceAll("###");
        System.out.println(newStr);

    }
}
