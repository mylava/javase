package cn.mylava._300._8_GOF._09_Decorator;

/** 具体构建角色
 * comment:
 *
 * @author: lipengfei
 * @date: 24/01/2018
 */
public class Car implements ICar {
    @Override
    public void move() {
        System.out.println("我能陆地上跑");
    }
}
