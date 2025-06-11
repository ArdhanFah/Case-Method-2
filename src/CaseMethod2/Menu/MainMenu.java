package CaseMethod2.Menu;

import CaseMethod2.BBM.BBM;
import CaseMethod2.Kendaraan.AntrianKendaraan;
import CaseMethod2.Kendaraan.Kendaraan;
import CaseMethod2.TransaksiPengisian.*;
import java.util.Scanner;

public class MainMenu {
    private Scanner scanner;
    private AntrianKendaraan antrianKendaraan;
    private AntrianTransaksi antrianTransaksi;
    private Tambahkan tambahkan;
    private Tampilkan tampilkan;
    private Hapus hapus;

    // Konstruktor untuk menginisialisasi objek MainMenu dengan antrian kendaraan dan transaksi
    public MainMenu() {
        this.scanner = new Scanner(System.in);
        this.antrianKendaraan = new AntrianKendaraan();
        this.antrianTransaksi = new AntrianTransaksi(10);
        this.tambahkan = new Tambahkan(antrianKendaraan);
        this.tampilkan = new Tampilkan(antrianKendaraan);
        this.hapus = new Hapus(antrianKendaraan);
    }

    // Method untuk menampilkan menu SPBU
    public void tampilkanMenu() {
        System.out.println("=== Menu SPBU ===");
        System.out.println("1. Tambah Antrian Kendaraan");
        System.out.println("2. Tampilkan Antrian");
        System.out.println("3. Cek jumlah Antrian Kendaraan");
        System.out.println("4. Proses Pengisian BBM");
        System.out.println("5. Tampilkan Riwayat Transaksi");
        System.out.println("6. Hapus Kendaraan");
        System.out.println("0. Keluar");
        System.out.print("Pilih menu: ");
    }

    // Method untuk memproses pilihan menu yang dimasukkan oleh pengguna
    public void prosesMenu(int pilihan) {
        switch (pilihan) {
            case 1:
                tambahkan.tambahKendaraan();
                break;
            case 2:
                if(antrianKendaraan.isEmpty()) {
                    System.out.println("Antrian Kendaraan Kosong");
                } else { 
                    tampilkan.tampilkanMenu(); 
                }
                break;
            case 3:
                System.out.println("Jumlah Antrian Kendaraan: " + antrianKendaraan.jumlahAntrian());
                break;
            case 4:
                prosesPengisianBBM();
                break;
            case 5:
                tampilkanRiwayatTransaksi();
                break;
            case 6:
                if(antrianKendaraan.isEmpty()) {
                    System.out.println("Antrian Kendaraan Kosong");
                } else { 
                    hapus.menuHapus(); 
                }
                break;
            case 0:
                System.out.println("Keluar dari program.");
                System.exit(0);
                break;
            default:
                System.out.println("Pilihan tidak valid!");
                break;
        }
    }

    // Method untuk memproses pengisian BBM pada kendaraan yang ada di antrian
    private void prosesPengisianBBM() {
        if(antrianKendaraan.isEmpty()) {
            System.out.println("Antrian Kendaraan Kosong");
            return;
        }

        Kendaraan dilayani = antrianKendaraan.dequeue();
        System.out.println("Kendaraan yang Dilayani: " + dilayani.platNomor);

        System.out.println("Pilih Jenis BBM:");
        System.out.println("1. Pertalite (Rp 10.000/liter)");
        System.out.println("2. Pertamax  (Rp 13.500/liter)");
        System.out.println("3. Turbo     (Rp 15.000/liter)");
        System.out.println("4. Solar     (Rp 8.500/liter)");
        System.out.print("Pilih BBM [1-4]: ");
        int pilihBBM = scanner.nextInt(); scanner.nextLine();

        String jenisBBM = "";
        double hargaPerLiter = 0;
        switch (pilihBBM) {
            case 1:
                jenisBBM = "Pertalite";
                hargaPerLiter = 10000;
                break;
            case 2:
                jenisBBM = "Pertamax";
                hargaPerLiter = 13500;
                break;
            case 3:
                jenisBBM = "Turbo";
                hargaPerLiter = 15000;
                break;
            case 4:
                jenisBBM = "Solar";
                hargaPerLiter = 8500;
                break;
            default:
                System.out.println("Pilihan BBM tidak valid!");
                antrianKendaraan.enqueue(dilayani);
                return;
        }

        System.out.print("Masukkan Jumlah Liter: ");
        double liter = scanner.nextDouble(); scanner.nextLine();

        BBM bbm = new BBM(jenisBBM, hargaPerLiter);
        TransaksiPengisisan transaksi = new TransaksiPengisisan(dilayani, bbm, liter);
        transaksi.hitungTotalBayar();
        antrianTransaksi.enqueue(transaksi);
        System.out.println(">> Transaksi berhasil dicatat.");
    }

    // Method untuk menampilkan riwayat transaksi pengisian BBM
    private void tampilkanRiwayatTransaksi() {
        if(antrianTransaksi.isEmpty()) {
            System.out.println("Tidak ada transaksi yang tercatat.");
        } else {
            System.out.println("=== Riwayat Transaksi Pengisian BBM ===");
            System.out.println("Daftar Transaksi:");
            antrianTransaksi.tampil();
            antrianTransaksi.tampilkanTotalPendapatan();
        }
    }

    // Method untuk menutup scanner
    public void closeScanner() {
        scanner.close();
    }
} 