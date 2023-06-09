/**
 * Represents the client side in TCP connection
 * by Reda TARGAOUI
 * 16/05/2023
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class TCPClient {
    // Attributes :
    private Socket socket;
    private PrintWriter out;

    /**
     * Initialise the socket
     * @param serverIP server ip address
     * @param serverPort server port
     */
    public TCPClient(String serverIP, int serverPort) {
        try {
            this.socket = new Socket(serverIP, serverPort);// Create the socket
            // To send data to the server :
            out = new PrintWriter(this.socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Send data to the server
     * @param message the message to send
     */
    public void sendData(String message) {
        out.println(message);// Send message
    }

    /**
     * To close the socket
     */
    public void closeSocket() {
        try {
            out.println("exit");
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
