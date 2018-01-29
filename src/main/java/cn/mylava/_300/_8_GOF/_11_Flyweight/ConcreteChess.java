package cn.mylava._300._8_GOF._11_Flyweight;

/**
 * comment: 具体享元类
 *
 * @author: lipengfei
 * @date: 24/01/2018
 */
public class ConcreteChess implements Chess {
    //为内部状态提供成员变量进行存储，表示共享的数据
    private String color;

    public ConcreteChess(String color) {
        this.color = color;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public void display(Coordinate coordinate) {
        System.out.println("棋子颜色："+color);
        System.out.println("棋子位置："+ coordinate.getX()+"-----"+coordinate.getY());
    }
}
