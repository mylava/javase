package cn.mylava._300._2_Collection._116_Generic.common;

/**
 * 引入泛型
 * Created by lpf on 16/8/10.
 */
public class Student {
    //成绩可能是整数、小数、字符串，所以用Object类型
    private Object javase;
    private Object Oracle;


    public Student() {
    }
    public Student(Object javase, Object oracle) {
        this.javase = javase;
        Oracle = oracle;
    }


    public Object getJavase() {
        return javase;
    }

    public void setJavase(Object javase) {
        this.javase = javase;
    }

    public Object getOracle() {
        return Oracle;
    }

    public void setOracle(Object oracle) {
        Oracle = oracle;
    }
}
