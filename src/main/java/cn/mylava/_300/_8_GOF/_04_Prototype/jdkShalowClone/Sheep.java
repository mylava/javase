package cn.mylava._300._8_GOF._04_Prototype.jdkShalowClone;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * comment: 克隆羊
 *
 * 想要实现克隆功能，必须实现Cloneable接口
 * Cloneable是一个空接口(真正的clone()方法在Object中定义)，即一个标记接口
 *
 * @author: lipengfei
 * @date: 17/01/2018
 */
public class Sheep implements Cloneable{
    private String name;
    private Date birthday;


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //直接调用object对象的clone方法(该方法为native方法，c语言实现，效率高)
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Sheep(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public Sheep() {
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Sheep{");
        sb.append("name='").append(name).append('\'');
        sb.append(", birthday=").append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(birthday));
        sb.append('}');
        return sb.toString();
    }
}
