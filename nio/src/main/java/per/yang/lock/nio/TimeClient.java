package per.yang.lock.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class TimeClient {

    public static void main(String[] args) {

        int port = 8080;
        if (args != null && args.length > 0){
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e){

            }
        }

        new Thread(new TimeClientHandler("127.0.0.1", port), "TimeClient-001").start();
    }

    private static class TimeClientHandler implements Runnable{
        private String host;
        private Integer port;
        private Selector selector;
        private SocketChannel socketChannel;
        private volatile boolean stop;

        TimeClientHandler(String host, Integer port) {
            this.host = host;
            this.port = port;
            try {
                selector = Selector.open();
                socketChannel = SocketChannel.open();
                socketChannel.configureBlocking(false);
            } catch (IOException e){
                e.printStackTrace();
                System.exit(1);
            }
        }

        public void run() {
            try {
                doConnect();
            } catch (IOException e){
                e.printStackTrace();
                System.exit(1);
            }

            while (!stop){
                try {
                    selector.select(1000);
                    Set<SelectionKey> selectionKeys = selector.selectedKeys();
                    Iterator<SelectionKey> iterator = selectionKeys.iterator();
                    SelectionKey key;
                    while (iterator.hasNext()){
                        key = iterator.next();
                        iterator.remove();
                        try {
                            handleInput(key);
                        } catch (IOException e){
                            if (key != null){
                                key.cancel();
                                if (key.channel() != null){
                                    key.channel().close();
                                }
                            }
                        }
                    }
                } catch (Exception e){
                    e.printStackTrace();
                    System.exit(1);
                }
            }

            if (selector != null){
                try {
                    selector.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(1);
                }
            }

        }

        private void doConnect() throws IOException {
            boolean connect = socketChannel.connect(new InetSocketAddress(host, port));
            if (connect){
                socketChannel.register(selector, SelectionKey.OP_READ);
                doWrite(socketChannel);
            } else {
                socketChannel.register(selector, SelectionKey.OP_CONNECT);
            }
        }

        private void doWrite(SocketChannel socketChannel) throws IOException {
            byte[] req = "QUERY TIME ORDER".getBytes();
            ByteBuffer writeBuffer = ByteBuffer.allocate(req.length);
            writeBuffer.put(req);
            writeBuffer.flip();
            socketChannel.write(writeBuffer);
            if (!writeBuffer.hasRemaining()){
                System.out.println("send order success");
            }

        }

        private void handleInput(SelectionKey key) throws IOException {

            if (!key.isValid()){
                return;
            }
            if (key.isConnectable()){
                SocketChannel socketChannel = (SocketChannel) key.channel();
                if (socketChannel.finishConnect()){
                    socketChannel.register(selector, SelectionKey.OP_READ);
                    doWrite(socketChannel);
                }else {
                    System.exit(1);
                }
            }else if (key.isReadable()){
                ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                SocketChannel socketChannel = (SocketChannel) key.channel();
                int readBytes = socketChannel.read(readBuffer);
                if (readBytes > 0){
                    readBuffer.flip();
                    byte[] bytes = new byte[readBuffer.remaining()];
                    readBuffer.get(bytes);
                    String body = new String(bytes, "UTF-8");
                    System.out.println("Now is: " + body);
                    this.stop = true;
                } else if (readBytes < 0){
                    key.cancel();
                    socketChannel.close();
                } else {
                    ;
                }
            } else {
                System.out.println("----------------------");
            }
        }
    }
}
