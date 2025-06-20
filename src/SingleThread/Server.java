package SingleThread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	
	public void run() throws IOException {
		int port=8010;
		ServerSocket socket =new ServerSocket(port);
		socket.setSoTimeout(20000);
		
		while(true) {
			try {
				
				System.out.println("Server is listening on port " +port);
				Socket acceptedConnectionSocket=socket.accept();
				System.out.println("Connection accepted from client" +acceptedConnectionSocket.getRemoteSocketAddress());
				PrintWriter toClient=new PrintWriter(acceptedConnectionSocket.getOutputStream());
				BufferedReader fromClient =new BufferedReader(new InputStreamReader(acceptedConnectionSocket.getInputStream()));
				toClient.println("Hello from server");
				toClient.close();
				fromClient.close();
				acceptedConnectionSocket.close();
				
				
				
			} catch(IOException ex) {
				
				ex.printStackTrace();
				
			}
		}
	}
	

	public static void main(String[] args) {
	Server server = new Server();
	try {
		
		server.run();
		
		
		
	} catch(Exception ex) {
		
		ex.printStackTrace();
		
		
	}

	}
	
	
}
