package cn.mylava._300._2_Collection._116_Generic.common;

/**
 * 不确定数据类型的时候,可以使用Object类型,但是Object类型时候需要强制类型转换,
 * 为了防止强转出错,还需要进行手动的类型检查
 * 使用泛型可以轻松避免这些问题.
 *
 * 概念：泛型就是参数化类型，使用广泛的类型。
 * 起因：数据类型不明确。
 * 作用：1.在编译的时候检查类型，提高安全性（如：不再出现运行时异常ClassCastException）
 *      2.所有的强制转换都是自动和隐式的，提高代码的重用率。
 */
public class App {
    public static void main(String[] args) {
        Student stu = new Student(80,90);
        int javase = (int) stu.getJavase();//强制类型转换 Object --> Integer -->自动拆箱
        System.out.println(javase);
        String oracle = null;
        //避免转换错误ClassCastException
        if (stu.getOracle() instanceof String) {
            oracle = (String) stu.getOracle();
        }
        System.out.println("成绩为:"+javase+","+oracle);
    }
}
