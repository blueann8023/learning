package me.lm.basic.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by blue_ann on 14/12/2018.
 */
public class NIOServer {

    private Selector selector;

    public void nioserver(String[] args) {

        try {
            selector = Selector.open(); //1 创建NIO之Selector模式,监听注册其内部的NetworkChannel上的IO事件

            ServerSocketChannel serverSocket = ServerSocketChannel.open(); //2 创建服务端ServerSocketChannel
            serverSocket.socket().bind(new InetSocketAddress(8080)); //3 服务端 服务监听端口
            serverSocket.configureBlocking(false); //4 ServerSocketChannel 设置为非阻塞模式
            SelectionKey register = serverSocket.register(selector, SelectionKey.OP_ACCEPT);//5 注册 服务端ServerSocketChannel到Selector 使其监听自己OP_ACCEPT 建立TCP连接的IO事件

            while (!Thread.interrupted()) {
                try {

                    selector.select(); //6 阻塞等待事件
                    Set selected = selector.selectedKeys(); //7 获取事件列表
                    Iterator it = selected.iterator();
                    while (it.hasNext()) {
                        it.remove();
                        dispatch((SelectionKey) (it.next())); //8 分发事件
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void dispatch(SelectionKey key) throws Exception {
        if (key.isAcceptable()) {
            register(key); //8.1 新连接建立，注册事件到Selector
        } else if (key.isReadable()) {
            read(key); //8.2 读事件处理
        } else if (key.isWritable()) {
            write(key); //8.3 写事件处理
        }
    }

    private void register(SelectionKey key) throws Exception {
        ServerSocketChannel server = (ServerSocketChannel) key.channel();
        SocketChannel channel = server.accept(); //8.1.1 获得和客户端连接的通道 SocketChannel
        channel.configureBlocking(false);
        channel.register(this.selector, SelectionKey.OP_READ); //8.1.2 客户端通道注册到selector上，监听可读事件
    }


    private void write(SelectionKey key) {
    }

    private void read(SelectionKey key) {
    }
}
