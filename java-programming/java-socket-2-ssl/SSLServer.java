import java.io.*;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class SSLServer {

	private SSLServerSocket serverSocket = null;

	public SSLServer() throws Exception {
		System.setProperty("javax.net.ssl.keyStore","/tmp/tls.keystore" );
		System.setProperty("javax.net.ssl.keyStorePassword","password" );
		System.setProperty("javax.net.ssl.trustStore","/tmp/tls.truststore");
		System.setProperty("javax.net.ssl.trustStorePassword","password");
		System.setProperty("javax.net.debug", "ssl,handshake");

		// 通过套接字工厂，获取一个服务器端套接字
		SSLServerSocketFactory socketFactory = (SSLServerSocketFactory)SSLServerSocketFactory.getDefault();
		serverSocket = (SSLServerSocket)socketFactory.createServerSocket(8443);
	}

	private void runServer() {
		while (true) {
			try {
				System.out.println("服务端启动成功，等待连接。。。");
				// 服务器端套接字进入阻塞状态，等待来自客户端的连接请求
				SSLSocket socket = (SSLSocket) serverSocket.accept();

				// 获取服务器端套接字输入流
				BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				// 从输入流中读取客户端用户名和密码
				String str = input.readLine();
				System.out.println("服务器接收到的信息："+str);

				// 获取服务器端套接字输出流
				PrintWriter output = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

				// ssl连接成功
				output.println("ssl验证成功");

				// 关闭流资源和套接字资源
				output.close();
				input.close();
				socket.close();

			} catch (IOException ioException) {
				ioException.printStackTrace();
			}
		}
	}

	public static void main(String args[]) throws Exception {
		SSLServer server = new SSLServer();
		server.runServer();
	}
}
