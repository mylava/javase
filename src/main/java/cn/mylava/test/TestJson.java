package cn.mylava.test;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 31/05/2018
 */
public class TestJson {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("a","1");
        map.put("b","2");

        Object o = JSON.toJSON(map);
        System.out.println(o);
    }
}
