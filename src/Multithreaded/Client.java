package Multithreaded;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

    // This method returns a Runnable object
    // Runnable defines the task that each thread will execute
    public Runnable getRunnable() {
        return () -> {

            // Port number where the server is running
            int port = 8010;

            try {
                // Get the IP address of the server (localhost = same machine)
                InetAddress address = InetAddress.getByName("localhost");

                // Create a socket connection to the server using IP and port
                Socket socket = new Socket(address, port);

                // Output stream to send data to the server
                // 'true' enables auto-flush (data is sent immediately)
                PrintWriter toSocket = new PrintWriter(socket.getOutputStream(), true);

                // Input stream to receive data from the server
                BufferedReader fromSocket = new BufferedReader(
                        new InputStreamReader(socket.getInputStream())
                );

                // Send a message to the server
                toSocket.println("Hello from the Client");

                // Read response from the server (line by line)
                String line = fromSocket.readLine();

                // Print the response received from the server
                System.out.println("Server replied: " + line);

                // Close all resources to avoid memory leaks
                fromSocket.close();
                toSocket.close();
                socket.close();

            } catch (IOException e) {
                // Handle any I/O errors (like connection failure)
                e.printStackTrace();
            }
        };
    }

    public static void main(String[] args) {

        // Create a Client object
        Client client = new Client();

        // Loop to create 100 threads (simulate 100 clients)
        for (int i = 0; i < 100; i++) {
            try {
                // Each thread will run the same task (getRunnable)
                Thread thread = new Thread(client.getRunnable());

                // Start the thread (executes run() method internally)
                thread.start();

            } catch (Exception e) {
                // If any unexpected error occurs, stop execution
                return;
            }
        }
    }
}