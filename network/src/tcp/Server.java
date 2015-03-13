package tcp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String argv[]) throws Exception {
        try (ServerSocket port = new ServerSocket(2000)) {

            try (Socket connectionSocket = port.accept();
                 BufferedReader fromClient =
                         new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
                 DataOutputStream toClient = new DataOutputStream(connectionSocket.getOutputStream())
            ) {
                while (true) {

                    String clientSentence = fromClient.readLine();
                    System.out.println("Received: " + clientSentence);
                    toClient.writeBytes(clientSentence.toUpperCase() + '\n');
                }
            }
        }
    }
}