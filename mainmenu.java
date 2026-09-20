import java.util.InputMismatchException;
import java.util.Scanner;

public class mainmenu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int pilihan;

        do {
            tampilkanMenuUtama();
            pilihan = pilihMenu(in, 1, 4);

            switch (pilihan) {
                case 1 -> mainTebakAngka(in);
                case 2 -> mainTebakAbjad(in);
                case 3 -> menuSkor(in);
                case 4 -> System.out.println("\nTerima kasih telah bermain!\n");
            }
        } while (pilihan != 4);

        in.close();
    }

    private static int pilihMenu(Scanner in, int batasBawah, int batasAtas) {
        while (true) {
            try {
                int pilihan = in.nextInt();
                in.nextLine();

                if (pilihan >= batasBawah && pilihan <= batasAtas) {
                    return pilihan;
                }

                System.out.println("Pilihan tidak valid. Silakan pilih angka antara " + batasBawah + " sampai " + batasAtas + ".");
                System.out.print("Masukkan lagi: ");
            } catch (InputMismatchException e) {
                System.out.println("in harus angka. Silakan coba lagi.");
                in.nextLine();
                System.out.print("Masukkan lagi: ");
            }
        }
    }

    private static void tampilkanMenuUtama() {
        System.out.println("\n========================================");
        System.out.println("         MENU UTAMA GAME");
        System.out.println("========================================");
        System.out.println("1. Tebak Angka");
        System.out.println("2. Tebak Abjad");
        System.out.println("3. Skor");
        System.out.println("4. Keluar");
        System.out.println("========================================");
    }

    private static void mainTebakAngka(Scanner in) {
        System.out.println("\n=== GAME TEBAK ANGKA ===");

        System.out.print("Masukkan batas bawah: ");
        int batasBawah = bacaInt(in);

        System.out.print("Masukkan batas atas: ");
        int batasAtas = bacaInt(in);

        while (batasAtas <= batasBawah) {
            System.out.println("Batas atas harus lebih besar dari batas bawah.");
            System.out.print("Masukkan batas atas lagi: ");
            batasAtas = bacaInt(in);
        }

        System.out.println("Pilih banyak percobaan: 3x, 5x, atau 7x");
        int batasPercobaan = pilihPercobaan(in);

        TebakAngka game = new TebakAngka(batasBawah, batasAtas, batasPercobaan);

        System.out.println("\nGame dimulai!");
        System.out.println("Tebak angka dari " + batasBawah + " sampai " + batasAtas + ".");
        System.out.println("Anda punya " + game.getBatasPercobaan() + " kali percobaan.\n");

        while (!game.isGameSelesai()) {
            System.out.print("Masukkan tebakan Anda: ");
            int tebakan = bacaInt(in);

            String hasil = game.cekTebakan(tebakan);
            System.out.println(hasil);

            if (game.isMenang()) {
                System.out.println("\nSelamat! Anda menang.\n");
                //masi temp
                System.out.println("temp skor");
                break;
            }

            if (game.isGameSelesai()) {
                System.out.println("\nPercobaan habis. Anda kalah.\n");
                //masih temp juga
                System.out.println("temp skor");
                break;
            }
        }

        opsiKembaliKeMenuUtama(in);
    }

    private static void mainTebakAbjad(Scanner in) {
        System.out.println("\n=== GAME TEBAK ABJAD ===");
        System.out.println("Pilih banyak percobaan: 3x, 5x, atau 7x");
        int batasPercobaan = pilihPercobaan(in);

        TebakAbjad game = new TebakAbjad(batasPercobaan);

        System.out.println("\nGame dimulai!");
        System.out.println("Tebak huruf dari a sampai z.");
        System.out.println("Anda punya " + game.getBatasPercobaan() + " kali percobaan.\n");

        while (!game.isGameSelesai()) {
            System.out.print("Masukkan tebakan huruf Anda: ");
            String inUser = in.next();
            char tebakan = Character.toLowerCase(inUser.charAt(0));

            String hasil = game.tebakAbjad(tebakan);
            System.out.println(hasil);

            if (game.isGameSelesai()) {
                System.out.println("\nPermainan selesai.\n");
                //ini juga, msi temp
                System.out.println("temp skor");
                break;
            }
        }

        opsiKembaliKeMenuUtama(in);
    }

    private static void menuSkor(Scanner in) {
        System.out.println("\n=== MENU SKOR ===");
        System.out.println("1. Lihat leaderboard Tebak Angka");
        System.out.println("2. Lihat leaderboard Tebak Abjad");
        System.out.println("3. Kembali ke menu utama");

        int pilihan = pilihMenu(in, 1, 3);

        if (pilihan == 1) {
            System.out.println("\n=== LEADERBOARD TEBAK ANGKA ===");

        } else if (pilihan == 2) {
            System.out.println("\n=== LEADERBOARD TEBAK ABJAD ===");

        }
    }

    private static void opsiKembaliKeMenuUtama(Scanner in) {
        System.out.println("\n1. Kembali ke menu utama");
        System.out.println("0. Keluar");

        int pilihan = pilihMenu(in, 0, 1);

        if (pilihan == 0) {
            System.out.println("\nTerima kasih telah bermain!\n");
            System.exit(0);
        }
    }

    private static int pilihPercobaan(Scanner in) {
        while (true) {
            int pilihan = bacaInt(in);

            if (pilihan == 3 || pilihan == 5 || pilihan == 7) {
                return pilihan;
            }

            System.out.println("Batas percobaan hanya boleh 3, 5, atau 7.");
            System.out.print("Masukkan lagi: ");
        }
    }

    private static int bacaInt(Scanner in) {
        while (true) {
            try {
                return in.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("input harus berupa angka. Coba lagi.");
                in.nextLine();
                System.out.print("Masukkan lagi: ");
            }
        }
    }
}
