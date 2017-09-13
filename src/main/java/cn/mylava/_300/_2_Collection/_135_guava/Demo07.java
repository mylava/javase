package cn.mylava._300._2_Collection._135_guava;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * HashMap： 键唯一，值可以重复
 * BiMap：双向map，键与值都不能重复
 *
 * @author lipengfei
 */
public class Demo07 {
    public static void main(String[] args) {
        BiMap<String,Integer> biMap = HashBiMap.create();
        biMap.put("刘德华",100);
        biMap.put("梁朝伟",90);

//        biMap.put("周润发",100);
        //key 和 value互换位置
        BiMap<Integer, String> inverse = biMap.inverse();
        System.out.println(inverse);
        //通过value找key
        String name = biMap.inverse().get(100);
        System.out.println(name);

        //再次反转和原来相等----->思考他们的地址为什么相同？
        System.out.println(biMap == inverse.inverse());
    }
}
