package cn.mylava._nio._2_channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.SocketChannel;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 12/12/2019
 */
public class NioChannelClient {
    private SocketChannel channel = null;

    private ByteBuffer buffer = ByteBuffer.allocate(8);
    private IntBuffer intBuffer = buffer.asIntBuffer();


    public static void main(String[] args) {
        int result = new NioChannelClient().getSum(56, 34);
        System.out.println("result = "+ result);
    }

    private int getSum(int a, int b) {
        int result = 0;
        try {
            //连接到服务端
            channel = connect();
            sendRequest(a, b);
            result = receiveResult();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 与服务器建立连接通道
     * @return
     * @throws IOException
     */
    public SocketChannel connect() throws IOException {
        return SocketChannel.open(new InetSocketAddress("localhost",8888));
    }

    /**
     * 发送请求到服务器
     */
    public void sendRequest(int a, int b) throws IOException {
        buffer.clear();
        intBuffer.put(0, a);
        intBuffer.put(1, b);
        channel.write(buffer);
        System.out.println("发送请求到服务端");
    }

    /**
     * 接收服务端运算结果
     * @return
     */
    private int receiveResult() throws IOException {
        buffer.clear();
        channel.read(buffer);
        return intBuffer.get(0);
    }
}
