// Class LinkedList: menyimpan daftar buku dengan Single Linked List
public class LinkedList {
    Node head = null; // buku pertama
    int jumlah = 0;   // total buku

    // 1. Tambah buku di akhir daftar (push)
    public void push(String kode, String judul, String penulis) {
        Node baru = new Node(kode, judul, penulis);
        if (head == null) {
            head = baru; // daftar kosong, buku baru jadi head
        } else {
            Node temp = head;
            while (temp.next != null) { // cari buku terakhir
                temp = temp.next;
            }
            temp.next = baru; // sambungkan di akhir
        }
        jumlah++;
        System.out.println("Data berhasil ditambahkan!");
    }

    // 2. Hapus buku terakhir (pop)
    public void pop() {
        if (head == null) {
            System.out.println("Tidak ada data untuk dihapus.");
            return;
        }
        if (head.next == null) { // hanya ada 1 buku
            System.out.println("Buku " + head.kodeBuku + " berhasil dihapus.");
            head = null;
        } else {
            Node temp = head;
            while (temp.next.next != null) { // cari buku kedua dari belakang
                temp = temp.next;
            }
            System.out.println("Buku " + temp.next.kodeBuku + " berhasil dihapus.");
            temp.next = null; // putuskan buku terakhir
        }
        jumlah--;
    }

    // 3. Cari buku berdasarkan kode
    public void cari(String kode) {
        Node temp = head;
        while (temp != null) {
            if (temp.kodeBuku.equals(kode)) {
                System.out.println("Buku ditemukan!");
                System.out.println("Kode    : " + temp.kodeBuku);
                System.out.println("Judul   : " + temp.judul);
                System.out.println("Penulis : " + temp.penulis);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Buku tidak ditemukan.");
    }

    // 4. Tampilkan semua buku sesuai urutan input
    public void tampil() {
        System.out.println("Daftar Buku:");
        Node temp = head;
        while (temp != null) {
            System.out.println("Kode: " + temp.kodeBuku + " | Judul: " + temp.judul
                    + " | Penulis: " + temp.penulis);
            temp = temp.next;
        }
        System.out.println("Total Buku: " + jumlah);
    }
}
