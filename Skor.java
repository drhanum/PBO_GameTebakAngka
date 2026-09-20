public class Skor {
    private String[] namaPemainAngka;
    private int[] skorPemainAngka;
    private String[] namaPemainAbjad;
    private int[] skorPemainAbjad;

    // CONSTRUCTOR, initialize empty arrays
    public Skor() {
        this.namaPemainAngka = new String[0];
        this.skorPemainAngka = new int[0];
        this.namaPemainAbjad = new String[0];
        this.skorPemainAbjad = new int[0];
    }

    // STATIC METHOD, calculates score based on number of attempts and max attempts
    public static int hitungSkor(int batasPercobaan, int jumlahPercobaan, boolean menang) {
        if (!menang) {
            return 0; // No score if the player didn't win
        }
        //final sebelum int
        final int maxSkor = 2500;
        int deduct = 0;
        switch (batasPercobaan) {
            case 3 -> deduct = 100;
            case 5 -> deduct = 200;
            case 7 -> deduct = 300;
            default -> throw new IllegalArgumentException("Batas percobaan harus 3, 5, atau 7.");
        }
        return maxSkor - (deduct * (jumlahPercobaan - 1));
    }

    // STATIC HELPER METHOD, adds a string to a String array
    private static String[] tambahElementString(String[] array, String element) {
        String[] tempArray = new String[array.length + 1];
        System.arraycopy(array, 0, tempArray, 0, array.length);
        tempArray[array.length] = element;
        return tempArray;
    }

    // STATIC HELPER METHOD, adds an int to an int array
    private static int[] tambahElementInt(int[] array, int element) {
        int[] tempArray = new int[array.length + 1];
        System.arraycopy(array, 0, tempArray, 0, array.length);
        tempArray[array.length] = element;
        return tempArray;
    }

    // SETTER METHOD, adds a new TebakAngka player-score pair to its respective arrays
    public void tambahSkorAngka(String namaPemain, int skor) {
        namaPemainAngka = tambahElementString(namaPemainAngka, namaPemain);
        skorPemainAngka = tambahElementInt(skorPemainAngka, skor);
        // sort the scores in descending order upon entry
        urutkanSkorAngka(false);
    }

    // SETTER METHOD, adds a new TebakAbjad player-score pair to its respective arrays
    public void tambahSkorAbjad(String namaPemain, int skor) {
        namaPemainAbjad = tambahElementString(namaPemainAbjad, namaPemain);
        skorPemainAbjad = tambahElementInt(skorPemainAbjad, skor);
        // sort the scores in descending order upon entry
        urutkanSkorAbjad(false);
    }

    // STATIC HELPER METHOD, sorts scores and swaps corresponding names (ascending = true for ascending, false for descending)
    private static void urutkanSkor(String[] namaPemain, int[] skorPemain, boolean ascending) {
        for (int i = 0; i < skorPemain.length - 1; i++) {
            for (int j = 0; j < skorPemain.length - 1 - i; j++) {
                boolean shouldSwap = ascending ? (skorPemain[j] > skorPemain[j + 1]) : (skorPemain[j] < skorPemain[j + 1]);
                
                if (shouldSwap) {
                    // swap scores
                    int tempSkor = skorPemain[j];
                    skorPemain[j] = skorPemain[j + 1];
                    skorPemain[j + 1] = tempSkor;

                    // swap corresponding player names
                    String tempNama = namaPemain[j];
                    namaPemain[j] = namaPemain[j + 1];
                    namaPemain[j + 1] = tempNama;
                }
            }
        }
    }

    // sorts TebakAngka scores in descending order (default)
    public void urutkanSkorAngka() {
        urutkanSkor(namaPemainAngka, skorPemainAngka, false);
    }

    // sorts TebakAngka scores with specified order
    public void urutkanSkorAngka(boolean ascending) {
        urutkanSkor(namaPemainAngka, skorPemainAngka, ascending);
    }

    // sorts TebakAbjad scores in descending order (default)
    public void urutkanSkorAbjad() {
        urutkanSkor(namaPemainAbjad, skorPemainAbjad, false);
    }

    // sorts TebakAbjad scores with specified order
    public void urutkanSkorAbjad(boolean ascending) {
        urutkanSkor(namaPemainAbjad, skorPemainAbjad, ascending);
    }

    // OUTPUT METHOD, prints TebakAngka scores in leaderboard format
    public void tampilkanLeaderboardAngka() {
        System.out.println("=== Skor Tebak Angka ===");
        for (int i = 0; i < namaPemainAngka.length; i++) {
            System.out.printf("%d. %s - %d%n", i + 1, namaPemainAngka[i], skorPemainAngka[i]);
        }
    }

    // OUTPUT METHOD, prints TebakAbjad scores in leaderboard format
    public void tampilkanLeaderboardAbjad() {
        System.out.println("=== Skor Tebak Abjad ===");
        for (int i = 0; i < namaPemainAbjad.length; i++) {
            System.out.printf("%d. %s - %d%n", i + 1, namaPemainAbjad[i], skorPemainAbjad[i]);
        }
    }

    // GETTER METHOD, returns a copy of the TebakAngka player names array
    public String[] getNamaPemainAngka() {
        return namaPemainAngka.clone();
    }

    // GETTER METHOD, returns a copy of the TebakAngka scores array
    public int[] getSkorPemainAngka() {
        return skorPemainAngka.clone();
    }

    // GETTER METHOD, returns a copy of the TebakAbjad player names array
    public String[] getNamaPemainAbjad() {
        return namaPemainAbjad.clone();
    }

    // GETTER METHOD, returns a copy of the TebakAbjad scores array
    public int[] getSkorPemainAbjad() {
        return skorPemainAbjad.clone();
    }
}