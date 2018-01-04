package cn.mylava.test;

import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 2017/12/11
 */
public class Test {
    public static void main(String[] args) throws IOException {
//        JSONObject

        File file = new File("/Users/lipengfei/Documents/code/javase/src/main/java/cn/mylava/test/a.txt");


        BufferedReader reader = new BufferedReader(new FileReader(file));

        String result="";
        String buffer;
        while (null!=(buffer=reader.readLine())) {
            result+=buffer;
        }
        reader.close();

        System.out.println(result);

        JSONObject jsonObject = JSONObject.parseObject(result);
        System.out.println(jsonObject);
    }
}
