package cn.mylava._300._6_Reflect._210_ORM;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 03/01/2018
 */
public class App {
    public static void main(String[] args) {
        try {
            Class<?> clazz = Class.forName("cn.mylava._300._6_Reflect._210_ORM.Student");
            /**
             * --------------- ---------------
             * 获取类注解（Type类型的注解）
             * --------------- ---------------
             */
            //第1种：获取类的所有注解，之后强转
            Annotation[] annotations = clazz.getAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation instanceof TableName) {
                    System.out.println(annotation);
                    TableName tableName = (TableName) annotation;
                    //获取表名
                    System.out.println(tableName.value());
                }
            }

            //第2种：直接取类对应的注解
            TableName tableName = clazz.getAnnotation(TableName.class);
            System.out.println(tableName.value());

            /**
             * --------------- ---------------
             * 获取类属性的注解（Field类型的注解）
             * --------------- ---------------
             */
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                FieldProperties fieldAnnotation = field.getAnnotation(FieldProperties.class);
                System.out.println(fieldAnnotation.columnName()+"---"+fieldAnnotation.type()+"---"+fieldAnnotation.length());
            }


            //取到注解之后可以根据注解拼接DDL语句，创建数据库表
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
