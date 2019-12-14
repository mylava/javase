package cn.mylava._nio._3_selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 12/12/2019
 */
public class SelectorServer {
    private Selector selector;
    private ServerSocketChannel serverSocketChannel;
    private int keys = 0;

    public static void main(String[] args) {
        new SelectorServer().start();
    }

    private void start() {
        try {
            initServer();
            listen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 初始化连接通道，并注册通道事件
     * @throws IOException
     */
    public void initServer() throws IOException {
        this.selector = Selector.open();
        serverSocketChannel  = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(8888));
        serverSocketChannel.configureBlocking(false);
        //注册到selector上，当客户端连接时触发
        SelectionKey key = serverSocketChannel.register(this.selector, SelectionKey.OP_ACCEPT);
    }

    /**
     * 对客户端请求进行监听
     */
    private void listen() throws IOException {
        System.out.println("服务器已经启动成功，正在监听感兴趣的事件");
        while (true) {
            //当注册的事件到达时，方法返回；否则会一直阻塞
            keys = this.selector.select();
            Iterator<SelectionKey> it = this.selector.selectedKeys().iterator();
            if (keys>0) {
                while (it.hasNext()) {
                    SelectionKey key = it.next();
                    it.remove();
                    //客户端请求连接
                    if (key.isAcceptable()) {
                        //通过SelectionKey获取注册的通道
                        serverSocketChannel = (ServerSocketChannel) key.channel();
                        //获得与客户端连接的通道
                        SocketChannel client = serverSocketChannel.accept();
                        //设置这个通道为非阻塞模式
                        client.configureBlocking(false);

                        //给客户端发送消息
                        client.write(ByteBuffer.wrap(new String("hello,可以给我发数据了").getBytes()));
                        client.register(this.selector, SelectionKey.OP_READ);
                    } else if (key.isReadable()) {
                        read(key);
                    }

                }
            } else {
                System.out.println("Select finished without any keys");
            }
        }
    }

    /**
     * 读取客户端消息事件
     * @param key
     * @throws IOException
     */
    private void read(SelectionKey key) throws IOException {
        SocketChannel channel = (SocketChannel) key.channel();

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int len = channel.read(buffer);
        String msg = "服务端收到消息为："+ new String(buffer.array(),0, len);
        System.out.println(msg);
    }


}
