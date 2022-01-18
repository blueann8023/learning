package me.lm.basic.socket;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by blue_ann on 14/12/2018.
 */
public class NIOServer {

    @Test
    public void init() {
        try {
            List<SocketChannel> clientSocketChannels = new LinkedList<>();

            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open(); // 创建服务端ServerSocketChannel
            serverSocketChannel.bind(new InetSocketAddress(8081)); // 服务端 服务监听端口
            serverSocketChannel.configureBlocking(false); // ServerSocketChannel 设置为os的nio非阻塞模式

            while (true) {
                SocketChannel clientSocketChannel = serverSocketChannel.accept(); //非阻塞
                if (clientSocketChannel == null) {
                    System.out.println("null");
                } else {
                    clientSocketChannel.configureBlocking(false);
                    clientSocketChannels.add(clientSocketChannel);
                    System.out.println(clientSocketChannel.socket().getPort());
                }
                // 读写channel
                ByteBuffer byteBuffer = ByteBuffer.allocateDirect(4096);//也可以堆内
                for (SocketChannel socketChannel : clientSocketChannels) { //用户态遍历
                    int read = socketChannel.read(byteBuffer);//非阻塞
                    if (read > 0) {
                        byteBuffer.flip();
                        byte[] bytes = new byte[byteBuffer.limit()];
                        byteBuffer.get(bytes);
                        String info = new String(bytes);
                        System.out.println(clientSocketChannel.socket().getPort() + ":" + info);
                        byteBuffer.clear();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
