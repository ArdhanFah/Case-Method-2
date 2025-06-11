package CaseMethod2.Kendaraan;

public class Kendaraan {
    public String tipe, merk, platNomor;

    // Konstruktor untuk menginisialisasi objek Kendaraan dengan plat, tipe, dan merk
    public Kendaraan(String plat, String tipe, String merk) {
        this.tipe = tipe;
        this.platNomor = plat;
        this.merk = merk;
    }

    // Metode untuk menampilkan informasi kendaraan
    public void tampilkanInfo() {
        System.out.println("Plat Nomor: " + platNomor);
        System.out.println("Tipe: " + tipe);
        System.out.println("Merk: " + merk);
    }
}