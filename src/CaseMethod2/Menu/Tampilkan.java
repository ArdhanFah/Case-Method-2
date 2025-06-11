package CaseMethod2.Menu;

import java.util.Scanner;
import CaseMethod2.Kendaraan.AntrianKendaraan;
import CaseMethod2.Kendaraan.NodeKendaraan;

public class Tampilkan {
    private Scanner scanner = new Scanner(System.in);
    private AntrianKendaraan antrianKendaraan;

    // Konstruktor untuk menginisialisasi objek Tampilkan dengan antrian kendaraan
    public Tampilkan(AntrianKendaraan antrianKendaraan) {
        this.antrianKendaraan = antrianKendaraan;
    }

    // Metode untuk memeriksa apakah antrian kendaraan kosong
    private boolean isEmpty() {
        return antrianKendaraan.getHead() == null;
    }

    // Metode untuk menampilkan kendaraan di antrian
    private void tampilkanFirst() {
        NodeKendaraan head = antrianKendaraan.getHead();
        if (!isEmpty()) {
            System.out.println("Antrian Depan:");
            head.data.tampilkanInfo();
        } else {
            System.out.println("Antrian kosong!");
        }
    }

    // Metode untuk menampilkan kendaraan terakhir di antrian
    private void tampilkanLast() {
        NodeKendaraan tail = antrianKendaraan.getTail();
        if (tail != null) {
            System.out.println("Antrian Belakang:");
            tail.data.tampilkanInfo();
        } else {
            System.out.println("Antrian kosong!");
        }
    }

    // Metode untuk menampilkan kendaraan berdasarkan index
    private void tampilkanByIndex() {
        NodeKendaraan head = antrianKendaraan.getHead();
        if (isEmpty()) {
            System.out.println("Antrian kosong!");
            return;
        }
        System.out.print("Masukkan index yang ingin ditampilkan: ");
        int index = scanner.nextInt();
        NodeKendaraan current = head;
        int count = 0;
        
        while (current != null) {
            if (count == index) {
                System.out.println("Kendaraan pada index " + index + ":");
                current.data.tampilkanInfo();
                return;
            }
            current = current.next;
            count++;
        }
        System.out.println("Index tidak ditemukan dalam antrian.");
    }

    // Metode untuk menampilkan menu tampilan antrian kendaraan
    public void tampilkanMenu() {
        System.out.println("\n=== Menu Tampilkan ===");
        System.out.println("1. Tampilkan Antrian Kendaraan");
        System.out.println("2. Tampilkan Antrian Depan");
        System.out.println("3. Tampilkan Antrian Belakang");
        System.out.println("4. Tampilkan Antrian By Index");
        System.out.print("Pilih menu: ");
        int pilihan = scanner.nextInt();
        switch (pilihan) {
            case 1:
                if (antrianKendaraan.isEmpty()) {
                    System.out.println("Antrian Kendaraan Kosong\n");
                    return;
                }else{
                    System.out.println("=== Antrian Kendaraan ===");
                    antrianKendaraan.tampilkanAntrian();
                }
                break;
            case 2:
                tampilkanFirst();
                break;
            case 3:
                tampilkanLast();
                break;
            case 4:
                tampilkanByIndex();
                break;       
            default:
                break;
        }
    }
}
