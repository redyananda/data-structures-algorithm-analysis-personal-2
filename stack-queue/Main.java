import java.util.Scanner;

// Program Sistem Kasir Toko
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue antrian = new Queue();
        Stack riwayat = new Stack();
        int pilih;

        do {
            System.out.println("=== SISTEM KASIR TOKO ===");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Layani Pelanggan");
            System.out.println("3. Tampilkan Antrian");
            System.out.println("4. Lihat Riwayat Transaksi");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            pilih = sc.nextInt();
            sc.nextLine(); // buang enter
            System.out.println();

            switch (pilih) {
                case 1: // Tambah Antrian
                    if (antrian.jumlah == antrian.MAKS) { // validasi maksimal 5
                        System.out.println("Antrian penuh! Maksimal 5 pelanggan.");
                        break;
                    }
                    System.out.print("Masukkan Nomor Antrian: ");
                    String kode = sc.nextLine();
                    System.out.print("Masukkan Nama Pelanggan: ");
                    String nama = sc.nextLine();
                    System.out.print("Masukkan Total Belanja: ");
                    int total = sc.nextInt();
                    sc.nextLine();
                    antrian.enqueue(kode, nama, total);
                    break;

                case 2: // Layani Pelanggan
                    Node p = antrian.dequeue();
                    if (p == null) {
                        System.out.println("Antrian kosong, tidak ada pelanggan.");
                    } else {
                        System.out.println("Melayani pelanggan " + p.kode
                                + " (" + p.nama + ")");
                        riwayat.push(p.kode, p.nama, p.total);
                        System.out.println("Transaksi disimpan ke riwayat.");
                    }
                    break;

                case 3: // Tampilkan Antrian
                    antrian.tampil();
                    break;

                case 4: // Lihat Riwayat Transaksi
                    riwayat.tampil();
                    break;

                case 5: // Keluar
                    System.out.println("Program selesai. Terima kasih!");
                    break;

                default:
                    System.out.println("Menu tidak tersedia.");
            }
            System.out.println();
        } while (pilih != 5);

        sc.close();
    }
}
