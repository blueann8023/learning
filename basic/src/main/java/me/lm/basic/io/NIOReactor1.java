package me.lm.basic.io;

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
 * Created by blue_ann on 14/12/2018.
 */
public class NIOReactor1 {

    @Test
    public void nioserver() {

        try {
            Selector selector = Selector.open();
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(8080));
            serverSocketChannel.configureBlocking(false);

            new Reactor(serverSocketChannel, selector).run();  // 创建Reactor

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    /**
     * 等待事件到来，分发事件处理
     */
    class Reactor implements Runnable {

        private ServerSocketChannel serverSocketChannel;
        private Selector selector;

        public Reactor(ServerSocketChannel serverSocketChannel, Selector selector) {
            this.serverSocketChannel = serverSocketChannel;
            this.selector = selector;
        }

        @Override
        public void run() {
            try {
                SelectionKey sk = this.serverSocketChannel.register(this.selector, SelectionKey.OP_ACCEPT); // serverSocketChannel 注册 OP_ACCEPT
                sk.attach(new Acceptor(serverSocketChannel, selector));  // 给ACCEPT事件关联Acceptor，处理新连接

                while (!Thread.interrupted()) {
                    this.selector.select();
                    Set selected = this.selector.selectedKeys();
                    Iterator it = selected.iterator();
                    while (it.hasNext()) {
                        it.remove();
                        dispatch((SelectionKey) (it.next())); //分发事件处理
                    }
                }
            } catch (IOException ex) {
                //do something
            }
        }

        void dispatch(SelectionKey k) {
            // 若是连接事件获取是acceptor
            // 若是IO读写事件获取是handler
            Runnable runnable = (Runnable) (k.attachment());
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    /**
     * 连接事件就绪,处理连接事件
     */
    class Acceptor implements Runnable {

        private ServerSocketChannel serverSocketChannel;
        private Selector selector;

        public Acceptor(ServerSocketChannel serverSocketChannel, Selector selector) {
            this.serverSocketChannel = serverSocketChannel;
            this.selector = selector;
        }

        @Override
        public void run() {
            try {
                SocketChannel clientSocketChannel = serverSocketChannel.accept(); // 获取clientSocketChannel
                if (clientSocketChannel != null) {
                    SelectionKey sk = clientSocketChannel.register(selector, SelectionKey.OP_READ);// clientSocketChannel 注册OP_READ
                    sk.attach(new Handler(clientSocketChannel, selector));// 给READ事件关联Handler,处理读
                }
            } catch (Exception e) {
            }
        }
    }

    /**
     * 读写事件就绪,处理读写事件
     */
    class Handler implements Runnable {

        private SocketChannel socketChannel;
        private Selector selector;

        Handler(SocketChannel socketChannel, Selector selector) {
            this.socketChannel = socketChannel;
            this.selector = selector;
        }

        @Override
        public void run() {
            // do something with socketChannel read
            // register other event
        }
    }
}