package cn.mylava._300._6_Reflect._211_Reflection;

/**
 * comment: 主要展示Class的概念
 * 类、接口、枚举、注解、基本类型、void 都可以获取Class对象
 *
 * @author: lipengfei
 * @date: 04/01/2018
 */
public class _01Class {
    public static void main(String[] args) {
        String path="cn.mylava._300._6_Reflect._211_Reflection.UserBean";

        try {
            //一个类被加载后，Jvm会创建一个Class对象与之对应，类的结构信息会存放到对应的Class对象中。
            //有三种方法可以拿到类的Class对象
            //1.Class.forName("xxx")
            Class<?> clazz = Class.forName(path);
            System.out.println(clazz +"--"+clazz.hashCode());
            //2.Class.class
            Class<String> class1 = String.class;
            //3.instance.getClass()
            Class<? extends String> class2 = path.getClass();
            System.out.println(class1 == class2);

            //数组类型的Class对象，需要元素类型和维度一样，Class对象才一样
            int[] arr01 = new int[10];
            int[] arr02 = new int[30];
            int[][] arr03 = new int[10][10];
            double[] arr04 = new double[10];
            System.out.println("数组Class对象："+(arr01.getClass()==arr02.getClass()));
            System.out.println("不同元素类型数组Class对象："+(arr01.getClass().hashCode()==arr04.getClass().hashCode()));
            System.out.println("不同纬度数组Class对象："+(arr01.getClass().hashCode()==arr03.getClass().hashCode()));



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
