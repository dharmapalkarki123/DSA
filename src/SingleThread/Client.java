package SingleThread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

	/**
	 * This method is responsible for:
	 * 1. Connecting to the server
	 * 2. Sending a message
	 * 3. Receiving a response
	 * 4. Closing all resources
	 */
	public void run() throws IOException {
		
		// Port number where server is running
		int port = 8010;
		
		// Get IP address of server (localhost = same machine)
		InetAddress address = InetAddress.getByName("localhost");
		
		// Create socket connection to server using IP and port
		Socket socket = new Socket(address, port);
		
		// Output stream → used to SEND data to server
		PrintWriter toSocket = new PrintWriter(socket.getOutputStream());
		
		// Input stream → used to RECEIVE data from server
		BufferedReader fromSocket = new BufferedReader(
				new InputStreamReader(socket.getInputStream())
		);
		
		// Send message to server
		// NOTE: println() writes data but may buffer it
		toSocket.println("Hello from the Client");
		
		// IMPORTANT: flush ensures data is actually sent immediately
		toSocket.flush();
		
		// Read response from server (waits until server sends something)
		String line = fromSocket.readLine();
		
		// Print server response
		System.out.println("Server replied: " + line);

		// Close resources (VERY IMPORTANT to avoid memory leaks)
		toSocket.close();
		fromSocket.close();
		socket.close();
	}
	

	public static void main(String[] args) {
		try {
			// Create client object
			Client client = new Client();
			
			// Run client logic
			client.run();
			
		} catch (Exception ex) {
			
			// Print error if something goes wrong
			ex.printStackTrace();
		}
	}
}