
# **UDP Chat Program**

## **Deskripsi**

Program ini mengimplementasikan komunikasi chat menggunakan **protokol UDP**. Program terdiri dari dua bagian utama:

1. **ChatServer.java** - Server UDP yang mendengarkan pesan dari klien dan menampilkannya.
2. **ChatClient.java** - Klien UDP yang memungkinkan pengguna untuk mengirim pesan ke server.

### **Alur Kerja Program**

1. **ChatServer (Server):**
   - Server berjalan pada port `9876` dan mendengarkan pesan dari klien menggunakan UDP.
   - Ketika server menerima pesan dari klien, server menampilkannya di console.
   - Server dapat menangani beberapa klien secara bersamaan dengan mendengarkan paket data secara terus-menerus.

2. **ChatClient (Klien):**
   - Klien meminta pengguna untuk memasukkan nama pengguna.
   - Klien mengirimkan pesan ke server menggunakan UDP.
   - Klien mengirimkan pesan berulang kali hingga pengguna mengetik "exit" untuk berhenti.

---

## **Langkah-langkah Menjalankan Program**

### **1. Menjalankan Server**
- Buka terminal atau IDE (seperti IntelliJ IDEA atau Eclipse).
- Jalankan file `ChatServer.java` untuk memulai server.
- Server akan mulai berjalan dan mendengarkan pada port `9876`.
  
  ```bash
  java Tugas.UDP.ChatServer
  ```

  Output:
  ```
  Server is listening on port 9876
  ```

### **2. Menjalankan Klien**
- Setelah server berjalan, jalankan file `ChatClient.java`.
- Klien akan meminta pengguna untuk memasukkan nama dan kemudian mengirimkan pesan ke server.

  ```bash
  java Tugas.UDP.ChatClient
  ```

  Output:
  ```
  Enter your name: Alice
  Enter your message (or type 'exit' to quit): Hello, server!
  ```

### **3. Hasil di Server**
- Server akan menampilkan pesan yang diterima dari klien:
  ```
  Received message: Alice: Hello, server!
  ```

### **4. Uji Coba**
- **Uji Coba 1:**
  - Klien memasukkan nama "Alice" dan mengirimkan pesan "Hello, server!".
  - Server menerima pesan tersebut dan menampilkannya.
  
  Output klien:
  ```
  Enter your name: Alice
  Enter your message (or type 'exit' to quit): Hello, server!
  ```

  Output server:
  ```
  Received message: Alice: Hello, server!
  ```

- **Uji Coba 2:**
  - Klien memasukkan nama "Bob" dan mengirimkan pesan "Hi there!".
  - Server menerima pesan tersebut dan menampilkannya.
  
  Output klien:
  ```
  Enter your name: Bob
  Enter your message (or type 'exit' to quit): Hi there!
  ```

  Output server:
  ```
  Received message: Bob: Hi there!
  ```

### **5. Menutup Program**
- Ketika pengguna mengetik `"exit"` pada klien, klien berhenti dan socket UDP ditutup.

  Output klien:
  ```
  Enter your message (or type 'exit' to quit): exit
  ```

  Server akan tetap berjalan dan siap menerima pesan baru dari klien lain.

---

## **Struktur Proyek**

```
Tugas/
│
├── UDP/
│   ├── ChatServer.java      # Server untuk menerima dan menampilkan pesan
│   └── ChatClient.java      # Klien untuk mengirimkan pesan ke server
```

---

## **Persyaratan Sistem**

- **Java Development Kit (JDK):** Versi 8 atau lebih baru.
- **Sistem Operasi:** Windows, Linux, atau macOS.

---

## **Catatan**

- Program ini menggunakan **UDP** untuk komunikasi jaringan yang memungkinkan pengiriman pesan tanpa membuat koneksi terlebih dahulu.
- UDP tidak menjamin pengiriman pesan yang berurutan atau pesan yang sampai ke tujuan, sehingga beberapa paket mungkin hilang.
- Program ini diimplementasikan menggunakan Java untuk tujuan edukasi dalam memahami komunikasi jaringan berbasis UDP.
