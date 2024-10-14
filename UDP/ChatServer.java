package Tugas.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ChatServer {
    private static final int PORT = 9876;

    public static void main(String[] args) {
        try {
            try (// Membuat socket UDP untuk server
            DatagramSocket serverSocket = new DatagramSocket(PORT)) {
                System.out.println("Server is listening on port " + PORT);

                while (true) {
                    // Buffer untuk menerima pesan
                    byte[] receiveData = new byte[1024];

                    // Menerima paket data dari klien
                    DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                    serverSocket.receive(receivePacket);

                    // Menampilkan pesan yang diterima dari klien
                    String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
                    System.out.println("Received message: " + message);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}