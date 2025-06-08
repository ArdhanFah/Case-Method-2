package CaseMethod2.TransaksiPengisian;

import CaseMethod2.BBM.BBM;
import CaseMethod2.Kendaraan.Kendaraan;

public class TransaksiPengisisan {
    Kendaraan kendaraan;
    BBM bbm;
    double liter, totalBayar;   

    public TransaksiPengisisan(Kendaraan kendaraan, BBM bbm, double liter) {
        this.kendaraan = kendaraan;
        this.bbm = bbm;
        this.liter = liter;
    }

    public double hitungTotalBayar() {
        totalBayar = liter * bbm.hargaPerLiter;
        return totalBayar;
    }

    public void tampilkanTransaksi() {
        System.out.printf("%10s : %10s%n", kendaraan.platNomor, totalBayar);

    }

}
