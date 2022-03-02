package me.lm.socket;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * TODO
 *
 * @author bule_ann
 * @since 2022/1/8
 */
public class NIOServerWithSelector {

    private Selector selector;
    int port = 8080;

    /**
     * selector = select poll epoll
     *
     * @author blue_ann
     * @since 2022/1/8
     */
    @Test
    public void init() {

        try {

            selector = Selector.open(); // 创建NIO之Selector模式,监听注册其内部的NetworkChannel上的IO事件

            ServerSocketChannel serverSocket = ServerSocketChannel.open(); // 创建服务端ServerSocketChannel
            serverSocket.bind(new InetSocketAddress(port)); // 服务端 服务监听端口
            serverSocket.configureBlocking(false); // ServerSocketChannel 设置为os的nio非阻塞模式

            serverSocket.register(selector, SelectionKey.OP_ACCEPT);// 注册 服务端ServerSocketChannel到Selector 使其监听自己OP_ACCEPT 建立TCP连接的IO事件


            while (!Thread.interrupted()) {
                try {

                    int select = selector.select();//查询IO事件状态 内核遍历 一定程度减少系统调用
                    Set selected = selector.selectedKeys(); // 获取事件列表、IO状态
                    Iterator it = selected.iterator();
                    while (it.hasNext()) {
                        it.remove();
                        SelectionKey key = (SelectionKey) (it.next());
                        if (key.isAcceptable()) {
                            register(key); //8.1 新连接建立，注册事件到Selector
                        } else if (key.isReadable()) {
                            read(key); //8.2 读事件处理
                        } else if (key.isWritable()) {
                            write(key); //8.3 写事件处理
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void register(SelectionKey key) throws Exception {
        ServerSocketChannel server = (ServerSocketChannel) key.channel();
        SocketChannel channel = server.accept(); //8.1.1 获得和客户端连接的通道 SocketChannel
        channel.configureBlocking(false);
        channel.register(selector, SelectionKey.OP_READ); //8.1.2 客户端通道注册到selector上，监听可读事件
    }


    private void write(SelectionKey key) {
    }

    private void read(SelectionKey key) {
    }
}
