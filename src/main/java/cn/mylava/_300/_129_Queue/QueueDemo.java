package cn.mylava._300._129_Queue;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 使用队列模拟银行存款业务
 *
 * @author lipengfei
 */
public class QueueDemo {
    public static void main(String[] args) {
        Queue<Request> que = new ArrayDeque<>();
        //模拟排队情况
        for (int i=0;i<10;i++) {
            //匿名内部类只能访问final类型的外部变量
            final int num = i;
            que.offer(new Request() {
                @Override
                public void doposit() {
                    System.out.println("第"+num+"个人，办理存款业务，存款额度为："+Math.random()*10000);
                }
            });
        }
        //模拟处理业务
        dealWith(que);
    }

    public static void dealWith(Queue<Request> que){
        Request req = null;
        while (null != (req=que.poll()) ) {
            req.doposit();
        }
    }

}

interface Request {
    public void doposit();
}