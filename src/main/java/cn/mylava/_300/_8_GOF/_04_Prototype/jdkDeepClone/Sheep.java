package cn.mylava._300._8_GOF._04_Prototype.jdkDeepClone;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * comment: 克隆羊
 *
 * @author: lipengfei
 * @date: 17/01/2018
 */
public class Sheep implements Cloneable{
    private String name;
    private Date birthday;


    @Override
    protected Object clone() throws CloneNotSupportedException {
        Sheep obj = (Sheep) super.clone();
        obj.birthday= (Date) this.birthday.clone(); //把属性也进行克隆，就是深克隆
        return obj;
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
