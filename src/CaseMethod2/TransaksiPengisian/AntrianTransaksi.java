package CaseMethod2.TransaksiPengisian;

public class AntrianTransaksi {
    private TransaksiPengisisan[] data;
    private int front, rear, size, kapasitas;

    public AntrianTransaksi(int kapasitas) {
        this.kapasitas = kapasitas;
        this.data = new TransaksiPengisisan[kapasitas];
        this.front = 0;
        this.rear = 0;
        this.size = 0;
    }

    public void enqueue(TransaksiPengisisan tr){
        if(size == kapasitas){
            System.out.println("Antrian Penuh");
            return;
        }

        data[rear] = tr;
        rear = (rear + 1) % kapasitas;
        size++;
    }

    public void tampil(){
        int index = front;
        for(int i = 0; i< size; i++){
            data[index].tampilkanTransaksi();
            index = (index + 1) % kapasitas;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull(){
        return size == kapasitas;
    }

}

