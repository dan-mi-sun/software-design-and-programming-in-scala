package tcp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String argv[]) throws Exception {

        try (Socket clientSocket = new Socket("localhost", 2000);
             DataOutputStream toServer = new DataOutputStream(clientSocket.getOutputStream());
             BufferedReader fromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            try (Scanner sc = new Scanner(System.in)) {

                do {
                    System.out.print("String to send? ");
                    String sentence = sc.nextLine();
                    if ("STOP".equals(sentence)) break;

                    toServer.writeBytes(sentence + '\n');
                    System.out.println("FROM SERVER: " + fromServer.readLine());
                } while (true);
            }
        }
    }
}