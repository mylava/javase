package cn.mylava._300._6_Reflect._211_Reflection;

import java.lang.reflect.Method;

/**
 * comment: 对比反射(安全检查开/关状态下)和普通调用的性能差距
 * setAccessible 启用或禁用访问安全检查的开关，true表示反射的对象在使用时取消Java语言访问检查，false则相反。
 * 并不是true就能访问，false就不能访问。
 * 禁止安全检查，可以提高反射的运行效率。
 *
 * @author: lipengfei
 * @date: 04/01/2018
 */
public class _04Performance {

    public static void test1() {
        UserBean u = new UserBean();
        long startTime = System.currentTimeMillis();
        for (int i=0;i<1000000000L;i++) {
            u.getUname();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("普通方法调用，执行10亿次，耗时："+(endTime-startTime)+"ms");
    }


    @SuppressWarnings("unchecked")
    public static void test2() throws Exception {
        UserBean u = new UserBean();
        Class<UserBean> clazz = (Class<UserBean>) u.getClass();
        Method m = clazz.getDeclaredMethod("getUname",null);
        long startTime = System.currentTimeMillis();
        for (int i=0;i<1000000000L;i++) {
            m.invoke(u,null);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("反射动态方法调用，有安全检查，执行10亿次，耗时："+(endTime-startTime)+"ms");
    }

    @SuppressWarnings("unchecked")
    public static void test3() throws Exception {
        UserBean u = new UserBean();
        Class<UserBean> clazz = (Class<UserBean>) u.getClass();
        Method m = clazz.getDeclaredMethod("getUname",null);
        m.setAccessible(true);//不需要执行安全检查
        long startTime = System.currentTimeMillis();
        for (int i=0;i<1000000000L;i++) {
            m.invoke(u,null);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("反射动态方法调用，跳过安全检查，执行10亿次，耗时："+(endTime-startTime)+"ms");
    }

    public static void main(String[] args) {
        try {
            test1(); //最快
            test2(); //有安全检查，最慢，约是普通调用的5~6倍
            test3(); //没有安全检查，约是普通调用的3~4倍
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
