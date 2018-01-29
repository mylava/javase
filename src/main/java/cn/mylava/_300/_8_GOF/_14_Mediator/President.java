package cn.mylava._300._8_GOF._14_Mediator;

import java.util.HashMap;
import java.util.Map;

/**
 * comment: 总经理
 *
 * @author: lipengfei
 * @date: 26/01/2018
 */
public class President implements Mediator{
    private Map<String,Department> map = new HashMap<>();

    @Override
    public void register(String dname, Department d) {
        map.put(dname,d);
    }

    @Override
    public void command(String dname) {
        map.get(dname).selfAction();
    }
}
