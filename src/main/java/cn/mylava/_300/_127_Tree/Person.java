package cn.mylava._300._127_Tree;

/**
 * @author lipengfei
 */
public class Person {
    //变量设为final禁止修改
    private final String name;
    private final int score;

    //设为final之后，所有的构造函数中都要对成员变量进行初始化
    private Person() {
        name = null;
        score = 0;
    }

    public Person(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

//    public void setName(String name) {
//        this.name = name;
//    }

    public int getScore() {
        return score;
    }

//    public void setScore(int score) {
//        this.score = score;
//    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Person{");
        sb.append("name='").append(name).append('\'');
        sb.append(", score=").append(score);
        sb.append('}');
        return sb.toString();
    }
}
