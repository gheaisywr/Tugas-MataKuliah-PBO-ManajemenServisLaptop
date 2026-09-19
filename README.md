# Sistem Pengelolaan Servis Laptop

> Aplikasi berbasis **Command Line Interface (CLI)** menggunakan **Java** dengan menerapkan konsep **Pemrograman Berorientasi Objek (PBO)**.

---

Program ini merupakan aplikasi berbasis **Command Line Interface (CLI)** yang dibuat menggunakan bahasa pemrograman **Java** dengan menerapkan konsep **Pemrograman Berorientasi Objek (PBO)**.

---

## Identitas Mahasiswa

**Nama:** Ghea Aisyah Windraswari  
**NIM:** 2509116022  

---

## 📌 1. Studi Kasus

### Sistem Pengelolaan Servis Laptop

Studi kasus yang dipilih adalah **Sistem Pengelolaan Servis Laptop**. Program ini dibuat untuk membantu proses pencatatan data pelanggan, data perangkat atau laptop, serta data servis laptop.

Program dijalankan melalui terminal atau Command Line Interface (CLI). Pengguna dapat melakukan beberapa proses pengelolaan data, seperti menambahkan data, menampilkan data, mengubah data, menghapus data, dan mencari data servis.

Program ini dibuat menggunakan konsep Pemrograman Berorientasi Objek sehingga data dan fungsi program dibagi ke dalam beberapa class yang memiliki tugas masing-masing.

### Fitur Program

Program memiliki beberapa fitur utama, yaitu:

1. **Tambah Data Servis**  
   Digunakan untuk memasukkan data pelanggan, laptop, dan servis baru.

2. **Tampilkan Data Servis**  
   Digunakan untuk melihat seluruh data servis yang telah tersimpan.

3. **Ubah Data Servis**  
   Digunakan untuk mengubah informasi servis berdasarkan ID servis.

4. **Hapus Data Servis**  
   Digunakan untuk menghapus data servis berdasarkan ID servis dengan konfirmasi terlebih dahulu.

5. **Cari Data Servis**  
   Digunakan untuk mencari data servis berdasarkan ID servis.

6. **Keluar**  
   Digunakan untuk mengakhiri program.

Selain fitur utama tersebut, program juga menggunakan validasi input agar data yang dimasukkan tidak kosong dan sesuai dengan tipe data yang dibutuhkan.

---

## 🧩 2. Struktur Class

Program terdiri dari beberapa class yang memiliki fungsi berbeda.

### 🔹 Class yang Digunakan

- **Perangkat** → Superclass yang menyimpan atribut umum perangkat.
- **Laptop** → Subclass dari Perangkat yang memiliki atribut tambahan berupa kerusakan.
- **Pelanggan** → Menyimpan data pelanggan.
- **Servis** → Menyimpan data servis laptop.
- **ManajemenServisLaptop** → Class utama yang menjalankan program dan menu CLI.

Struktur class dapat digambarkan sebagai berikut:

```text
              Perangkat
             Superclass
                  ▲
                  │
                  │ extends
                  │
                Laptop
               Subclass


             Pelanggan

                Servis

                  │
                  │
                  ▼
       ManajemenServisLaptop
            Main Program
```

`Perangkat` dan `Laptop` memiliki hubungan **inheritance**, sedangkan `Pelanggan` dan `Servis` merupakan class yang berdiri sendiri dan digunakan oleh class utama.

---

## 📚 3. Penjelasan Masing-Masing Class

### 3.1 `Perangkat`

Class `Perangkat` merupakan **superclass** atau class induk.

Class ini digunakan untuk menyimpan atribut yang bersifat umum dan dapat dimiliki oleh berbagai jenis perangkat.

Atribut yang terdapat pada class `Perangkat` yaitu:

- `idPerangkat`
- `merk`
- `tipe`

Contoh kode:

```java
package model;

public class Perangkat {

    private String idPerangkat;
    private String merk;
    private String tipe;

    public Perangkat(String idPerangkat, String merk, String tipe) {
        this.idPerangkat = idPerangkat;
        this.merk = merk;
        this.tipe = tipe;
    }

    public String getIdPerangkat() {
        return idPerangkat;
    }

    public void setIdPerangkat(String idPerangkat) {
        this.idPerangkat = idPerangkat;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }
}
```

---

### 3.2 `Laptop`

Class `Laptop` merupakan **subclass** dari class `Perangkat`.

Hubungan inheritance diterapkan menggunakan keyword:

```java
extends Perangkat
```

Class `Laptop` mewarisi atribut dan method dari class `Perangkat`, kemudian memiliki atribut tambahan yaitu `kerusakan`.

Contoh kode:

```java
package model;

public class Laptop extends Perangkat {

    private String kerusakan;

    public Laptop(String idPerangkat, String merk, String tipe, String kerusakan) {
        super(idPerangkat, merk, tipe);
        this.kerusakan = kerusakan;
    }

    public String getKerusakan() {
        return kerusakan;
    }

    public void setKerusakan(String kerusakan) {
        this.kerusakan = kerusakan;
    }
}
```

Dengan demikian, class `Laptop` tidak perlu mendeklarasikan kembali `idPerangkat`, `merk`, dan `tipe` karena atribut tersebut sudah dimiliki oleh superclass `Perangkat`.

---

### 3.3 `Pelanggan`

Class `Pelanggan` digunakan untuk menyimpan informasi pelanggan yang melakukan servis laptop.

Atribut yang digunakan yaitu:

- `idPelanggan`
- `nama`
- `noTelepon`
- `alamat`

Contoh:

```java
public class Pelanggan {

    private String idPelanggan;
    private String nama;
    private String noTelepon;
    private String alamat;

    public Pelanggan(String idPelanggan, String nama,
                     String noTelepon, String alamat) {
        this.idPelanggan = idPelanggan;
        this.nama = nama;
        this.noTelepon = noTelepon;
        this.alamat = alamat;
    }
}
```

---

### 3.4 `Servis`

Class `Servis` digunakan untuk menyimpan informasi mengenai proses servis laptop.

Atribut yang digunakan yaitu:

- `idServis`
- `tanggalMasuk`
- `status`
- `biaya`

Contoh:

```java
public class Servis {

    private String idServis;
    private String tanggalMasuk;
    private String status;
    private double biaya;

    public Servis(String idServis, String tanggalMasuk,
                  String status, double biaya) {
        this.idServis = idServis;
        this.tanggalMasuk = tanggalMasuk;
        this.status = status;
        this.biaya = biaya;
    }
}
```

---

## 🔗 4. Penerapan Inheritance

Inheritance merupakan konsep PBO yang memungkinkan sebuah class mewarisi atribut dan method dari class lain.

Pada program ini, inheritance diterapkan pada hubungan:

```text
Perangkat
    ▲
    │
 Laptop
```

Class `Perangkat` berperan sebagai **superclass**, sedangkan `Laptop` berperan sebagai **subclass**.

### 💡 Bagian Kode yang Menerapkan Inheritance

Pada class `Laptop` terdapat kode:

```java
public class Laptop extends Perangkat {
```

Keyword `extends` menunjukkan bahwa class `Laptop` mewarisi isi dari class `Perangkat`.

Selain itu, constructor `Laptop` menggunakan:

```java
super(idPerangkat, merk, tipe);
```

Keyword `super` digunakan untuk memanggil constructor dari superclass `Perangkat`.

Dengan penerapan tersebut, atribut:

```text
idPerangkat
merk
tipe
```

berasal dari superclass `Perangkat`, sedangkan atribut:

```text
kerusakan
```

merupakan atribut khusus yang dimiliki oleh class `Laptop`.

Struktur sederhananya:

```text
Perangkat
├── idPerangkat
├── merk
└── tipe
       │
       │ diwariskan
       ▼
Laptop
└── kerusakan
```

---

## 🏗️ 5. Pembuatan Object

Konsep object digunakan ketika program membuat data berdasarkan class yang telah dibuat.

Contohnya pada class utama:

```java
Pelanggan pelanggan = new Pelanggan(
    idPelanggan,
    nama,
    noTelepon,
    alamat
);

Laptop laptop = new Laptop(
    idPerangkat,
    merk,
    tipe,
    kerusakan
);

Servis servis = new Servis(
    idServis,
    tanggalMasuk,
    status,
    biaya
);
```

Kode tersebut membuat object dari class `Pelanggan`, `Laptop`, dan `Servis`.

Object `Laptop` dibuat menggunakan constructor subclass dan secara otomatis memanggil constructor superclass `Perangkat` melalui:

```java
super(idPerangkat, merk, tipe);
```

---

## 📦 6. Penggunaan ArrayList

Program menggunakan `ArrayList` untuk menyimpan data selama program berjalan.

Contohnya:

```java
ArrayList<Pelanggan> daftarPelanggan = new ArrayList<>();
ArrayList<Laptop> daftarLaptop = new ArrayList<>();
ArrayList<Servis> daftarServis = new ArrayList<>();
```

Setiap data yang berhasil dibuat kemudian dimasukkan ke dalam `ArrayList`.

Contohnya:

```java
daftarPelanggan.add(pelanggan);
daftarLaptop.add(laptop);
daftarServis.add(servis);
```

Dengan menggunakan `ArrayList`, program dapat menyimpan lebih dari satu data dan melakukan proses tambah, tampil, ubah, hapus, serta pencarian data.

---

## 🖥️ 7. Menu Program

Program menggunakan menu utama berbasis CLI.

Contoh menu:

```text
========================================
     SISTEM PENGELOLAAN SERVIS LAPTOP
========================================
1. Tambah Data Servis
2. Tampilkan Data Servis
3. Ubah Data Servis
4. Hapus Data Servis
5. Cari Data Servis
6. Keluar
========================================
Pilih menu:
```

Menu tersebut dibuat menggunakan percabangan `switch-case`.

Contohnya:

```java
switch (pilihan) {
    case 1:
        tambahDataServis();
        break;

    case 2:
        tampilkanDataServis();
        break;

    case 3:
        ubahDataServis();
        break;

    case 4:
        hapusDataServis();
        break;

    case 5:
        cariDataServis();
        break;

    case 6:
        System.out.println("Program selesai.");
        break;

    default:
        System.out.println("Pilihan menu tidak tersedia!");
}
```

Menu dijalankan secara berulang menggunakan perulangan sehingga pengguna dapat memilih fitur lain tanpa harus menjalankan ulang program.

---

## ➕ 8. Proses Tambah Data

Pada menu tambah data, pengguna memasukkan beberapa informasi seperti:

- ID pelanggan
- Nama pelanggan
- Nomor telepon
- Alamat
- ID laptop/perangkat
- Merk laptop
- Tipe laptop
- Kerusakan
- ID servis
- Tanggal masuk
- Status servis
- Biaya servis

Setelah semua data dimasukkan, program membuat object:

```java
Pelanggan pelanggan = new Pelanggan(...);
Laptop laptop = new Laptop(...);
Servis servis = new Servis(...);
```

Kemudian object tersebut dimasukkan ke dalam masing-masing `ArrayList`.

---

## 📋 9. Proses Menampilkan Data

Data yang telah tersimpan dapat ditampilkan melalui menu **Tampilkan Data Servis**.

Program menggunakan perulangan untuk membaca seluruh isi `ArrayList`.

Data yang ditampilkan meliputi informasi pelanggan, laptop, dan servis.

Contoh output:

```text
================================ DATA SERVIS ================================

ID Pelanggan : P001
Nama         : James Chao
No Telepon   : 081234567801
Alamat       : Jl. P. Antasari Samarinda

ID Laptop    : L001
Merk         : ASUS
Tipe         : VivoBook 14
Kerusakan    : Keyboard beberapa tombol tidak berfungsi

ID Servis    : S001
Tanggal      : 09-09-2026
Status       : Diproses
Biaya        : Rp250000
```

---

## ✏️ 10. Proses Mengubah Data

Menu **Ubah Data Servis** digunakan untuk mengubah informasi servis berdasarkan ID servis.

Pengguna memasukkan ID servis yang ingin diubah, kemudian program mencari data tersebut.

Jika data ditemukan, pengguna dapat memasukkan informasi baru seperti status dan biaya servis.

Jika ID tidak ditemukan, program akan memberikan pesan bahwa data tidak tersedia.

---

## 🗑️ 11. Proses Menghapus Data

Menu **Hapus Data Servis** digunakan untuk menghapus data berdasarkan ID servis.

Sebelum data dihapus, program memberikan konfirmasi kepada pengguna.

Contoh:

```text
Masukkan ID Servis: S001

Apakah Anda yakin ingin menghapus data ini? (y/n): y

Data servis berhasil dihapus.
```

Konfirmasi digunakan untuk mencegah data terhapus secara tidak sengaja.

---

## 🔎 12. Proses Pencarian Data

Program menyediakan fitur pencarian berdasarkan ID servis.

Pengguna memasukkan ID servis, kemudian program melakukan pencarian pada data yang tersimpan.

Jika ditemukan, informasi servis akan ditampilkan.

Jika tidak ditemukan, program memberikan pesan:

```text
Data servis tidak ditemukan.
```

---

## ✅ 13. Validasi Input

Program juga menerapkan validasi input untuk mengurangi kesalahan saat pengguna memasukkan data.

Beberapa validasi yang digunakan antara lain:

### Validasi data kosong

```text
Nama tidak boleh kosong!
```

### Validasi nomor telepon

Nomor telepon harus berupa angka.

```text
No. Telepon hanya boleh berisi angka!
```

### Validasi biaya

Biaya servis tidak boleh bernilai negatif.

```text
Biaya tidak boleh negatif!
```

### Validasi pilihan menu

Jika pengguna memasukkan menu yang tidak tersedia:

```text
Pilihan menu tidak tersedia!
```

Validasi tersebut membantu agar data yang masuk ke dalam program lebih sesuai dengan kebutuhan sistem.

---

## 📸 14. Screenshot Running Program

Berikut adalah screenshot yang digunakan untuk menunjukkan bahwa program dapat dijalankan melalui terminal/Command Line Interface.

### 14.1 Tampilan Menu Utama

<img width="245" height="140" alt="image" src="https://github.com/user-attachments/assets/ed230f8a-2ddf-48c3-b6a0-903d4462bf7b" />

Gambar menunjukkan menu utama program yang menyediakan pilihan untuk menambah, menampilkan, mengubah, menghapus, mencari data, dan keluar dari program.

---

### 14.2 Proses Tambah Data

<img width="227" height="287" alt="image" src="https://github.com/user-attachments/assets/0f2519b7-c3ef-46d3-8b62-05f76394f874" />

Gambar menunjukkan proses ketika pengguna memasukkan data pelanggan, laptop, dan servis.

---

### 14.3 Tampilan Data Servis

<img width="248" height="248" alt="image" src="https://github.com/user-attachments/assets/1790b9bd-d5e9-47d0-a55f-f15dbd334a6a" />

Gambar menunjukkan data servis yang telah berhasil disimpan dan ditampilkan oleh program.

---

### 14.4 Proses Ubah Data

<img width="248" height="226" alt="image" src="https://github.com/user-attachments/assets/170c0418-ba21-4a9d-92e1-10028247f367" />

Gambar menunjukkan proses perubahan data servis berdasarkan ID servis.

---

### 14.5 Proses Pencarian Data

<img width="329" height="214" alt="image" src="https://github.com/user-attachments/assets/c9e712a5-adc4-4e4f-b561-80894a90cef5" />

Gambar menunjukkan fitur pencarian data servis berdasarkan ID servis.

---

### 14.6 Proses Hapus Data

<img width="251" height="89" alt="image" src="https://github.com/user-attachments/assets/b7ee1ffa-752b-40a6-8be2-5c4e7ff6435a" />

Gambar menunjukkan konfirmasi sebelum data servis dihapus dari sistem.

---

## 🧠 15. Penerapan Konsep PBO

Program ini menerapkan beberapa konsep dasar Pemrograman Berorientasi Objek, yaitu:

### 1. Class

Program memiliki beberapa class seperti:

```text
Perangkat
Laptop
Pelanggan
Servis
ManajemenServisLaptop
```

Setiap class memiliki fungsi dan data yang berbeda.

### 2. Object

Object dibuat dari class menggunakan keyword `new`.

Contoh:

```java
Laptop laptop = new Laptop(
    idPerangkat,
    merk,
    tipe,
    kerusakan
);
```

### 3. Encapsulation

Atribut pada class dibuat menggunakan access modifier `private`.

Contoh:

```java
private String merk;
private String tipe;
```

Data tersebut diakses melalui method getter dan setter.

### 4. Constructor

Setiap class memiliki constructor yang digunakan untuk memberikan nilai awal pada object.

Contoh:

```java
public Laptop(String idPerangkat, String merk,
              String tipe, String kerusakan) {
    super(idPerangkat, merk, tipe);
    this.kerusakan = kerusakan;
}
```

### 5. Inheritance

Inheritance diterapkan melalui hubungan:

```text
Perangkat
    ▲
    │
 Laptop
```

Contoh kode:

```java
public class Laptop extends Perangkat
```

### 6. ArrayList

`ArrayList` digunakan untuk menyimpan kumpulan object selama program berjalan.

---

## 🔄 16. Alur Program

Alur program secara sederhana adalah:

```mermaid
flowchart TD
    A([MULAI]) --> B[Tampilkan Menu]
    B --> C{Pilih Menu 1 - 6}

    C -->|1| D[Tambah Data Servis]
    C -->|2| E[Tampilkan Data Servis]
    C -->|3| F[Ubah Data Servis]
    C -->|4| G[Hapus Data Servis]
    C -->|5| H[Cari Data Servis]
    C -->|6| I([SELESAI])

    D --> B
    E --> B
    F --> B
    G --> B
    H --> B
```

```text
              MULAI
                │
                ▼
          Tampilkan Menu
                │
                ▼
        Pilih Menu 1 - 6
                │
       ┌────────┼────────┐
       │        │        │
       ▼        ▼        ▼
     Tambah   Tampil    Ubah
       │        │        │
       └────────┼────────┘
                │
       ┌────────┼────────┐
       │        │        │
       ▼        ▼        ▼
     Hapus    Cari     Keluar
       │        │        │
       └────────┘        ▼
             │         SELESAI
             ▼
        Kembali ke Menu
```

Program akan terus menampilkan menu sampai pengguna memilih pilihan **6. Keluar**.

---

## 📝 17. Kesimpulan

Program **Sistem Pengelolaan Servis Laptop** merupakan aplikasi berbasis Command Line Interface yang dibuat menggunakan bahasa pemrograman Java dengan menerapkan konsep Pemrograman Berorientasi Objek.

Program memiliki beberapa class, yaitu `Perangkat`, `Laptop`, `Pelanggan`, dan `Servis`, serta class utama `ManajemenServisLaptop`.

Penerapan inheritance dilakukan dengan menjadikan `Perangkat` sebagai superclass dan `Laptop` sebagai subclass. Class `Laptop` mewarisi atribut umum dari `Perangkat` dan memiliki atribut tambahan berupa `kerusakan`.

Selain inheritance, program juga menerapkan konsep class, object, constructor, encapsulation, ArrayList, percabangan, perulangan, CRUD, pencarian, dan validasi input.

Dengan adanya program ini, proses pengelolaan data pelanggan, laptop, dan servis dapat dilakukan melalui menu yang sederhana dan mudah digunakan.
