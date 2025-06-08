package CaseMethod2;
import CaseMethod2.BBM.BBM;
import CaseMethod2.Kendaraan.AntrianKendaraan;
import CaseMethod2.Kendaraan.Kendaraan;
import CaseMethod2.Menu.Tambahkan;
import CaseMethod2.Menu.Tampilkan;
import CaseMethod2.Menu.Hapus;
import CaseMethod2.TransaksiPengisian.*;
import java.util.Scanner;

public class MainSPBU {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AntrianKendaraan antrianKendaraan = new AntrianKendaraan();
        AntrianTransaksi antrianTransaksi = new AntrianTransaksi(10);
        Tambahkan tambahkan = new Tambahkan(antrianKendaraan);
        Tampilkan tampilkan = new Tampilkan(antrianKendaraan);
        Hapus hapus = new Hapus(antrianKendaraan);
        int pilihan;

        do {
            System.out.println("=== Menu SPBU ===");
            System.out.println("1. Tambah Antrian Kendaraan");
            System.out.println("2. Tampilkan Antrian");
            System.out.println("3. Cek jumlah Antrian Kendaraan");
            System.out.println("4. Proses Pengisian BBM");
            System.out.println("5. Tampilkan Riwayat Transaksi");
            System.out.println("6. Hapus Kendaraan");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt(); scanner.nextLine(); // Clear the newline character
            switch (pilihan) {
                case 1:
                    tambahkan.tambahKendaraan();
                    break;
                case 2:
                    tampilkan.tampilkanMenu();
                    break;
                case 3:
                    System.out.println("Jumlah Antrian Kendaraan: " + antrianKendaraan.jumlahAntrian());
                    break;
                case 4:
                    if(antrianKendaraan.isEmpty()) {
                        System.out.println("Antrian Kendaraan Kosong");
                        break;
                    } else {
                        Kendaraan dilayani = antrianKendaraan.dequeue();
                        System.out.println("Kendaraan yang Dilayani:" + dilayani.platNomor);
                        System.out.print("Masukkan Jenis BBM: ");
                        String jenisBBM = scanner.nextLine();
                        System.out.print("Masukkan Harga per Liter: ");
                        double hargaPerLiter = scanner.nextDouble(); scanner.nextLine(); // Clear the newline character
                        System.out.print("Masukkan Jumlah Liter: ");
                        double liter = scanner.nextDouble(); scanner.nextLine(); // Clear the newline character
                        BBM bbm = new BBM(jenisBBM, hargaPerLiter);
                        TransaksiPengisisan transaksi = new TransaksiPengisisan(dilayani, bbm, liter);
                        transaksi.hitungTotalBayar();
                        antrianTransaksi.enqueue(transaksi);
                        System.out.println(">> Transaksi berhasil dicatat.");
                    }
                    break;
                case 5:
                    if(antrianTransaksi.isEmpty()) {
                        System.out.println("Tidak ada transaksi yang tercatat.");
                    } else {
                        System.out.println("=== Riwayat Transaksi Pengisian BBM ===");
                        System.out.println("Daftar Transaksi:");
                        antrianTransaksi.tampil();
                    }
                    break;
                case 6:
                    hapus.menuHapus();
                    break;
                case 0:
                    System.out.println("Keluar dari program.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
                    break;
            }
        }while (pilihan != 0); 
        scanner.close();
    }
    
}
