package cn.mylava._300._5_Socket._187_UDP;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * 客户端
 * 1、创建客户端+端口
 * 2、准备数据 double 通过 字节数组输出流 转换成 字节数组
 * 3、打包数据，设置发送地点及端口 DatagramPacket(byte[],int length,InetSocketAddress address)
 * 4、发送
 * 5、释放资源
 * @author lipengfei
 */
public class MyClient {
    public static void main(String[] args) throws IOException {
        //1
        DatagramSocket client = new DatagramSocket(6666);
        //2
//        String msg =  "udp编程";
//        byte[] data = msg.getBytes();
        double num = 12.16;
        byte[] data = convert(num);
        //3
        DatagramPacket packet = new DatagramPacket(data,data.length,new InetSocketAddress("localhost",8888));
        //4
        client.send(packet);
        //5
        client.close();
    }

    public static byte[] convert(double num) throws IOException {
        byte[] data = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(bos);
        dos.writeDouble(num);
        dos.flush();
        data = bos.toByteArray();
        dos.close();
        return data;
    }
}
