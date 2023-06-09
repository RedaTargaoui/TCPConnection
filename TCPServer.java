/**
 * Represents the server TCP connexion part
 * Reda TARGAOUI & Zakaria JANNANI & Salmane CHAHIDI
 * 16/05/2023
 */
package TCP;

import Controller.PointageController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    // Attributes :
    private ServerSocket serverSocket;// server socket

    // Constructor :

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

            // Creation of Pointage Controller to store CheckIn&CheckOut data :
            PointageController pointageController = new PointageController();

            String response;
            while ( (response = in.readLine()) != null ) {
                // If we get exit response from client, we end the loop and close socket :
                if ( response.equals("exit") ) {
                    break;
                }
                
                // Add the employeeID Check :
                pointageController.addPointage(Integer.parseInt(response));
                // Store data :
                pointageController.pushPointageData();
            }

            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}