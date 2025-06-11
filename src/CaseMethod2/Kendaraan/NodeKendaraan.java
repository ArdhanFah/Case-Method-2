package CaseMethod2.Kendaraan;

public class NodeKendaraan {
    public Kendaraan data;
    public NodeKendaraan next;
    public NodeKendaraan prev;

    // Konstruktor untuk menginisialisasi objek NodeKendaraan dengan data kendaraan
    public NodeKendaraan(Kendaraan data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
    
}
