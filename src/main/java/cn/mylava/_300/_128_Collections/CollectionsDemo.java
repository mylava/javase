package cn.mylava._300._128_Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author lipengfei
 */
public class CollectionsDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(5);
        list.add(7);
        list.add(9);

        System.out.println(list.toString());

        //反转
        Collections.reverse(list);
        System.out.println("反转之后"+list);

        //模拟斗地主
        List<Integer> cards = new ArrayList<>();
        for (int i=0;i<54;i++) {
            cards.add(i);
        }
        //洗牌
        Collections.shuffle(cards);
        List<Integer> p1 = new ArrayList<>();
        List<Integer> p2 = new ArrayList<>();
        List<Integer> p3 = new ArrayList<>();
        List<Integer> last = new ArrayList<>();

        //每人17张,留3张底牌
        for (int i=0;i<51;i=i+3){
            p1.add(cards.get(i));
            p2.add(cards.get(i+1));
            p3.add(cards.get(i+2));
        }
        //三张底牌
        last.add(cards.get(51));
        last.add(cards.get(52));
        last.add(cards.get(53));

        System.out.println("玩家一："+p1);
        System.out.println("玩家二："+p2);
        System.out.println("玩家三："+p3);
        System.out.println("底牌："+last);
    }
}
