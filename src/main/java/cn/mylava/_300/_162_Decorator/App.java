package cn.mylava._300._162_Decorator;

/**
 * 装饰模式
 *
 * 设计模式  -->  类与类之间的关系
 * 1.依赖： 形参 或 局部变量
 * 2.关联： 属性
 *          聚合： 不一致的生命周期
 *          组合： 一致的生命周期
 * 3.继承： 子父类关系
 * 4.实现： 接口与实现类关系
 *
 * @author lipengfei
 */
public class App {
    public static void main(String[] args) {
        Voice v = new Voice();
        v.say();
        LoudSpeaker ls = new LoudSpeaker(v);
        ls.say();
    }
}
