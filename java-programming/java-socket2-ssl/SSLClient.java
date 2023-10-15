import java.io.*;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class SSLClient {

	private SSLSocket socket = null;

	public SSLClient() throws IOException {
		System.setProperty("javax.net.ssl.keyStore","/root/tls.keystore" );
		System.setProperty("javax.net.ssl.keyStorePassword","password" );
		System.setProperty("javax.net.ssl.trustStore","/root/tls.truststore");
		System.setProperty("javax.net.ssl.trustStorePassword","password");

		// 通过套接字工厂，获取一个客户端套接字
		SSLSocketFactory socketFactory = (SSLSocketFactory)SSLSocketFactory.getDefault();
		socket = (SSLSocket) socketFactory.createSocket("localhost", 8443);
	}

	public void connect() {
		try {
			// 获取客户端套接字输出流
			PrintWriter output = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			// 通过输出流发送到服务器端
			output.println("hello,server");
			output.flush();

			// 获取客户端套接字输入流
			BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			// 从输入流中读取服务器端传送的数据内容，并打印出来
			String response = input.readLine();
			System.out.println(response);

			// 关闭流资源和套接字资源
			output.close();
			input.close();
			socket.close();
		} catch (IOException ioException) {
			ioException.printStackTrace();
		} finally {
			System.exit(0);
		}
	}

	public static void main(String args[]) throws IOException {
		new SSLClient().connect();
	}
}
