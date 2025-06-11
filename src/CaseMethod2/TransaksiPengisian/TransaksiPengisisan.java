package CaseMethod2.TransaksiPengisian;

import CaseMethod2.BBM.BBM;
import CaseMethod2.Kendaraan.Kendaraan;

public class TransaksiPengisisan {
    Kendaraan kendaraan;
    BBM bbm;
    double liter, totalBayar;   

    // Konstruktor untuk menginisialisasi transaksi pengisian
    public TransaksiPengisisan(Kendaraan kendaraan, BBM bbm, double liter) {
        this.kendaraan = kendaraan;
        this.bbm = bbm;
        this.liter = liter;
    }

    // Method untuk menghitung total bayar berdasarkan liter dan harga per liter BBM
    public double hitungTotalBayar() {
        totalBayar = liter * bbm.hargaPerLiter;
        return totalBayar;
    }

    // Method untuk menampilkan informasi transaksi
    public void tampilkanTransaksi() {
        System.out.printf("%10s : %10s%n", kendaraan.platNomor, totalBayar);

    }

}
