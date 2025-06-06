# 🚗 Sistem Antrian dan Transaksi SPBU - Case Method 2

Repositori ini berisi implementasi sistem **antrian kendaraan** dan **transaksi pengisian BBM** di SPBU berbasis Java, menggunakan konsep **Object-Oriented Programming** (OOP), **Double Linked List**, dan **Queue berbasis Array**.

## 👥 Anggota Kelompok 2

- **Ardhan Dikri Achmad Fahrudin (244107020012)**
- **Jonathan Dwi Pangestu (244107020197)**
- **Radit Firansah (244107020196)**


## 📁 Struktur Direktori Proyek
``` bash 
src/
├───CaseMethod2/ # Package utama berisi semua source code
│ ├───BBM/ # Data dan definisi jenis BBM
│ │ └───BBM.java
│ ├───Kendaraan/ # Struktur antrian kendaraan (DLL)
│ │ ├───Kendaraan.java
│ │ ├───NodeKendaraan.java
│ │ └───AntrianKendaraan.java
│ ├───TransaksiPengisian/ # Struktur dan data transaksi SPBU
│ │ ├───TransaksiPengisisan.java
│ │ └───AntrianTransaksi.java
│ └───MainMainSPBU.java # Main class dengan menu interaktif 
├───javarun
```

### `CaseMethod2.BBM`
Berisi class untuk data BBM:
- `BBM.java`: Menyimpan nama dan harga per liter BBM.

### `CaseMethod2.Kendaraan`
Mengelola antrian kendaraan dengan Double Linked List:
- `Kendaraan.java`: Data kendaraan (plat, jenis).
- `NodeKendaraan.java`: Node DLL.
- `AntrianKendaraan.java`: Operasi enqueue, dequeue, dan tampil kendaraan.

### `CaseMethod2.TransaksiPengisian`
Mencatat transaksi pengisian BBM:
- `TransaksiPengisisan.java`: Menyimpan detail pengisian per kendaraan.
- `AntrianTransaksi.java`: Menyimpan riwayat transaksi dengan circular queue.

Main class berbasis CLI yang:
- Menampilkan menu.
- Mengelola interaksi pengguna dengan sistem SPBU.

## 🛠️ Jalankan Program via Skrip Otomatis

Untuk mempermudah kompilasi dan eksekusi, jalankan perintah berikut:

```bash
./javarun
```
---