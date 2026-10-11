import java.util.Scanner;

// Program Pengelolaan Daftar Buku Perpustakaan
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList daftar = new LinkedList();
        int pilih;

        do {
            System.out.println("===== SISTEM DATA BUKU =====");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Hapus Buku");
            System.out.println("3. Cari Buku");
            System.out.println("4. Lihat Semua Buku");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            pilih = sc.nextInt();
            sc.nextLine(); // hapus sisa newline
            System.out.println();

            switch (pilih) {
                case 1: // Tambah Buku
                    System.out.print("Masukkan Kode Buku: ");
                    String kode = sc.nextLine();
                    if (kode.length() > 5) { // validasi kode maksimal 5 karakter
                        System.out.println("Kode buku maksimal 5 karakter!");
                        break;
                    }
                    System.out.print("Masukkan Judul: ");
                    String judul = sc.nextLine();
                    System.out.print("Masukkan Penulis: ");
                    String penulis = sc.nextLine();
                    daftar.push(kode, judul, penulis);
                    break;

                case 2: // Hapus Buku
                    daftar.pop();
                    break;

                case 3: // Cari Buku
                    System.out.print("Masukkan Kode Buku: ");
                    String kodeCari = sc.nextLine();
                    daftar.cari(kodeCari);
                    break;

                case 4: // Lihat Semua Buku
                    daftar.tampil();
                    break;

                case 5: // Keluar
                    if (daftar.jumlah < 5) { // validasi minimal 5 buku
                        System.out.println("Data buku minimal 5. Saat ini baru "
                                + daftar.jumlah + " buku.");
                        pilih = 0; // batal keluar
                    } else {
                        System.out.println("Program selesai. Terima kasih!");
                    }
                    break;

                default:
                    System.out.println("Menu tidak tersedia.");
            }
            System.out.println();
        } while (pilih != 5);

        sc.close();
    }
}
