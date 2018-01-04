package cn.mylava._300._6_Reflect._211_Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * comment: 使用反射API操作属性、方法、构造器
 *
 * @author: lipengfei
 * @date: 04/01/2018
 */
public class _02Operate {
    public static void main(String[] args) {
        String path="cn.mylava._300._6_Reflect._211_Reflection.UserBean";

        try {
            Class<?> clazz = Class.forName(path);
            //获取类的名字
            System.out.println("全类名："+clazz.getName());
            System.out.println("简单类名："+clazz.getSimpleName());
            /**
             * --------------- ---------------
             * 操作属性
             * --------------- ---------------
             */
            //只能获取public属性
            Field[] fields = clazz.getFields();
            System.out.println("\npublic属性：");
            for (Field field : fields) {
                System.out.println(field+"\t");
            }

            //获取所有属性
            Field[] declaredFields = clazz.getDeclaredFields();
            System.out.println("\n所有属性：");
            for (Field field : declaredFields) {
                System.out.println(field+"\t");
            }
            //获取public单个属性,如果属性不是public的，抛出NoSuchFieldException
//            Field field_id = clazz.getField("id");
//            System.out.println("字段类型是："+field_id.getType());

            //获取单个属性（所有访问修饰符都可）
            Field field_id = clazz.getDeclaredField("id");
            System.out.println("\n字段类型是："+field_id.getType());

            /**
             * --------------- ---------------
             * 操作方法  与Field大同小异
             * --------------- ---------------
             */
            System.out.println("\n所有方法");
            Method[] declaredMethods = clazz.getDeclaredMethods();
            for (Method declaredMethod : declaredMethods) {
                System.out.println(declaredMethod);
            }

            System.out.println("\n单个方法");
            //注意获取方法时需要传递参数类型（区分重载方法）
            Method method = clazz.getDeclaredMethod("setUname", String.class);
            System.out.println(method);
            /**
             * --------------- ---------------
             * 操作构造器
             * --------------- ---------------
             */
            System.out.println("\n所有构造器");
            Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
            for (Constructor<?> declaredConstructor : declaredConstructors) {
                System.out.println(declaredConstructor);
            }

            System.out.println("\n单个构造器");
            //注意获取方法时需要传递参数类型（区分重载方法）
            Constructor<?> declaredConstructor = clazz.getDeclaredConstructor(int.class, int.class, String.class);
            System.out.println(declaredConstructor);

        } catch (ClassNotFoundException | NoSuchMethodException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
