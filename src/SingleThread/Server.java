package SingleThread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	/**
	 * This method:
	 * 1. Starts server on a specific port
	 * 2. Waits for client connections
	 * 3. Accepts client request
	 * 4. Sends response back
	 * 5. Closes connection
	 */
	public void run() throws IOException {
		
		// Port where server will listen
		int port = 8010;
		
		// Create ServerSocket (acts like a "listener")
		ServerSocket socket = new ServerSocket(port);
		
		// Set timeout (20 seconds)
		// If no client connects within this time → exception occurs
		socket.setSoTimeout(20000);
		
		// Infinite loop → server keeps running continuously
		while (true) {
			try {
				
				// Waiting for client connection
				System.out.println("Server is listening on port " + port);
				
				// accept() blocks until a client connects
				Socket acceptedConnectionSocket = socket.accept();
				
				// Print client address
				System.out.println("Connection accepted from client " 
						+ acceptedConnectionSocket.getRemoteSocketAddress());
				
				// Output stream → send data TO client
				PrintWriter toClient = new PrintWriter(
						acceptedConnectionSocket.getOutputStream()
				);
				
				// Input stream → read data FROM client
				BufferedReader fromClient = new BufferedReader(
						new InputStreamReader(acceptedConnectionSocket.getInputStream())
				);
				
				// Send message to client
				toClient.println("Hello from server");
				
				// IMPORTANT: ensure data is sent
				toClient.flush();
				
				// (Optional) You can read client message like this:
				// String clientMsg = fromClient.readLine();
				// System.out.println("Client says: " + clientMsg);
				
				// Close resources for this client
				toClient.close();
				fromClient.close();
				acceptedConnectionSocket.close();
				
			} catch (IOException ex) {
				
				// Handles timeout or connection errors
				ex.printStackTrace();
			}
		}
	}
	

	public static void main(String[] args) {
		
		// Create server object
		Server server = new Server();
		
		try {
			// Start server
			server.run();
			
		} catch (Exception ex) {
			
			// Print error if something goes wrong
			ex.printStackTrace();
		}
	}
}