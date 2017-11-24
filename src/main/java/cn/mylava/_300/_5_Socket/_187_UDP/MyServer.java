package cn.mylava._300._5_Socket._187_UDP;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 服务端
 * 1、创建服务端 + 端口
 * 2、准备接受容器
 * 3、准备接受包DatagramPacket(byte[] buf,int length)
 * 4、接受数据到包中
 * 5、解析数据  字节数组 通过 DataInputStream 转换成 double
 * 6、释放资源
 * @author lipengfei
 */
public class MyServer {
    public static void main(String[] args) throws IOException {
        //1
        DatagramSocket server = new DatagramSocket(8888);
        //2
        byte[] container = new byte[1024];
        //3
        DatagramPacket packet = new DatagramPacket(container,container.length);
        //4
        server.receive(packet);
        //5
//        byte[] data = packet.getData();
//        int len = packet.getLength();
//        System.out.println(new String(data,0,len));
        double num = convert(packet.getData());
        System.out.println(num);
        //6
        server.close();
    }

    public static double convert(byte[] data) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(data);
        DataInputStream dis = new DataInputStream(bis);
        double num = dis.readDouble();
        dis.close();
        return num;
    }
}
