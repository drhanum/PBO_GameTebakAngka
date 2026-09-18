import java.util.Random;

public class TebakAbjad {
    private char abjadRahasia;
    private int batasPercobaan;
    private int jumlahPercobaan;


    //inisialisasi
    public TebakAbjad(int batasPercobaan) {
        this.jumlahPercobaan = 0;
        if (!batasPercobaanValid(batasPercobaan)) {
            throw new IllegalArgumentException("Batas percobaan harus 3, 5, atau 7.");
        }
        this.batasPercobaan = batasPercobaan;
        generateAbjadRahasia();
    }

    private void generateAbjadRahasia() {
        Random random = new Random();
        abjadRahasia = (char) (random.nextInt(26) + 'a');
    }

    // validasi tebakan

    private boolean validateTebakan(char tebakan) {
        tebakan = Character.toLowerCase(tebakan);
        return tebakan >= 'a' && tebakan <= 'z';
    }

    // getter

    public int getJumlahPercobaan() {
        return jumlahPercobaan;
    }

    public int getBatasPercobaan() {
        return batasPercobaan;
    }

    // setter

    public void setBatasPercobaan(int batasPercobaan) {
        if (batasPercobaanValid(batasPercobaan)) {
            this.batasPercobaan = batasPercobaan;
        } else {
            throw new IllegalArgumentException("Batas percobaan harus 3, 5, atau 7.");
        }
    }

    private static boolean batasPercobaanValid(int batasPercobaan) {
        return batasPercobaan == 3 || batasPercobaan == 5 || batasPercobaan == 7;
    }
    
    //ini game

    public String tebakAbjad(char tebakan) {
        if (isGameSelesai()) {
            return "Permainan sudah selesai.";
        }

        if (!validateTebakan(tebakan)) {
            return "Tebakan harus berupa huruf.";
        }

        jumlahPercobaan++;
        tebakan = Character.toLowerCase(tebakan);

        if (tebakan == abjadRahasia) {
            return "Selamat! Tebakan Anda benar.";
        } else if (jumlahPercobaan >= batasPercobaan) {
            return "Maaf, Anda telah kehabisan percobaan. Abjad rahasia adalah: " + abjadRahasia;
        } else {
            return "Tebakan salah. Silakan coba lagi.";
        }
    }

    public boolean isGameSelesai() {
        return jumlahPercobaan >= batasPercobaan;
    }

}

