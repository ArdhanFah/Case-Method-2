package CaseMethod2.TransaksiPengisian;

public class AntrianTransaksi {
    private TransaksiPengisisan[] data;
    private int front, rear, size, kapasitas;

    // Konstruktor untuk menginisialisasi antrian transaksi
    public AntrianTransaksi(int kapasitas) {
        this.kapasitas = kapasitas;
        this.data = new TransaksiPengisisan[kapasitas];
        this.front = 0;
        this.rear = 0;
        this.size = 0;
    }

    // Getter untuk mendapatkan ukuran antrian
    public boolean isEmpty() {
        return size == 0;
    }

    // Method untuk mengecek apakah antrian penuh
    public boolean isFull(){
        return size == kapasitas;
    }

    // Method untuk mendapatkan ukuran antrian
    public void enqueue(TransaksiPengisisan tr){
        if(isFull()){
            System.out.println("Antrian Penuh");
            return;
        }

        data[rear] = tr;
        rear = (rear + 1) % kapasitas;
        size++;
    }

    // Method untuk mengeluarkan transaksi dari antrian
    public void tampil(){
        int index = front;
        for(int i = 0; i< size; i++){
            data[index].tampilkanTransaksi();
            index = (index + 1) % kapasitas;
        }
    }

    // Method untuk mengeluarkan transaksi dari antrian
    public double totalPendapatan(){
        double total = 0;
        int index = front;
        for(int i = 0; i < size; i++){
            total += data[index].hitungTotalBayar();
            index = (index + 1) % kapasitas;
        }
        return total;
    }

    // Method untuk menampilkan total pendapatan dari semua transaksi
    public void tampilkanTotalPendapatan() {
        System.out.println("Total Pendapatan: " + totalPendapatan());
    }
}

