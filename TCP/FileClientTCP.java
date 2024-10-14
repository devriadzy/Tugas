package Tugas.TCP;

import java.io.*;
import java.net.*;

public class FileClientTCP {
    // Alamat IP server dan port server
    private static final String SERVER_IP = "localhost";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try {
            // Meminta pengguna untuk memasukkan path file yang ingin dikirim
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Masukkan path file yang ingin dikirim: ");
            String filePath = reader.readLine();

            File file = new File(filePath);
            if (!file.exists()) {
                System.out.println("File tidak ditemukan. Silakan coba lagi.");
                return;
            }

            // Membuat koneksi ke server
            Socket socket = new Socket(SERVER_IP, SERVER_PORT);
            System.out.println("Terhubung ke server di " + SERVER_IP + ":" + SERVER_PORT);

            // Mengirim file ke server
            sendFile(file, socket);

            // Menutup socket setelah selesai
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method untuk mengirim file ke server
    private static void sendFile(File file, Socket socket) {
        try {
            // Inisialisasi output stream untuk mengirim data ke server
            OutputStream outputStream = socket.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(outputStream);

            // Mengirim informasi file (nama dan ukuran)
            oos.writeUTF(file.getName());
            oos.writeLong(file.length());
            oos.flush();

            // Membaca file dan mengirim isinya ke server
            FileInputStream fis = new FileInputStream(file);
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            // Menutup stream setelah file selesai dikirim
            fis.close();
            outputStream.flush();

            System.out.println("File " + file.getName() + " berhasil dikirim ke server.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
