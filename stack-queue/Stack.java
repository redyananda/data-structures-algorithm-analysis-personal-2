// Class Stack: riwayat transaksi (LIFO, transaksi terbaru di atas)
public class Stack {
    Node top = null; // transaksi terbaru

    // Simpan transaksi di atas stack (push)
    public void push(String kode, String nama, int total) {
        Node baru = new Node(kode, nama, total);
        baru.next = top; // node baru menunjuk top lama
        top = baru;      // node baru jadi top
    }

    // Tampilkan riwayat dari terbaru ke lama
    public void tampil() {
        if (top == null) {
            System.out.println("Belum ada riwayat transaksi.");
            return;
        }
        System.out.println("Riwayat Transaksi (terbaru ke lama):");
        Node temp = top;
        while (temp != null) {
            System.out.println(temp.kode + " | " + temp.nama + " | Rp" + temp.total);
            temp = temp.next;
        }
    }
}
