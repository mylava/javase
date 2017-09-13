package cn.mylava._300._4_Thread._182_Timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/** 定时任务调度
 * @author lipengfei
 */
public class Schedule {
    public static void main(String[] args) {
        Timer timer = new Timer();
        //schedule可以指定具体日期、相对日期等等
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(new Date());
            }
        },1000,2000);
    }
}
