# 🎮 PBO Game Tebak Angka

Project game sederhana berbasis **Java** untuk tugas **Pemrograman Berorientasi Objek (PBO)**.

Game memiliki dua mode utama:
- Tebak Angka
- Tebak Abjad

Selain itu terdapat:
- Sistem skor dan leaderboard
- Pilihan batas percobaan: 3, 5, atau 7 kali
- Menu utama

---

## 👥 Pembagian Tugas

| Anggota | Bagian | Branch |
|---|---|---|
| **Hanum** | Class Tebak Angka | `feature/tebak-angka` |
| **Naomi** | Class Tebak Abjad | `feature/tebak-abjad` |
| **Christian & Olin** | Class Skor | `feature/skor` |
| **Theo** | Main / Menu Utama | `feature/main-menu` |

> DISCLAIMER! **Penting:** Jangan mengerjakan langsung di branch `master`.
> Setiap anggota mengerjakan bagian masing-masing di branch fitur.

---

# Panduan Setup untuk Anggota Kelompok

## 1. Pastikan Git sudah terinstall

Cek melalui Terminal / Command Prompt:

```bash
git --version
```

Jika muncul versi Git, berarti Git sudah siap digunakan.

Contoh:

```text
git version 2.x.x
```

---

## 2. Clone Repository

Buka **VS Code**.

Pilih:

**Terminal → New Terminal**

Kemudian pindah ke folder tempat project ingin disimpan.

Contoh:

```bash
cd Documents
```

Clone repository:

```bash
git clone https://github.com/drhanum/PBO_GameTebakAngka.git
```

Setelah selesai, masuk ke folder project:

```bash
cd PBO_GameTebakAngka
```

---

## 3. Buka Project di VS Code

Setelah berada di dalam folder project:

```bash
code .
```

Atau bisa juga buka VS Code secara manual:

**File → Open Folder → PBO_GameTebakAngka**

---

# 4. Cek Branch

Sebelum membuat branch, cek branch yang tersedia:

```bash
git branch
```

Biasanya akan terlihat:

```text
* master
```

Tanda `*` menunjukkan branch yang sedang digunakan.

---

# 5. Buat Branch Sesuai Pembagian Tugas

Setiap anggota **WAJIB membuat branch masing-masing**.

---

## Naomi — Tebak Abjad

Setelah clone repository:

```bash
git checkout master
git pull origin master
git checkout -b feature/tebak-abjad
```

Kemudian push branch ke GitHub:

```bash
git push -u origin feature/tebak-abjad
```

Cek:

```bash
git branch
```

Harus menunjukkan:

```text
* feature/tebak-abjad
  master
```

---

## Christian & Olin — Class Skor

Gunakan satu branch:

```text
feature/skor
```

Orang pertama yang membuat branch:

```bash
git checkout master
git pull origin master
git checkout -b feature/skor
git push -u origin feature/skor
```

Anggota kedua **tidak perlu membuat branch dengan nama yang sama** jika branch tersebut sudah ada di GitHub.

Setelah clone:

```bash
git fetch origin
git checkout feature/skor
```

> Christian dan Olin harus koordinasi waktu ngedit file `Skor.java`.
> JANGAN ngedit bagian/baris yang sama secara bersamaan biar gaada merge conflict.

---

## Theo — Main

Setelah clone repository:

```bash
git checkout master
git pull origin master
git checkout -b feature/main-menu
```

Kemudian:

```bash
git push -u origin feature/main-menu
```

---

# 6. Setelah Berhasil Membuat Branch

Pastikan kalian **tidak sedang berada di `master`**.

Gunakan:

```bash
git branch
```

Contoh Naomi:

```text
  master
* feature/tebak-abjad
```

Kalau tanda `*` masih berada di:

```text
* master
```

**Jangan mulai coding dulu.**

---

# 7. Mulai Coding

Setiap anggota fokus pada file yang sudah dibagi:

```text
PBO_GameTebakAngka/
│
├── Main.java
├── TebakAngka.java
├── TebakAbjad.java
├── Skor.java
│
├── Struktur_TebakAbjad.md
└── Struktur_Skor.md
```

### Naomi

Fokus:

```text
TebakAbjad.java
```

### Christian & Olin

Fokus:

```text
Skor.java
```

### Theo

Fokus:

```text
Main.java
```

---

# 8. Jangan Mengubah Struktur Class Orang Lain Sembarangan

Sebelum coding, kita sudah sepakat sama struktur method nya.

## TebakAngka

```text
TebakAngka
│
├── Data
│   ├── angkaRahasia
│   ├── batasBawah
│   ├── batasAtas
│   ├── batasPercobaan
│   ├── jumlahPercobaan
│   └── menang
│
├── Random
│   └── generateAngkaRahasia()
│
├── Validasi
│   ├── validateRange()
│   └── validasiTebakan()
│
├── Getter
│   ├── getJumlahPercobaan()
│   └── getBatasPercobaan()
│
├── Setter
│   └── setBatasPercobaan()
│
└── Game
    ├── cekTebakan()
    └── isGameSelesai()
```

## TebakAbjad

```text
TebakAbjad
│
├── Data
│   ├── abjadRahasia
│   ├── batasPercobaan
│   └── jumlahPercobaan
│
├── Random
│   └── generateAbjadRahasia()
│
├── Validasi
│   └── validasiTebakan()
│
├── Getter
│   ├── getJumlahPercobaan()
│   └── getBatasPercobaan()
│
├── Setter
│   └── setBatasPercobaan()
│
└── Game
    ├── cekTebakan()
    └── isGameSelesai()
```

## Skor

```text
Skor
│
├── Data
│   ├── namaPemainAngka[]
│   ├── skorPemainAngka[]
│   ├── namaPemainAbjad[]
│   └── skorPemainAbjad[]
│
├── Perhitungan
│   └── hitungSkor()
│
├── Penyimpanan Skor
│   ├── tambahSkorAngka()
│   └── tambahSkorAbjad()
│
├── Pengurutan
│   ├── urutkanSkorAngka()
│   └── urutkanSkorAbjad()
│
└── Leaderboard
    ├── tampilkanLeaderboardAngka()
    └── tampilkanLeaderboardAbjad()
```

> kalo mau ganti nama method, parameter, atau struktur class, **diskusikan dulu di grup** karena `Main.java` akan bergantung pada method dari class lain.

---

# 9. Setelah Selesai Coding

Jangan langsung push semuanya.

Pertama cek perubahan:

```bash
git status
```

Kemudian cek kode:

```bash
git diff
```

Jika sudah yakin, tambahkan file:

```bash
git add .
```

Commit:

```bash
git commit -m "feat: implement tebak abjad"
```

Sesuaikan pesan commit dengan bagian yang dikerjakan.

Contoh:

### Tebak Angka

```bash
git commit -m "feat: implement tebak angka"
```

### Tebak Abjad

```bash
git commit -m "feat: implement tebak abjad"
```

### Skor

```bash
git commit -m "feat: implement scoring system"
```

### Main

```bash
git commit -m "feat: implement main menu"
```

---

# 10. Push ke GitHub

Push branch masing-masing:

```bash
git push
```

Jika ini adalah push pertama pada branch:

```bash
git push -u origin nama-branch
```

Contoh:

```bash
git push -u origin feature/tebak-abjad
```

---

# 11. Buat Pull Request

Setelah push, buka repository GitHub.

Pilih:

**Compare & pull request**

Pastikan:

```text
base: master
compare: feature/tebak-abjad
```

Contoh:

```text
feature/tebak-abjad
        ↓
      master
```

Kemudian buat Pull Request.

> ⚠️ Jangan langsung merge kalau belum dicek oleh anggota lain.

---

# 12. Review Sebelum Merge

Sebelum Pull Request di-merge:

1. Cek perubahan kode.
2. Pastikan tidak menghapus kode anggota lain.
3. Pastikan nama method sesuai struktur yang sudah disepakati.
4. Pastikan project masih bisa dijalankan.
5. Pastikan tidak ada error Java.
6. Pastikan fitur yang dikerjakan sudah dites.

Jika ada masalah, diskusikan di Pull Request.

---

# 13. Setelah Ada Perubahan di `master`

Setelah Pull Request anggota lain sudah di-merge ke `master`, **jangan langsung coding menggunakan branch lama tanpa update**.

Sebelum melanjutkan pekerjaan:

```bash
git checkout master
git pull origin master
```

Kemudian kembali ke branch masing-masing:

```bash
git checkout feature/nama-branch
```

Lalu ambil perubahan terbaru dari `master`:

```bash
git merge master
```

Contoh Naomi:

```bash
git checkout master
git pull origin master
git checkout feature/tebak-abjad
git merge master
```

Jika muncul conflict, **jangan langsung menghapus kode orang lain**. Diskusikan dulu di grup.

---

# 14. Aturan Supaya Tidak Conflict

### Jangan

```text
Semua orang → master
```

### Gunakan

```text
master
│
├── feature/tebak-angka
├── feature/tebak-abjad
├── feature/skor
└── feature/main-menu
```

### Jangan

Mengubah file yang bukan tanggung jawab sendiri tanpa koordinasi.

Mengubah nama method yang sudah disepakati tanpa memberi tahu anggota lain.

### Jangan

Menggunakan:

```bash
git push --force
```

terutama ke `master`.

### Jangan

Meng-copy hasil kerja anggota lain ke branch sendiri tanpa alasan.

### Biasakan

```bash
git status
git pull
git add .
git commit
git push
```

---

# 15. Sebelum Pull Request

Pastikan:

```text
☐ Sudah coding di branch yang benar
☐ Tidak ada error
☐ Project bisa dijalankan
☐ Method sesuai kesepakatan
☐ Tidak mengubah file anggota lain
☐ Sudah git add
☐ Sudah commit
☐ Sudah push
☐ Sudah membuat Pull Request
```

---

# Target Akhir

Setelah semua branch selesai dan sudah di-review:

```text
                    master
                       │
        ┌──────────────┼──────────────┐
        │              │              │
        ▼              ▼              ▼
  TebakAngka      TebakAbjad        Skor
   (Hanum)         (Naomi)       (Christian & Olin)
        │              │              │
        └──────────────┼──────────────┘
                       │
                       ▼
                     Main
                    (Theo)
                       │
                       ▼
               🎮 GAME SELESAI 🎮
```

---

# Ringkasan Command per Anggota

## Naomi

```bash
git clone https://github.com/drhanum/PBO_GameTebakAngka.git
cd PBO_GameTebakAngka
git checkout master
git pull origin master
git checkout -b feature/tebak-abjad
git push -u origin feature/tebak-abjad
```

## Christian & Olin

Branch hanya **satu**:

```bash
feature/skor
```

Pembuat branch:

```bash
git clone https://github.com/drhanum/PBO_GameTebakAngka.git
cd PBO_GameTebakAngka
git checkout master
git pull origin master
git checkout -b feature/skor
git push -u origin feature/skor
```

Anggota kedua:

```bash
git clone https://github.com/drhanum/PBO_GameTebakAngka.git
cd PBO_GameTebakAngka
git fetch origin
git checkout feature/skor
```

## Theo

```bash
git clone https://github.com/drhanum/PBO_GameTebakAngka.git
cd PBO_GameTebakAngka
git checkout master
git pull origin master
git checkout -b feature/main-menu
git push -u origin feature/main-menu
```

---

## VS Code Markdown Preview

Untuk melihat tampilan `README.md` di VS Code:

**Tekan `Ctrl + Shift + V`**

Untuk kembali ke tampilan kode, tekan:

**`Ctrl + Shift + V`** lagi atau tutup tab Preview.
