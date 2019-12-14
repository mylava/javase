package cn.mylava._nio._3_selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 12/12/2019
 */
public class SelectorClient {
    private Selector selector;
    private ByteBuffer outBuff = ByteBuffer.allocate(1024);
    private ByteBuffer inBuff = ByteBuffer.allocate(1024);
    private int keys = 0;
    private SocketChannel channel;

    public static void main(String[] args) {
        new SelectorClient().start();
    }

    private void start() {
        try {
            initClient();
            listen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initClient() throws IOException {
        //获得一个socket通道，并没有进行连接
        channel = SocketChannel.open();
        //获取一个通道管理器
        selector = Selector.open();
        //设置通道为非阻塞
        channel.configureBlocking(false);

        //连接服务器
        channel.connect(new InetSocketAddress("localhost",8888));
        //注册channel连接服务器事件
        channel.register(this.selector, SelectionKey.OP_CONNECT);
    }

    public void listen() throws IOException {
        while (true) {
            keys = this.selector.select();
            if (keys>0) {
                Iterator<SelectionKey> iterator = this.selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    iterator.remove();
                    //如果连接到服务器
                    if (key.isConnectable()) {
                        //获取客户端通道
                        SocketChannel channel = (SocketChannel) key.channel();

                        //如果正在连接，就连接完成
                        if (channel.isConnectionPending()) {
                            channel.finishConnect();
                            System.out.println("连接完成");
                        }
                        //连接完成后注册写事件
                        channel.register(this.selector, SelectionKey.OP_WRITE);
                    } else if (key.isWritable()) {
                        SocketChannel channel = (SocketChannel) key.channel();

                        outBuff.clear();
                        System.out.println("客户端正在写数据...");

                        channel.write(outBuff.wrap("我是Client".getBytes()));
                        channel.register(this.selector, SelectionKey.OP_READ);

                        System.out.println("客户端写数据完成");
                    } else if (key.isReadable()) {
                        SocketChannel channel = (SocketChannel) key.channel();

                        inBuff.clear();
                        System.out.println("客户端开始读 数据...");
                        int len = channel.read(inBuff);

                        System.out.println("客户端读数据结束...");
                        System.out.println("收到从服务端的相应："+new String(inBuff.array(),0,len));
                    }
                }
            } else {
                System.out.println("Select finished without any keys");
            }
        }
    }

}
