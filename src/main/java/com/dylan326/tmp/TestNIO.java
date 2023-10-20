package com.dylan326.tmp;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by dylan on 2023/10/13.
 */
public class TestNIO {
    public static void main(String[] args) throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        Selector selector = Selector.open();

        // 绑定端口
        serverSocketChannel.socket().bind(new InetSocketAddress(8080));

        // 设置 serverSocketChannel 为非阻塞模式
        serverSocketChannel.configureBlocking(false);

        // 注册 serverSocketChannel 到 selector，关注 OP_ACCEPT 事件
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            // 没有事件发生
            if (selector.select(1000) == 0) {
                continue;
            }

            // 有事件发生，找到发生事件的 Channel 对应的 SelectionKey 的集合
            Set<SelectionKey> selectionKeys = selector.selectedKeys();

            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();

                // 发生 OP_ACCEPT 事件，处理连接请求
                if (selectionKey.isAcceptable()) {
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);
                    // 将 socketChannel 也注册到 selector，关注 OP_READ
                    // 事件，并给 socketChannel 关联 Buffer
                    socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                }

                // 发生 OP_READ 事件，读客户端数据
                if (selectionKey.isReadable()) {
                    SocketChannel channel = (SocketChannel) selectionKey.channel();
                    ByteBuffer buffer = (ByteBuffer) selectionKey.attachment();
                    int end = channel.read(buffer);
                    System.out.println("msg form client: " + new String(Arrays.copyOf(buffer.array(), end)));
                }

                // 手动从集合中移除当前的 selectionKey，防止重复处理事件
                iterator.remove();
            }
        }
    }
}
