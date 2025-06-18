package Multithreaded;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.function.Consumer;

public class Server {

//    public Consumer<Socket> getConsumer() {
//        return (clientSocket) -> {
//            try (
//                BufferedReader fromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//                PrintWriter toClient = new PrintWriter(clientSocket.getOutputStream(), true)
//            ) {
//                String clientMessage = fromClient.readLine();
//                System.out.println("Client says: " + clientMessage);
//
//                toClient.println("Hello from the server");
//
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            } finally {
//                try {
//                    clientSocket.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        };
//    }
	
	public Consumer<Socket> getConsumer() {
	    return (clientSocket) -> {
	        try (
	            BufferedReader fromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	            PrintWriter toClient = new PrintWriter(clientSocket.getOutputStream(), true)
	        ) {
	            String clientMessage = fromClient.readLine();

	            if (clientMessage != null) {
	                System.out.println("Client says: " + clientMessage);
	            } else {
	                System.out.println("Received null message from client.");
	            }

	            toClient.println("Hello from the server");

	        } catch (IOException ex) {
	            ex.printStackTrace();
	        } finally {
	            try {
	                clientSocket.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    };
	}


    public static void main(String[] args) {
        int port = 8010;
        Server serverInstance = new Server();

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            serverSocket.setSoTimeout(20000);
            System.out.println("Server is listening on port " + port);

            while (true) {
                try {
                    Socket acceptedSocket = serverSocket.accept();
                    Thread thread = new Thread(() -> serverInstance.getConsumer().accept(acceptedSocket));
                    thread.start();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        } catch (IOException ex) {
            System.err.println("Could not start server on port " + port);
            ex.printStackTrace();
        }
    }
}
