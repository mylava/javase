package cn.mylava._300._6_Reflect._211_Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * comment: 通过反射动态操作对象
 *
 * @author: lipengfei
 * @date: 04/01/2018
 */
@SuppressWarnings("unchecked")
public class _03DynamicInstance {
    public static void main(String[] args) {

        String path="cn.mylava._300._6_Reflect._211_Reflection.UserBean";

        try {
            /**
             * --------------- ---------------
             * 通过反射动态构造对象
             * --------------- ---------------
             */
            //默认构造器
            Class<UserBean> clazz = (Class<UserBean>) Class.forName(path);
            UserBean u1 = clazz.newInstance(); //其实是调用了User的无参构造方法 等价于UserBean userBean = new UserBean();
            System.out.println(u1);

            //重载的构造器
            Constructor<UserBean> constructor = clazz.getDeclaredConstructor(int.class, int.class, String.class);
            UserBean u2 = constructor.newInstance(10, 10, "张三");
            System.out.println(u2);

            /**
             * --------------- ---------------
             * 通过反射操作方法
             * 优点：
             * 方法、对象、值都是参数，运行时从外界读取
             * 实现动态调用不同对象的不同方法、动态赋值
             * --------------- ---------------
             */
            UserBean u3 = clazz.newInstance();
            Method method = clazz.getDeclaredMethod("setUname", String.class);
            method.invoke(u3,"123");
            System.out.println(u3);

            /**
             * --------------- ---------------
             * 通过反射操作属性
             * --------------- ---------------
             */
            UserBean u4 = clazz.newInstance();
            Field f = clazz.getDeclaredField("uname");
            f.setAccessible(true);
            f.set(u4,"李四");
            System.out.println(f.get(u4));
            f.setAccessible(false);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
