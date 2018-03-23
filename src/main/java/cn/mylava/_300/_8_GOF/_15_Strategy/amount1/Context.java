package cn.mylava._300._8_GOF._15_Strategy.amount1;

/**
 * comment: 上下文环境类，负责与具体的策略类及客户端交互
 * 使具体的算法和客户端分离，使得算法可以独立于客户端独立的变化
 *
 * @author: lipengfei
 * @date: 26/01/2018
 */
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void printPrice(double standardPrice) {
        System.out.println("报价为："+strategy.getPrice(standardPrice));
    }
}
