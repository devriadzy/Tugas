package Tugas.TCP;

import java.io.*;
import java.net.*;

public class FileServerTCP {
    // Port untuk server
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try {
            try (// Membuat server socket untuk mendengarkan koneksi klien
                    ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
                System.out.println("Server berjalan di port " + SERVER_PORT);

                // Server akan terus menunggu koneksi dari klien
                while (true) {
                    // Menerima koneksi dari klien
                    Socket clientSocket = serverSocket.accept();
                    System.out.println("Klien terhubung dari " + clientSocket.getInetAddress());

                    // Menjalankan thread untuk menangani klien
                    new Thread(new ClientHandler(clientSocket)).start();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// Kelas untuk menangani tiap klien secara terpisah dengan thread
class ClientHandler implements Runnable {
    private Socket clientSocket;

    private static final String DIRECTORY_PATH = "TestResults/";

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try {
            // Membaca data dari klien (file yang dikirim)
            InputStream inputStream = clientSocket.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(inputStream);

            // Mendapatkan nama file dan ukurannya
            String fileName = ois.readUTF();
            long fileSize = ois.readLong();
            System.out.println("Menerima file: " + fileName + " (" + fileSize + " bytes)");

            // Membuat folder 'TestResults' jika belum ada
            File directory = new File(DIRECTORY_PATH);
            if (!directory.exists()) {
                directory.mkdir();
                System.out.println("Direktori 'TestResults' dibuat.");
            }

            // Membuat output stream untuk menyimpan file yang diterima di 'TestResults'
            FileOutputStream fos = new FileOutputStream(DIRECTORY_PATH + "TCP_Result_" + fileName);
            byte[] buffer = new byte[4096];
            int bytesRead;
            long totalBytesRead = 0;

            // Membaca dan menulis data file
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
                totalBytesRead += bytesRead;
            }

            // Menutup stream dan socket
            fos.close();
            clientSocket.close();

            // Menginformasikan bahwa file berhasil diterima
            System.out.println("File " + fileName + " berhasil diterima dan disimpan di " + DIRECTORY_PATH + " ("
                    + totalBytesRead + " bytes).");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
