// Class Queue: antrian pelanggan (FIFO, yang pertama datang dilayani duluan)
public class Queue {
    Node front = null; // pelanggan paling depan
    Node rear = null;  // pelanggan paling belakang
    int jumlah = 0;
    final int MAKS = 5; // maksimal 5 pelanggan

    // Tambah pelanggan di belakang antrian (enqueue)
    public void enqueue(String kode, String nama, int total) {
        Node baru = new Node(kode, nama, total);
        if (front == null) {
            front = baru; // antrian kosong
            rear = baru;
        } else {
            rear.next = baru; // sambungkan di belakang
            rear = baru;
        }
        jumlah++;
        System.out.println("Data pelanggan ditambahkan ke antrian!");
    }

    // Ambil pelanggan paling depan (dequeue)
    public Node dequeue() {
        if (front == null) {
            return null; // antrian kosong
        }
        Node keluar = front;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        jumlah--;
        return keluar;
    }

    // Tampilkan antrian dari depan ke belakang
    public void tampil() {
        if (front == null) {
            System.out.println("Antrian kosong.");
            return;
        }
        System.out.println("Antrian Saat Ini:");
        Node temp = front;
        while (temp != null) {
            System.out.println(temp.kode + " | " + temp.nama + " | Rp" + temp.total);
            temp = temp.next;
        }
        System.out.println("Jumlah antrian: " + jumlah + "/" + MAKS);
    }
}
