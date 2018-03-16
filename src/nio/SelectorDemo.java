/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * Created by Administrator on 2018/1/18.
 */
public class SelectorDemo {
    public void run() throws Exception{
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress(9999));

        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true){
            int n = selector.select();
            if(n==0)continue;
            Iterator iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()){
                SelectionKey key = (SelectionKey) iterator.next();
                if (key.isAcceptable()){
                    SocketChannel socketChannel =((ServerSocketChannel)key.channel()).accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(key.selector(),SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                }
                if (key.isConnectable()){
                    System.out.println("isConnectable == true");
                    selector.wakeup();
                }
                if (key.isReadable()){
                    System.out.println("isReadable == true");
                    //((ServerSocketChannel)key.channel()).accept().read();
                }
                if (key.isWritable()){
                    System.out.println("isWritable == true");
                }
            }
        }
    }
}
