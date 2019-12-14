package cn.mylava._nio._2_channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 12/12/2019
 */
public class NioChannelServer {
    private ByteBuffer buffer = ByteBuffer.allocate(1024);
    //缓冲区视图
    private IntBuffer intBuffer = buffer.asIntBuffer();
    private SocketChannel clientChannel = null;
    private ServerSocketChannel serverSocketChannel = null;


    public static void main(String[] args) {
        new NioChannelServer().start();
    }

    public void start() {
        try {
            //打开服务通道
            openChannel();
            //等待客户端请求
            waitReqConn();

            System.out.println("服务端处理完毕");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 打开服务端的通道
     */
    public void openChannel() throws IOException {
        //建立一个新的连接通道
        serverSocketChannel = ServerSocketChannel.open();
        System.out.println("是否为阻塞通道："+serverSocketChannel.isBlocking());
        //为新的通道设置访问端口
        ServerSocket socket = serverSocketChannel.socket();
        socket.bind(new InetSocketAddress(8888));

        System.out.println("服务端通道已打开");
    }

    /**
     * 等待客户端的请求连接
     */
    private void waitReqConn() throws Exception {
        while (true) {
            //没有设置，默认为阻塞模式
            clientChannel = serverSocketChannel.accept();
            if (null!=clientChannel) {
                System.out.println("新的连接加入");
            }
            //处理请求
            processReq();
            clientChannel.close();
        }
    }

    /**
     * 处理请求过来的数据
     */
    private void processReq() throws IOException {
        System.out.println("开始读取和处理客户端数据...");
        //把position设置为0，limit设置为buffer最大容量
        buffer.clear();
        clientChannel.read(buffer);
        int result = intBuffer.get(0)+intBuffer.get(1);
        buffer.flip();
        buffer.clear();
        intBuffer.put(0,result);
        clientChannel.write(buffer);
        System.out.println("客户端数据处理完成");
    }


}
