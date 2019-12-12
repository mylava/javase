package cn.mylava.gc;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 29/07/2018
 */
public class TestMinorGc {
    private static final int _1MB = 1024 * 1024;
    public static void main(String[] args) {
        byte[] allocation1,allocation2,allocation3,allocation4;
        allocation1 = new byte[2*_1MB];
        allocation2 = new byte[2*_1MB];
        allocation3 = new byte[2*_1MB];
        allocation4 = new byte[4*_1MB];
        System.out.println("测试完成");
    }
}
