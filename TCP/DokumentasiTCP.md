
# **TCP File Transfer Program**

## **Deskripsi**

Program ini mengimplementasikan transfer file menggunakan protokol TCP. Program terdiri dari dua bagian utama:

1. **FileServerTCP.java** - Server TCP yang menerima file dari klien dan menyimpannya di direktori `TestResults/`.
2. **FileClientTCP.java** - Klien TCP yang memungkinkan pengguna untuk memilih file dari sistem lokal dan mengirimkannya ke server.

### **Alur Kerja Program**

1. **FileServerTCP (Server):**
   - Server mendengarkan pada port `12345` dan menunggu koneksi dari klien.
   - Begitu klien terhubung, server menerima file yang dikirimkan oleh klien.
   - Server membuat direktori `TestResults/` (jika belum ada) dan menyimpan file yang diterima di dalam direktori tersebut dengan nama `TCP_Result_<nama_file>`.
   - Setiap klien yang terhubung di-handle oleh thread terpisah, memungkinkan server untuk menangani beberapa klien secara bersamaan.

2. **FileClientTCP (Klien):**
   - Klien meminta pengguna untuk memasukkan path file yang ingin dikirimkan ke server.
   - Klien membuka koneksi TCP ke server dan mengirimkan nama dan ukuran file, diikuti dengan data file itu sendiri.
   - Klien menunggu hingga file selesai terkirim, kemudian menutup koneksi.

### **Fitur Utama:**
- **Multithreading:** Server dapat menangani beberapa klien secara bersamaan menggunakan thread.
- **Folder Khusus:** File yang diterima disimpan dalam folder `TestResults/` di sisi server.
- **Transfer File:** Klien dapat memilih file dari sistem lokal dan mengirimkannya ke server.

---

## **Langkah-langkah Menjalankan Program**

### **1. Menjalankan Server**
- Buka terminal atau IDE (misalnya IntelliJ IDEA atau Eclipse).
- Jalankan file `FileServerTCP.java`.
- Server akan mulai berjalan dan mendengarkan pada port `12345`.
  
  ```bash
  java Tugas.TCP.FileServerTCP
  ```

  Output:
  ```
  Server berjalan di port 12345
  ```

### **2. Menjalankan Klien**
- Setelah server berjalan, jalankan file `FileClientTCP.java`.
- Klien akan meminta path file yang ingin dikirimkan.
- Klien kemudian mengirimkan file ke server.

  ```bash
  java Tugas.TCP.FileClientTCP
  ```

  Output:
  ```
  Masukkan path file yang ingin dikirim: /path/to/your/file.txt
  Terhubung ke server di localhost:12345
  File file.txt berhasil dikirim ke server.
  ```

### **3. Hasil di Server**
- Server akan menerima file dan menyimpannya di dalam folder `TestResults/` dengan nama file yang diawali dengan `TCP_Result_`.
- Server akan menampilkan output berikut:
  ```
  Menerima file: file.txt (12345 bytes)
  Direkori 'TestResults' dibuat.
  File file.txt berhasil diterima dan disimpan di TestResults/ (12345 bytes).
  ```

### **4. Uji Coba**
- **Uji Coba 1:**
  - Klien mengirimkan file `testfile1.txt` yang berukuran 12345 bytes.
  - Server menerima file tersebut dan menyimpannya di direktori `TestResults/` dengan nama `TCP_Result_testfile1.txt`.
  
  Output server:
  ```
  Menerima file: testfile1.txt (12345 bytes)
  File testfile1.txt berhasil diterima dan disimpan di TestResults/ (12345 bytes).
  ```

- **Uji Coba 2:**
  - Klien mengirimkan file `testfile2.txt` yang berukuran 6789 bytes.
  - Server menerima file tersebut dan menyimpannya di direktori `TestResults/` dengan nama `TCP_Result_testfile2.txt`.

  Output server:
  ```
  Menerima file: testfile2.txt (6789 bytes)
  File testfile2.txt berhasil diterima dan disimpan di TestResults/ (6789 bytes).
  ```

### **Kesimpulan Hasil Uji Coba:**
- Program berhasil mengirim dan menerima file dari klien ke server menggunakan koneksi TCP.
- File yang diterima disimpan dengan nama yang diawali dengan `TCP_Result_` di folder `TestResults/`.
- Server dapat menangani beberapa klien secara bersamaan menggunakan multithreading.

---

## **Struktur Proyek**

```
Tugas/
│
├── TCP/
│   ├── FileServerTCP.java      # Server untuk menerima dan menyimpan file
│   └── FileClientTCP.java      # Klien untuk mengirimkan file ke server
│
└── TestResults/               # Folder tempat file disimpan di server
```

---

## **Persyaratan Sistem**

- **Java Development Kit (JDK):** Versi 8 atau lebih baru.
- **Sistem Operasi:** Windows, Linux, atau macOS.

---

## **Catatan**

- Pastikan port `12345` tidak diblokir atau digunakan oleh aplikasi lain.
- Program ini diimplementasikan menggunakan Java untuk tujuan edukasi dalam memahami konsep socket dan multithreading di jaringan TCP.
