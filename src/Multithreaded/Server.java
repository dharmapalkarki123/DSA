package Multithreaded;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.function.Consumer;

public class Server {

    // This method returns a Consumer that handles each client connection
    public Consumer<Socket> getConsumer() {
        return (clientSocket) -> {
            try (
                // Read data sent from client
                BufferedReader fromClient = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));

                // Send data to client (auto flush enabled)
                PrintWriter toClient = new PrintWriter(
                        clientSocket.getOutputStream(), true)
            ) {

                // Read one line message from client
                String clientMessage = fromClient.readLine();

                // Check if message is not null (client may disconnect)
                if (clientMessage != null) {
                    System.out.println("Client says: " + clientMessage);
                } else {
                    System.out.println("Received null message from client.");
                }

                // Send response back to client
                toClient.println("Hello from the server");

            } catch (IOException ex) {
                // Print error if something goes wrong
                ex.printStackTrace();
            } finally {
                try {
                    // Always close the socket after communication
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    public static void main(String[] args) {

        // Port number where server will listen
        int port = 8010;

        // Create server object
        Server serverInstance = new Server();

        // Try-with-resources to automatically close ServerSocket
        try (ServerSocket serverSocket = new ServerSocket(port)) {

            // Set timeout (20 seconds) for accepting connections
            serverSocket.setSoTimeout(20000);

            System.out.println("Server is listening on port " + port);

            // Infinite loop to keep server running
            while (true) {
                try {
                    // Wait for client to connect
                    Socket acceptedSocket = serverSocket.accept();

                    // Create new thread for each client (multithreading)
                    Thread thread = new Thread(() ->
                        serverInstance.getConsumer().accept(acceptedSocket)
                    );

                    // Start the thread (handle client in parallel)
                    thread.start();

                } catch (IOException ex) {
                    // Handle exception while accepting connection
                    ex.printStackTrace();
                }
            }

        } catch (IOException ex) {
            // Error if server fails to start
            System.err.println("Could not start server on port " + port);
            ex.printStackTrace();
        }
    }
}