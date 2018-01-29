package cn.mylava._300._6_Reflect._211_Reflection;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * comment: 反射操作泛型
 *
 * @author: lipengfei
 * @date: 04/01/2018
 */
public class _05Generics {
    public void test01(Map<String,UserBean> map,List<UserBean> list) {
        System.out.println("test01()");
    }

    public Map<Integer,UserBean> test02() {
        System.out.println("test02()");
        return null;
    }

    public static void main(String[] args) {
        try {
            Method m = _05Generics.class.getMethod("test01", Map.class, List.class);
            //获取方法的泛型参数类型
            Type[] parameterTypes = m.getGenericParameterTypes();
            for (Type parameterType : parameterTypes) {
                System.out.println("参数类型为："+parameterType);
                //如果参数类型是带泛型的参数类型
                if (parameterType instanceof ParameterizedType) {
                    //获取泛型的真实类型
                    Type[] actualTypeArguments = ((ParameterizedType) parameterType).getActualTypeArguments();
                    for (Type genericType : actualTypeArguments) {
                        System.out.println("泛型类型："+genericType);
                    }
                }
            }

            m = _05Generics.class.getMethod("test02",null);
            //获取方法的泛型返回类型
            Type returnType = m.getGenericReturnType();
            System.out.println("\n返回值类型为"+returnType);
            if (returnType instanceof ParameterizedType) {
                Type[] genericTypes = ((ParameterizedType) returnType).getActualTypeArguments();
                for (Type genericType : genericTypes) {
                    System.out.println("返回值泛型类型为："+genericType);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
