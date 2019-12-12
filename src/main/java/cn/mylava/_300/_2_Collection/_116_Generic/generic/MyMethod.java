package cn.mylava._300._2_Collection._116_Generic.generic;

import java.io.Closeable;
import java.io.IOException;

/**
 * 泛型方法
 * 泛型要声明在返回值之前,且该方法只能访问泛型对象的信息,不能修改泛型对象的信息.
 *
 * Created by lpf on 16/8/10.
 */
public class MyMethod {
    public static <T> void test(T t){
        System.out.println(t.getClass());
    }

    public static <T extends Closeable> void test(T... t){
        for (T temp : t){
            try {
                if (null!=temp)
                    temp.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void test1(Student<Number> student){
        System.out.println(student.getJavaScore());
    }

    public static void main(String[] args) {
//        test1(new Student<Integer>(1,2));



        MyMethod.test("a");
        test(2);

        test(new StringBuffer[10]);
    }



}
