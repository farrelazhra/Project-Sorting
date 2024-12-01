import java.util.Scanner;

public class SortingPerkuliahanCLI {

    // Class Mahasiswa untuk menyimpan data mahasiswa
    static class Mahasiswa {
        String nama; // Nama mahasiswa
        String nim;  // NIM mahasiswa

        // Constructor untuk inisialisasi nama dan NIM
        Mahasiswa(String nama, String nim) {
            this.nama = nama;
            this.nim = nim;
        }
    }

    // Bubble Sort untuk mengurutkan berdasarkan NIM (dari kecil ke besar)
    public static void bubbleSortByNIM(Mahasiswa[] mahasiswa) {
        int n = mahasiswa.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // Jika NIM elemen saat ini lebih besar daripada elemen berikutnya, lakukan swap
                if (mahasiswa[j].nim.compareTo(mahasiswa[j + 1].nim) > 0) {
                    Mahasiswa temp = mahasiswa[j];
                    mahasiswa[j] = mahasiswa[j + 1];
                    mahasiswa[j + 1] = temp;
                }
            }
            // Menampilkan proses sorting untuk setiap iterasi
            System.out.println("Iterasi " + (i + 1) + ":");
            displayData(mahasiswa);
        }
    }

    // Selection Sort untuk mengurutkan berdasarkan Nama (dari A-Z)
    public static void selectionSortByName(Mahasiswa[] mahasiswa) {
        int n = mahasiswa.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i; // Indeks elemen terkecil
            for (int j = i + 1; j < n; j++) {
                // Jika nama di indeks j lebih kecil daripada nama di indeks minIndex, update minIndex
                if (mahasiswa[j].nama.compareTo(mahasiswa[minIndex].nama) < 0) {
                    minIndex = j;
                }
            }
            // Swap elemen di indeks i dengan elemen di indeks minIndex
            Mahasiswa temp = mahasiswa[minIndex];
            mahasiswa[minIndex] = mahasiswa[i];
            mahasiswa[i] = temp;

            // Menampilkan proses sorting untuk setiap iterasi
            System.out.println("Iterasi " + (i + 1) + ":");
            displayData(mahasiswa);
        }
    }

    // Menampilkan data mahasiswa
    public static void displayData(Mahasiswa[] mahasiswa) {
        for (Mahasiswa m : mahasiswa) {
            System.out.println("NIM: " + m.nim + " | Nama: " + m.nama);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input jumlah mahasiswa
        System.out.print("Masukkan jumlah mahasiswa: ");
        int jumlah = scanner.nextInt();
        scanner.nextLine(); // Menghapus newline setelah input angka

        // Inisialisasi array mahasiswa
        Mahasiswa[] mahasiswa = new Mahasiswa[jumlah];

        // Input data mahasiswa
        for (int i = 0; i < jumlah; i++) {
            System.out.println("Mahasiswa ke-" + (i + 1) + ":");
            System.out.print("  Masukkan Nama: ");
            String nama = scanner.nextLine();
            System.out.print("  Masukkan NIM: ");
            String nim = scanner.nextLine();
            mahasiswa[i] = new Mahasiswa(nama, nim); // Menambahkan data ke array
        }

        // Menampilkan data sebelum diurutkan
        System.out.println("\nData Mahasiswa Sebelum Diurutkan:");
        displayData(mahasiswa);

        // Menu untuk memilih metode sorting
        System.out.println("Pilih Metode Pengurutan:");
        System.out.println("1. Urutkan berdasarkan NIM (Bubble Sort)");
        System.out.println("2. Urutkan berdasarkan Nama (Selection Sort)");
        System.out.print("Pilihan Anda: ");
        int pilihan = scanner.nextInt();

        // Pemilihan metode sorting
        switch (pilihan) {
            case 1:
                System.out.println("\nProses Bubble Sort Berdasarkan NIM:");
                bubbleSortByNIM(mahasiswa);
                System.out.println("\nData Mahasiswa Setelah Diurutkan Berdasarkan NIM:");
                displayData(mahasiswa);
                break;

            case 2:
                System.out.println("\nProses Selection Sort Berdasarkan Nama:");
                selectionSortByName(mahasiswa);
                System.out.println("\nData Mahasiswa Setelah Diurutkan Berdasarkan Nama:");
                displayData(mahasiswa);
                break;

            default:
                System.out.println("Pilihan tidak valid! Program selesai.");
        }

        scanner.close(); // Menutup scanner untuk mencegah kebocoran sumber daya
    }
}
