package cn.mylava.test;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 08/03/2018
 */
public class T {
    public static void main(String[] args) {
        /*String a = "loginflag=yes&returnflag=success&payinfo=123456&userid=123456789012&payoerdernum=12121&paytime=yyyymmdd&paycode=000000&payflowno=2323&rsa_random_num=AAAAAA&rsa_time_flag=HHMMSS&signvalue=KKKKKK";
        String text = a.substring(0,a.lastIndexOf("&"));
        String sign = a.substring(a.lastIndexOf("&")+1);

        System.out.println(text);
        System.out.println(sign);
*/

        String t = "order_status: 2\r\n900123456||0.05||2012-09-12||RC000||200000111083||302c021***4f97||000400004500021";
        String[] vvs = t.split("\r\n");
        String[] split = vvs[1].split("\\|\\|");
        for (String s : split){
            System.out.println(s);
        }
    }
}
