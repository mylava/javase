package cn.mylava._300._5_Socket._185_NetAddress;

import java.net.InetSocketAddress;

/**
 * 封装端口：在InetAddress的基础上+端口
 * @author lipengfei
 */
public class InetSocketAddressDemo {
    public static void main(String[] args) {
        InetSocketAddress address = new InetSocketAddress("localhost",9999);
        System.out.println(address.getAddress());
        System.out.println(address.getHostName());
        System.out.println(address.getPort());


    }
}
