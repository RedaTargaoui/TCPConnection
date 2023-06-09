/**
 * Represents the server side in TCP connection
 * by Reda TARGAOUI
 * 16/05/2023
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    // Attributes :
    private ServerSocket serverSocket;// server socket

    /**
     * Initialise the serverSocket
     * @param serverPort server port
     */
    public TCPServer(int serverPort) {
        try {
            this.serverSocket = new ServerSocket(serverPort);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Receive the data from client
     */
    public void getData() {
        try {
            Socket clientSocket = serverSocket.accept();// Wait for client connection

            // To read the received data :
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String response;// To get Client's response
            while ( (response = in.readLine()) != null ) {
                // If we get exit response from client, we end the loop and close socket :
                if ( response.equals("exit") ) {
                    break;
                }
                
                System.out.println("This server, I received : " + response);
            }

            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
