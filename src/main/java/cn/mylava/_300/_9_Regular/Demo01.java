package cn.mylava._300._9_Regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 05/02/2018
 */
public class Demo01 {
    public static void main(String[] args) {
        //表达式对象
        Pattern p = Pattern.compile("\\w+");
        //匹配引擎
        Matcher m = p.matcher("adfs&&123");
        //将整个字符串与该模式匹配
        boolean ifMatch1 = m.matches();
        System.out.println(ifMatch1);

        //查找与该模式匹配的子序列,可以查询多次
        System.out.println(m.find());
        System.out.println(m.find());
    }
}
