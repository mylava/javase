package cn.mylava._300._8_GOF._19_Memento;

/**
 * comment: 负责人类，管理备忘录对象
 *
 * @author: lipengfei
 * @date: 29/01/2018
 */
public class CareTaker {

    private EmpMemento memento;

    public EmpMemento getMemento() {
        return memento;
    }

    public void setMemento(EmpMemento memento) {
        this.memento = memento;
    }
}
