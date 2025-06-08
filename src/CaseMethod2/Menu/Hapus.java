package CaseMethod2.Menu;

import CaseMethod2.Kendaraan.AntrianKendaraan;
import CaseMethod2.Kendaraan.NodeKendaraan;
import java.util.Scanner;

public class Hapus {
    private AntrianKendaraan antrianKendaraan;
    private Scanner scanner;

    public Hapus(AntrianKendaraan antrianKendaraan) {
        this.antrianKendaraan = antrianKendaraan;
        this.scanner = new Scanner(System.in);
    }

    public void menuHapus() {
        int pilihan;

            System.out.println("\n=== Menu Hapus Kendaraan ===");
            System.out.println("1. Hapus dari Awal");
            System.out.println("2. Hapus dari Akhir");
            System.out.println("3. Hapus berdasarkan Index");
            System.out.println("4. Hapus berdasarkan Plat Nomor");
            System.out.println("0. Kembali ke Menu Utama");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (pilihan) {
                case 1:
                    hapusAwal();
                    break;
                case 2:
                    hapusAkhir();
                    break;
                case 3:
                    hapusByIndex();
                    break;
                case 4:
                    hapusByPlat();
                    break;
                case 0:
                    System.out.println("Kembali ke menu utama...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }

    }

    private void hapusAwal() {
        if (antrianKendaraan.isEmpty()) {
            System.out.println("Antrian kosong!");
            return;
        }
        antrianKendaraan.dequeue();
        System.out.println("Kendaraan di awal antrian berhasil dihapus!");
    }

    private void hapusAkhir() {
        if (antrianKendaraan.isEmpty()) {
            System.out.println("Antrian kosong!");
            return;
        }
        
        NodeKendaraan tail = antrianKendaraan.getTail();
        if (tail == antrianKendaraan.getHead()) {
            antrianKendaraan.setHead(null);
            antrianKendaraan.setTail(null);
        } else {
            tail.prev.next = null;
            antrianKendaraan.setTail(tail.prev);
        }
        System.out.println("Kendaraan di akhir antrian berhasil dihapus!");
    }

    private void hapusByIndex() {
        if (antrianKendaraan.isEmpty()) {
            System.out.println("Antrian kosong!");
            return;
        }

        System.out.print("Masukkan index yang akan dihapus (0-" + (antrianKendaraan.jumlahAntrian() - 1) + "): ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Clear buffer

        if (index < 0 || index >= antrianKendaraan.jumlahAntrian()) {
            System.out.println("Index tidak valid!");
            return;
        }

        if (index == 0) {
            hapusAwal();
            return;
        }

        if (index == antrianKendaraan.jumlahAntrian() - 1) {
            hapusAkhir();
            return;
        }

        NodeKendaraan current = antrianKendaraan.getHead();
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        current.prev.next = current.next;
        current.next.prev = current.prev;
        System.out.println("Kendaraan pada index " + index + " berhasil dihapus!");
    }

    private void hapusByPlat() {
        if (antrianKendaraan.isEmpty()) {
            System.out.println("Antrian kosong!");
            return;
        }

        System.out.print("Masukkan plat nomor yang akan dihapus: ");
        String platNomor = scanner.nextLine();

        NodeKendaraan current = antrianKendaraan.getHead();

        if (current != null && current.data.platNomor.equalsIgnoreCase(platNomor)) {
            hapusAwal();
            return;
        }

        while (current != null && !current.data.platNomor.equalsIgnoreCase(platNomor)) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Plat nomor tidak ditemukan!");
            return;
        }

        if (current.next == null) {
            hapusAkhir();
            return;
        }

        current.prev.next = current.next;
        current.next.prev = current.prev;
        System.out.println("Kendaraan dengan plat nomor " + platNomor + " berhasil dihapus!");
    }
}
