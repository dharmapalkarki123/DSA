package ThreadPool;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
	
	private final ExecutorService threadPool;
	
	public Server(int poolSize) {
		this.threadPool=Executors.newFixedThreadPool(poolSize);
		
	}
	
	public void handleClient(Socket clientSocket) {
		
		try 		(PrintWriter toSocket=new PrintWriter(clientSocket.getOutputStream(),true))
{
			toSocket.println("Hello form server" + clientSocket.getInetAddress());
			
		} catch (IOException ex) {
			
			ex.printStackTrace();
			// TODO: handle exception
		}
		
	}
	
	
	public static void main(String[] args) {
		int port = 8010;
		
		int poolSize=100;
		Server server = new Server(poolSize);
		try {
			ServerSocket serverSocket=new ServerSocket(port);
			serverSocket.setSoTimeout(70000);
			System.out.println("Server is listening port " +port);
			while(true) {
				
				Socket clientSocket = serverSocket.accept();
				server.threadPool.execute(()->server.handleClient(clientSocket));
				
				
			}
		} catch (IOException ex) {
			
			ex.printStackTrace();
			
			
		}finally {
			server.threadPool.shutdown();
		}
		
	}

}
