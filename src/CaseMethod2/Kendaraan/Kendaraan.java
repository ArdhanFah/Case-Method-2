package CaseMethod2.Kendaraan;

public class Kendaraan {
    public String tipe, merk, platNomor;

    public Kendaraan(String plat, String tipe, String merk) {
        this.tipe = tipe;
        this.platNomor = plat;
        this.merk = merk;
    }

    public void tampilkanInfo() {
        System.out.println("Plat Nomor: " + platNomor);
        System.out.println("Tipe: " + tipe);
        System.out.println("Merk: " + merk);
    }
}