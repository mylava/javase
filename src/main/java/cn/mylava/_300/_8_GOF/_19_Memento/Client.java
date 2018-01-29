package cn.mylava._300._8_GOF._19_Memento;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 29/01/2018
 */
public class Client {
    public static void main(String[] args) {
        CareTaker taker =  new CareTaker();

        Emp emp = new Emp("张三",18 ,9000);
        System.out.println("第一次创建对象："+emp.toString());

        taker.setMemento(emp.memento());//进行一次备份

        emp.setAge(21);
        emp.setSalary(12000);
        System.out.println("第二次创建对象："+emp.toString());

        emp.recovery(taker.getMemento());//恢复到18岁

        System.out.println("恢复后的对象："+emp.toString());
    }
}
