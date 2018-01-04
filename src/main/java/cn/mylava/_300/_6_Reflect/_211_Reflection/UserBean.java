package cn.mylava._300._6_Reflect._211_Reflection;

/**
 * comment: 测试反射的bean对象
 *
 * @author: lipengfei
 * @date: 04/01/2018
 */
public class UserBean {

    private int id;
    private int age;
    private String uname;

    public UserBean() {
    }

    public UserBean(int id, int age, String uname) {
        this.id = id;
        this.age = age;
        this.uname = uname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("UserBean{");
        sb.append("id=").append(id);
        sb.append(", age=").append(age);
        sb.append(", uname='").append(uname).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
