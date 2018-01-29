package cn.mylava._300._8_GOF._11_Flyweight;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 24/01/2018
 */
public class Client {
    public static void main(String[] args) {
        Chess chess1 = ChessFlyweightFactor.getChess("black");
        Chess chess2 = ChessFlyweightFactor.getChess("black");
        System.out.println(chess1);
        System.out.println(chess2);

        System.out.println("增加外部状态处理------");
        chess1.display(new Coordinate(10,10));
        chess1.display(new Coordinate(10,20));

    }
}
