package ThreadPool;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * This class represents a simple multi-threaded server
 * using a fixed thread pool to handle multiple clients.
 */
public class Server {
    
    // Thread pool to manage worker threads (limits number of concurrent threads)
    private final ExecutorService threadPool;

    /**
     * Constructor to initialize thread pool with fixed number of threads
     * 
     * @param poolSize Number of threads in the pool
     */
    public Server(int poolSize) {
        // Creates a fixed number of reusable threads
        this.threadPool = Executors.newFixedThreadPool(poolSize);
    }

    /**
     * This method handles communication with a connected client.
     * Each client request will be processed by a thread from the pool.
     * 
     * @param clientSocket The socket representing client connection
     */
    public void handleClient(Socket clientSocket) {

        // Try-with-resources ensures PrintWriter is automatically closed
        try (PrintWriter toSocket = new PrintWriter(clientSocket.getOutputStream(), true)) {

            // Send a simple response message to the client
            toSocket.println("Hello from server " + clientSocket.getInetAddress());

        } catch (IOException ex) {
            // Print error if something goes wrong while handling client
            ex.printStackTrace();
        }
    }

    /**
     * Main method to start the server
     */
    public static void main(String[] args) {

        int port = 8010;      // Port where server will listen
        int poolSize = 100;   // Maximum number of threads

        // Create server instance with thread pool
        Server server = new Server(poolSize);

        try {
            // Create ServerSocket to listen for incoming client connections
            ServerSocket serverSocket = new ServerSocket(port);

            // Set timeout for accept() (70 seconds)
            // If no client connects within this time, exception will be thrown
            serverSocket.setSoTimeout(70000);

            System.out.println("Server is listening on port " + port);

            // Infinite loop to keep server running
            while (true) {

                // Wait for a client to connect (blocking call)
                Socket clientSocket = serverSocket.accept();

                // Submit client handling task to thread pool
                // Lambda expression used for cleaner code
                server.threadPool.execute(() -> server.handleClient(clientSocket));
            }

        } catch (IOException ex) {
            // Handle server errors (e.g., timeout, port issues)
            ex.printStackTrace();

        } finally {
            // Gracefully shutdown thread pool when server stops
            server.threadPool.shutdown();
        }
    }
}