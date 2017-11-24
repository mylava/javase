package cn.mylava._300._5_Socket._185_NetAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * InetAddress表示互联网上的IP地址。
 * @author lipengfei
 */
public class InetAddressDemo {
    public static void main(String[] args) throws UnknownHostException {
        //使用getLocalHost方法创建 本机 对应的InetAddress对象
        java.net.InetAddress address = InetAddress.getLocalHost();
        System.out.println(address.getHostAddress());
        System.out.println(address.getHostName());

        //根据 域名 获取InetAddress对象
        address = InetAddress.getByName("www.163.com");
        System.out.println(address.getHostAddress());
        System.out.println(address.getHostName());


        //根据 IP地址 获取InetAddress对象
        address = InetAddress.getByName("219.238.2.185");
        System.out.println(address.getHostAddress());
        System.out.println(address.getHostName());
    }
}
