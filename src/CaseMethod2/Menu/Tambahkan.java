package CaseMethod2.Menu;

import java.util.Scanner;
import CaseMethod2.Kendaraan.AntrianKendaraan;
import CaseMethod2.Kendaraan.Kendaraan;

public class Tambahkan {
    private Scanner scanner = new Scanner(System.in);
    AntrianKendaraan antrianKendaraan;

    public Tambahkan(AntrianKendaraan antrianKendaraan) {
        this.antrianKendaraan = antrianKendaraan;
    }

    private Kendaraan inputKendaraan() {
        System.out.print("Masukkan Plat Nomor:  ");
        String plat = scanner.nextLine();
        System.out.print("Masukkan Jenis Kendaraan: ");
        String jenis = scanner.nextLine();
        System.out.print("Masukkan Merk Kendaraan: ");
        String merk = scanner.nextLine();
        return new Kendaraan(plat, jenis, merk);
    }

    public void tambahKendaraan() {
        System.out.println("=== Tambah Kendaraan ===");
        System.out.println("1. Tambah Kendaraan");
        System.out.println("2. Tambah Kendaraan Awal");
        System.out.println("3. Tambah by Index");
        System.out.print("Pilih opsi: ");
        int opsi = scanner.nextInt(); scanner.nextLine();

        Kendaraan kendaraan;
        switch (opsi) {
            case 1:
                kendaraan = inputKendaraan();
                antrianKendaraan.enqueue(kendaraan);
                System.out.println("Kendaraan berhasil ditambahkan ke antrian.");
                break;
            case 2:
                kendaraan = inputKendaraan();
                antrianKendaraan.addFirst(kendaraan);
                System.out.println("Kendaraan berhasil ditambahkan di awal antrian.");
                break;
            case 3:
                kendaraan = inputKendaraan();
                System.out.print("Masukkan index untuk menambahkan kendaraan: ");
                int index = scanner.nextInt(); scanner.nextLine();
                antrianKendaraan.addByIndex(kendaraan, index);
                System.out.println("Kendaraan berhasil ditambahkan di index tertentu.");
                break;
            default:
                System.out.println("Opsi tidak valid.");
        }
    }
}
