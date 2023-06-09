/**
 * Main
 * by Reda TARGAOUI
 * 12/05/2023
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Start server in a thread:
        Thread TCPServerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                TCPServer server = new TCPServer(8080);
                server.getData();
            }
        });
        TCPServerThread.start();

        // Start client in a thread:
        Thread TCPClientThread = new Thread(new Runnable() {
            @Override
            public void run() {
                TCPCLient client = new TCPClient("localhost", 8080);
                // Create scanner to get user input :
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter a message: ");
                String message = scanner.nextLine();
                
                // Send to server
                client.sendData(message);
            }
        });
        TCPClientThread.start();
    }
}
