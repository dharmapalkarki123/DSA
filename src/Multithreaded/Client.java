package Multithreaded;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

    public Runnable getRunnable() {
        return () -> {
            int port = 8010;

            try {
                InetAddress address = InetAddress.getByName("localhost");
                Socket socket = new Socket(address, port);

                PrintWriter toSocket = new PrintWriter(socket.getOutputStream(), true); // auto-flush
                BufferedReader fromSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                toSocket.println("Hello from the Client");

                String line = fromSocket.readLine();
                System.out.println("Server replied: " + line);

                // Clean up
                fromSocket.close();
                toSocket.close();
                socket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        };
    }

    public static void main(String[] args) {
        Client client = new Client();

        for (int i = 0; i < 100; i++) {
            try {
                Thread thread = new Thread(client.getRunnable());
                thread.start();

                
            } catch (Exception e) {
                return;
            }
        }
    }
}
