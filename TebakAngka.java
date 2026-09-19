import java.util.Random;

public class TebakAngka {
    private int angkaRahasia;
    private final int batasBawah;
    private final int batasAtas;
    private int batasPercobaan;
    private int jumlahPercobaan;
    private boolean menang;

    // Inisialisasi
    public TebakAngka(int batasBawah, int batasAtas, int batasPercobaan) {
        validateRange(batasBawah, batasAtas);
        validasiBatasPercobaan(batasPercobaan);

        this.batasBawah = batasBawah;
        this.batasAtas = batasAtas;
        this.batasPercobaan = batasPercobaan;
        this.jumlahPercobaan = 0;
        this.menang = false;

        generateAngkaRahasia();
    }

    // Validasi range
    private void validateRange(int batasBawah, int batasAtas) {
        if (batasBawah >= batasAtas) {
            throw new IllegalArgumentException(
                "Batas bawah harus lebih kecil dari batas atas."
            );
        }
    }

    // Validasi batas percobaan
    private void validasiBatasPercobaan(int batasPercobaan) {
        if (batasPercobaan != 3 &&
            batasPercobaan != 5 &&
            batasPercobaan != 7) {

            throw new IllegalArgumentException(
                "Batas percobaan harus 3, 5, atau 7."
            );
        }
    }

    // Validasi tebakan
    public boolean validasiTebakan(int tebakan) {
        return tebakan >= batasBawah &&
               tebakan <= batasAtas;
    }

    // Random angka rahasia
    private void generateAngkaRahasia() {
        Random random = new Random();

        angkaRahasia = random.nextInt(
            batasAtas - batasBawah + 1
        ) + batasBawah;
    }

    // Getter
    public int getJumlahPercobaan() {
        return jumlahPercobaan;
    }

    public int getBatasPercobaan() {
        return batasPercobaan;
    }

    public boolean isMenang() {
        return menang;
    }

    // Setter
    public void setBatasPercobaan(int batasPercobaan) {
        validasiBatasPercobaan(batasPercobaan);
        this.batasPercobaan = batasPercobaan;
    }

    // Inti game
    public String cekTebakan(int tebakan) {

        if (!validasiTebakan(tebakan)) {
            return "Tebakan tidak valid";
        }

        jumlahPercobaan++;

        if (tebakan < angkaRahasia) {
            return "Tebakan Anda terlalu rendah.";

        } else if (tebakan > angkaRahasia) {
            return "Tebakan Anda terlalu tinggi.";

        } else {
            menang = true;
            return "Selamat! Anda menebak angka rahasia!";
        }
    }

    // Cek apakah game selesai
    public boolean isGameSelesai() {
        return menang || jumlahPercobaan >= batasPercobaan;
    }
}