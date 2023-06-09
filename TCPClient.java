/**
 * Represents the client TCP connexion part
 * Reda TARGAOUI & Zakaria JANNANI & Salmane CHAHIDI
 * 16/05/2023
 */
package TCP;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class TCPClient {
    // Attributes :
    private Socket socket;// To connect with server using TCP
    private PrintWriter out;

    // Constructor :

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
     * @param EmployeeID the employee's ID
     */
    public void sendData(int EmployeeID) {
        out.println(EmployeeID);// Send Employee's ID
    }

    /**
     * To close th socket
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
