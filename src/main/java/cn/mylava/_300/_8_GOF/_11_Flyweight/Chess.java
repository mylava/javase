package cn.mylava._300._8_GOF._11_Flyweight;

/**
 * comment: 抽象享元类
 *
 * @author: lipengfei
 * @date: 24/01/2018
 */
public interface Chess {
    void setColor(String color);
    //提供内部状态
    String getColor();
    //设置外部状态
    void display(Coordinate coordinate);
}
