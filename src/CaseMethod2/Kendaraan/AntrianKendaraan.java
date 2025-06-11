package CaseMethod2.Kendaraan;

public class AntrianKendaraan {
    private NodeKendaraan head;
    private NodeKendaraan tail;

    // Konstruktor untuk menginisialisasi antrian kendaraan
    public NodeKendaraan getHead() {
        return head;
    }

    // Setter untuk mengatur head antrian
    public void setHead(NodeKendaraan head) {
        this.head = head;
    }

    // Getter dan setter untuk tail antrian
    public NodeKendaraan getTail() {
        return tail;
    }

    // Setter untuk mengatur tail antrian
    public void setTail(NodeKendaraan tail) {
        this.tail = tail;
    }

    // Konstruktor untuk menginisialisasi antrian kendaraan
    public boolean isEmpty() {
        return head == null;
    }

    // Method untuk mengecek apakah antrian kosong
    public void enqueue(Kendaraan kendaraan) {
        NodeKendaraan newNode = new NodeKendaraan(kendaraan);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Method untuk menambahkan kendaraan ke antrian
    public void addFirst(Kendaraan kendaraan) {
        NodeKendaraan newNode = new NodeKendaraan(kendaraan);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void addByIndex(Kendaraan kendaraan, int index) {
        if (index < 0 || index > jumlahAntrian()) {
            System.out.println("Index di luar jangkauan");
            return;
        }
        if (index == 0) {
            addFirst(kendaraan);
            return;
        }
        if (index == jumlahAntrian()) {
            enqueue(kendaraan);
            return;
        }
        
        NodeKendaraan newNode = new NodeKendaraan(kendaraan);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            NodeKendaraan current = head;
            while (current != null && current.data.platNomor.compareTo(kendaraan.platNomor) < 0) {
                current = current.next;
            }
            if (current == head) {
                addFirst(kendaraan);
            } else if (current == null) {
                enqueue(kendaraan);
            } else {
                newNode.prev = current.prev;
                newNode.next = current;
                if (current.prev != null) {
                    current.prev.next = newNode;
                }
                current.prev = newNode;
                if (newNode.prev == null) {
                    head = newNode; // Update head if inserting at the front
                }
            }
        }
    }

    public Kendaraan dequeue(){
        if(head == null) {
            System.out.println("Antrian Kosong");
            return null;
        }
        Kendaraan exit = head.data;
        head = head.next;
        
        if(head != null){
            head.prev = null;
        }else {
            tail = null;
        }
        return exit;
    }

    public void tampilkanAntrian(){
        NodeKendaraan current = head;
        while(current != null){
            current.data.tampilkanInfo();
            current = current.next;
        }
    }

    public int jumlahAntrian() {
        int count = 0;
        NodeKendaraan current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

}
