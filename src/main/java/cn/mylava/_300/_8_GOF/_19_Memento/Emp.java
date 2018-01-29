package cn.mylava._300._8_GOF._19_Memento;

/**
 * comment: 雇员模拟源发器类
 *
 * @author: lipengfei
 * @date: 29/01/2018
 */
public class Emp {
    private String name;
    private int age;
    private double salary;

    //进行备忘操作
    public EmpMemento memento() {
        return new EmpMemento(this);
    }

    //数据还原操作
    public void recovery(EmpMemento mmt) {
        this.name = mmt.getName();
        this.age = mmt.getAge();
        this.salary = mmt.getSalary();
    }


    public Emp(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Emp{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", salary=").append(salary);
        sb.append('}');
        return sb.toString();
    }
}
