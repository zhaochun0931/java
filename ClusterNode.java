import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

public class ClusterNode {
    private static final int PORT = 12345; // Port to listen on
    private static final List<ClusterNode> clusterNodes = new ArrayList<>();
    private static final ExecutorService executor = Executors.newCachedThreadPool();
    private static boolean networkSplit = false; // Simulate network partition
    
    private final String nodeName;
    private final ServerSocket serverSocket;

    public ClusterNode(String nodeName) throws IOException {
        this.nodeName = nodeName;
        this.serverSocket = new ServerSocket(PORT);
    }

    public void startNode() {
        executor.submit(() -> {
            try {
                System.out.println(nodeName + " is starting and waiting for connections...");
                while (true) {
                    Socket clientSocket = serverSocket.accept();
                    new ClientHandler(clientSocket).start();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void sendMessage(String message, ClusterNode recipientNode) {
        if (networkSplit && !clusterNodes.contains(recipientNode)) {
            System.out.println(nodeName + " cannot send message to " + recipientNode.nodeName + " due to network partition.");
            return;
        }
        
        try (Socket socket = new Socket("localhost", PORT)) {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println(message);
            System.out.println(nodeName + " sent message: " + message + " to " + recipientNode.nodeName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setNetworkSplit(boolean split) {
        networkSplit = split;
    }

    public static void addClusterNode(ClusterNode node) {
        clusterNodes.add(node);
    }

    private static class ClientHandler extends Thread {
        private final Socket socket;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received message: " + message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // Create and start nodes
        ClusterNode node1 = new ClusterNode("Node 1");
        ClusterNode node2 = new ClusterNode("Node 2");
        ClusterNode node3 = new ClusterNode("Node 3");

        addClusterNode(node1);
        addClusterNode(node2);
        addClusterNode(node3);

        node1.startNode();
        node2.startNode();
        node3.startNode();

        // Simulate network split after some time
        executor.submit(() -> {
            try {
                Thread.sleep(5000); // Allow nodes to connect first
                System.out.println("Simulating network partition...");
                setNetworkSplit(true);
                
                // Try sending a message after network split
                node1.sendMessage("Hello from Node 1", node3); // Will fail due to split
                Thread.sleep(5000); // Wait a bit before resolving the split
                System.out.println("Resuming normal communication...");
                setNetworkSplit(false);
                
                node1.sendMessage("Hello from Node 1", node2); // Should succeed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
