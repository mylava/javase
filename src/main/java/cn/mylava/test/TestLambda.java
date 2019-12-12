package cn.mylava.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 18/04/2018
 */
public class TestLambda {
    public static void main(String[] args) {
        List<String> items = new ArrayList<>();
        items.add("1");
        items.add("2");
        items.add("3");
        items.add("4");
        items.add("5");


        Optional<String> opt = items.stream().map(id -> id + "1").reduce((a, b) -> {
            return Integer.valueOf(a) > Integer.valueOf(b) ? a : b;
        });
        System.out.println(opt.isPresent());
        System.out.println(opt.get());
    }
}
