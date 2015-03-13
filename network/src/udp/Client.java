package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
    public static void main(String args[]) throws Exception {
        try (Scanner sc = new Scanner(System.in)) {

            try (DatagramSocket clientSocket = new DatagramSocket()) {
                InetAddress IPAddress = InetAddress.getByName("localhost");

                do {
                    byte[] receiveData = new byte[1024];

                    System.out.print("To send? ");
                    String sentence = sc.nextLine();

                    if ("STOP".equals(sentence)) break;

                    byte[] sendData = sentence.getBytes();
                    DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 2000);
                    clientSocket.send(sendPacket);

                    DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                    clientSocket.receive(receivePacket);
                    String modifiedSentence = new String(receivePacket.getData());
                    System.out.println("FROM SERVER:" + modifiedSentence);
                } while (true);
            }
        }
    }
}