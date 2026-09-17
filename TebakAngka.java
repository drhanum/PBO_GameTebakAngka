import java.util.Random;

public class TebakAngka {
    private int angkaRahasia;
    private int batasBawah;
    private int batasAtas;
    private int batasPercobaan;
    private int jumlahPercobaan;
    private boolean menang;


    // inisialisasi
    public TebakAngka(int batasBawah, int batasAtas, int batasPercobaan) {
        this.batasBawah = batasBawah;
        this.batasAtas = batasAtas;
        this.jumlahPercobaan = 0;
        this.menang = false;

        validateRange(batasBawah, batasAtas);
        setBatasPercobaan(batasPercobaan);
        generateAngkaRahasia(batasBawah, batasAtas);
    }

    // validasi range
    private void validateRange(int batasBawah, int batasAtas) {
        if (batasBawah >= batasAtas) {
            throw new IllegalArgumentException("Batas bawah harus lebih kecil dari batas atas.");
        }
    }
    
    // validasi tebakan
    private boolean validasiTebakan(int tebakan) {
        return tebakan >= batasBawah && tebakan <= batasAtas;
    }

    // random generate angka rahasia
    private void generateAngkaRahasia(int batasBawah, int batasAtas) {
        validateRange(batasBawah, batasAtas);
        Random random = new Random();
        angkaRahasia = random.nextInt(batasAtas - batasBawah + 1) + batasBawah;
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
        if (batasPercobaan == 3 || batasPercobaan == 5 || batasPercobaan == 7) {
            this.batasPercobaan = batasPercobaan;
        } else {
            throw new IllegalArgumentException("Batas percobaan harus 3, 5, atau 7.");
        }
    }

    // inti game
    public String cekTebakan(int tebakan) {
        if (!validasiTebakan(tebakan)) {
            System.out.println("Tebakan harus berada dalam rentang " + batasBawah + " hingga " + batasAtas);
            return "Tebakan tidak valid";
        }

        jumlahPercobaan++;

        if (tebakan < angkaRahasia) {
            return "Tebakan terlalu rendah";
        } else if (tebakan > angkaRahasia) {
            return "Tebakan terlalu tinggi";
        } else {
            return "Selamat! Tebakan Anda benar!";
        }
    }

    public boolean isGameSelesai() {
        return menang || jumlahPercobaan >= batasPercobaan;
    }


}
