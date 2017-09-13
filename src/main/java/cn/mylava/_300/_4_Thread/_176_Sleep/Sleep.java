package cn.mylava._300._4_Thread._176_Sleep;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * sleep主要应用场景：
 * 1.倒计时
 * 2.模拟网络延时
 *
 * 这个示例演示的是倒计时使用sleep。
 * @author lipengfei
 */
public class Sleep {
    public static void main(String[] args) throws InterruptedException {
//        countdown();
//        dateCountdown();
    }

    /**
     * 倒计时
     * @throws InterruptedException
     */
    public static void countdown() throws InterruptedException {
        int num=10;
        while (true) {
            System.out.println(num--);
            Thread.sleep(1000);
            if (num<=0) {
                break;
            }
        }
    }

    public static void dateCountdown() throws InterruptedException {
        //10秒后
        Date time = new Date(System.currentTimeMillis()+10*1000);
        long end = time.getTime();
        while (true) {
            System.out.println(new SimpleDateFormat("mm:ss").format(time));
            time = new Date(time.getTime()-1000);
            Thread.sleep(1000);
            if (end-10*1000>time.getTime()) {
                break;
            }
        }
    }

}
