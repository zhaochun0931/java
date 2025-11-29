import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Set;

public class NioServer {

    public static void main(String[] args) throws IOException {

        Selector selector = Selector.open();

        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        serverChannel.bind(new InetSocketAddress(8080));
        serverChannel.configureBlocking(false);

        serverChannel.register(selector, SelectionKey.OP_ACCEPT);

        System.out.println("NIO server started on port 8080...");

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        while (true) {
            selector.select();

            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> iter = keys.iterator();

            while (iter.hasNext()) {
                SelectionKey key = iter.next();
                iter.remove();

                if (key.isAcceptable()) handleAccept(key, selector);
                else if (key.isReadable()) handleRead(key, buffer);
            }
        }
    }

    private static void handleAccept(SelectionKey key, Selector selector) throws IOException {
        ServerSocketChannel server = (ServerSocketChannel) key.channel();
        SocketChannel client = server.accept();

        client.configureBlocking(false);
        client.register(selector, SelectionKey.OP_READ);

        InetSocketAddress addr = (InetSocketAddress) client.getRemoteAddress();

        System.out.println("[ACCEPT] " +
                addr.getAddress().getHostAddress() + ":" + addr.getPort() +
                " @ " + LocalDateTime.now()
        );
    }

    private static void handleRead(SelectionKey key, ByteBuffer buffer) throws IOException {
        SocketChannel client = (SocketChannel) key.channel();

        buffer.clear();
        int bytesRead = client.read(buffer);

        if (bytesRead == -1) {
            client.close();
            System.out.println("[CLOSE] Client disconnected");
            return;
        }

        buffer.flip();
        byte[] data = new byte[buffer.remaining()];
        buffer.get(data);

        String msg = new String(data).trim();
        System.out.println("[READ] " + msg);

        if (msg.equalsIgnoreCase("bye")) {
            client.close();
            System.out.println("[CLOSE] bye request");
            return;
        }

        buffer.clear();
        buffer.put(("Echo: " + msg).getBytes());
        buffer.flip();
        client.write(buffer);
    }
}

