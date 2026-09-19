package com.mycompany.manajemenservislaptop;

import java.util.ArrayList;
import java.util.Scanner;
import model.Pelanggan;
import model.Laptop;
import model.Servis;

public class ManajemenServisLaptop {

    static Scanner input = new Scanner(System.in);

    static ArrayList<Pelanggan> daftarPelanggan = new ArrayList<>();
    static ArrayList<Laptop> daftarLaptop = new ArrayList<>();
    static ArrayList<Servis> daftarServis = new ArrayList<>();

    public static void main(String[] args) {

        int pilihan;

        do {

            System.out.println("\n==========================================");
            System.out.println("     SISTEM PENGELOLAAN SERVIS LAPTOP");
            System.out.println("==========================================");
            System.out.println("1. Tambah Data Servis");
            System.out.println("2. Tampilkan Data Servis");
            System.out.println("3. Ubah Data Servis");
            System.out.println("4. Hapus Data Servis");
            System.out.println("5. Cari Data Servis");
            System.out.println("6. Keluar");
            System.out.println("==========================================");

            pilihan = inputAngka("Pilih menu: ");

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
                    System.out.println("\nProgram selesai. Terima kasih!");
                    break;

                default:
                    System.out.println("\nMenu tidak tersedia!");
            }

        } while (pilihan != 6);

        input.close();
    }

    // ==============================
    // TAMBAH DATA SERVIS
    // ==============================

    public static void tambahDataServis() {

        System.out.println("\n=== TAMBAH DATA SERVIS ===");

        // Data Pelanggan
        String idPelanggan;

        do {
            System.out.print("ID Pelanggan : ");
            idPelanggan = input.nextLine();

            if (idPelanggan.isEmpty()) {
                System.out.println("ID Pelanggan tidak boleh kosong!");
            }

        } while (idPelanggan.isEmpty());

        if (cariIndexPelanggan(idPelanggan) != -1) {
            System.out.println("ID Pelanggan sudah digunakan!");
            return;
        }

        String nama;

        do {
            System.out.print("Nama Pelanggan : ");
            nama = input.nextLine();

            if (nama.isEmpty()) {
                System.out.println("Nama tidak boleh kosong!");
            }

        } while (nama.isEmpty());

        String noTelepon;

        do {
            System.out.print("No. Telepon : ");
            noTelepon = input.nextLine();

            if (noTelepon.isEmpty()) {
                System.out.println("No. Telepon tidak boleh kosong!");
            } else if (!noTelepon.matches("\\d+")) {
                System.out.println("No. Telepon hanya boleh berisi angka!");
            }

        } while (noTelepon.isEmpty() || !noTelepon.matches("\\d+"));

        String alamat;

        do {
            System.out.print("Alamat : ");
            alamat = input.nextLine();

            if (alamat.isEmpty()) {
                System.out.println("Alamat tidak boleh kosong!");
            }

        } while (alamat.isEmpty());

        // Data Laptop
        String idPerangkat;

        do {
            System.out.print("ID Laptop : ");
            idPerangkat = input.nextLine();

            if (idPerangkat.isEmpty()) {
                System.out.println("ID Laptop tidak boleh kosong!");
            }

        } while (idPerangkat.isEmpty());

        if (cariIndexLaptop(idPerangkat) != -1) {
            System.out.println("ID Laptop sudah digunakan!");
            return;
        }

        String merk;

        do {
            System.out.print("Merk Laptop : ");
            merk = input.nextLine();

            if (merk.isEmpty()) {
                System.out.println("Merk tidak boleh kosong!");
            }

        } while (merk.isEmpty());

        String tipe;

        do {
            System.out.print("Tipe Laptop : ");
            tipe = input.nextLine();

            if (tipe.isEmpty()) {
                System.out.println("Tipe tidak boleh kosong!");
            }

        } while (tipe.isEmpty());

        String kerusakan;

        do {
            System.out.print("Kerusakan : ");
            kerusakan = input.nextLine();

            if (kerusakan.isEmpty()) {
                System.out.println("Kerusakan tidak boleh kosong!");
            }

        } while (kerusakan.isEmpty());

        // Data Servis
        String idServis;

        do {
            System.out.print("ID Servis : ");
            idServis = input.nextLine();

            if (idServis.isEmpty()) {
                System.out.println("ID Servis tidak boleh kosong!");
            }

        } while (idServis.isEmpty());

        if (cariIndexServis(idServis) != -1) {
            System.out.println("ID Servis sudah digunakan!");
            return;
        }

        String tanggalMasuk;

        do {
            System.out.print("Tanggal Masuk : ");
            tanggalMasuk = input.nextLine();

            if (tanggalMasuk.isEmpty()) {
                System.out.println("Tanggal tidak boleh kosong!");
            }

        } while (tanggalMasuk.isEmpty());

        // Status
        int pilihanStatus;

        do {

            System.out.println("\nStatus Servis:");
            System.out.println("1. Menunggu");
            System.out.println("2. Diproses");
            System.out.println("3. Selesai");

            pilihanStatus = inputAngka("Pilih status: ");

            if (pilihanStatus < 1 || pilihanStatus > 3) {
                System.out.println("Pilihan status tidak tersedia!");
            }

        } while (pilihanStatus < 1 || pilihanStatus > 3);

        String status;

        if (pilihanStatus == 1) {
            status = "Menunggu";
        } else if (pilihanStatus == 2) {
            status = "Diproses";
        } else {
            status = "Selesai";
        }

        double biaya;

        do {
            biaya = inputDouble("Biaya Servis : Rp");

            if (biaya < 0) {
                System.out.println("Biaya tidak boleh negatif!");
            }

        } while (biaya < 0);

        // Membuat Object
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

        // Menyimpan Object ke ArrayList
        daftarPelanggan.add(pelanggan);
        daftarLaptop.add(laptop);
        daftarServis.add(servis);

        System.out.println("\nData servis berhasil ditambahkan!");
    }

    // ==============================
    // TAMPILKAN DATA
    // ==============================

    public static void tampilkanDataServis() {

        System.out.println("\n=== DATA SERVIS LAPTOP ===");

        if (daftarServis.isEmpty()) {
            System.out.println("Belum ada data servis.");
            return;
        }

        for (int i = 0; i < daftarServis.size(); i++) {

            Pelanggan pelanggan = daftarPelanggan.get(i);
            Laptop laptop = daftarLaptop.get(i);
            Servis servis = daftarServis.get(i);

            System.out.println("\n------------------------------------------");
            System.out.println("Data Servis ke-" + (i + 1));
            System.out.println("------------------------------------------");

            System.out.println("ID Servis      : " + servis.getIdServis());
            System.out.println("Tanggal Masuk  : " + servis.getTanggalMasuk());

            System.out.println("ID Pelanggan   : " + pelanggan.getIdPelanggan());
            System.out.println("Nama Pelanggan : " + pelanggan.getNama());
            System.out.println("No. Telepon    : " + pelanggan.getNoTelepon());
            System.out.println("Alamat         : " + pelanggan.getAlamat());

            System.out.println("ID Laptop      : " + laptop.getIdPerangkat());
            System.out.println("Merk Laptop    : " + laptop.getMerk());
            System.out.println("Tipe Laptop    : " + laptop.getTipe());
            System.out.println("Kerusakan      : " + laptop.getKerusakan());

            System.out.println("Status         : " + servis.getStatus());
            System.out.println("Biaya          : Rp" + servis.getBiaya());
        }
    }

    // ==============================
    // UBAH DATA
    // ==============================

public static void ubahDataServis() {

    System.out.println("\n=== UBAH DATA SERVIS ===");

    System.out.print("Masukkan ID Servis yang ingin diubah: ");
    String id = input.nextLine();

    int index = cariIndexServis(id);

    if (index == -1) {
        System.out.println("Data servis tidak ditemukan!");
        return;
    }

    Servis servis = daftarServis.get(index);

    System.out.println("\nData ditemukan!");
    System.out.println("Status saat ini : " + servis.getStatus());
    System.out.println("Biaya saat ini  : Rp" + servis.getBiaya());

    int pilihanStatus;

    do {
        System.out.println("\nStatus Baru:");
        System.out.println("1. Menunggu");
        System.out.println("2. Diproses");
        System.out.println("3. Selesai");

        pilihanStatus = inputAngka("Pilih status baru: ");

        if (pilihanStatus < 1 || pilihanStatus > 3) {
            System.out.println("Pilihan status tidak tersedia!");
        }

    } while (pilihanStatus < 1 || pilihanStatus > 3);

    String statusBaru;

    if (pilihanStatus == 1) {
        statusBaru = "Menunggu";
    } else if (pilihanStatus == 2) {
        statusBaru = "Diproses";
    } else {
        statusBaru = "Selesai";
    }

    double biayaBaru;

    do {
        biayaBaru = inputDouble("Biaya Baru : Rp");

        if (biayaBaru < 0) {
            System.out.println("Biaya tidak boleh negatif!");
        }

    } while (biayaBaru < 0);

    servis.setStatus(statusBaru);
    servis.setBiaya(biayaBaru);

    System.out.println("\nData servis berhasil diubah!");
}
    // ==============================
    // HAPUS DATA
    // ==============================

    public static void hapusDataServis() {

        System.out.println("\n=== HAPUS DATA SERVIS ===");

        System.out.print("Masukkan ID Servis yang ingin dihapus: ");
        String id = input.nextLine();

        int index = cariIndexServis(id);

        if (index == -1) {
            System.out.println("Data servis tidak ditemukan!");
            return;
        }

        System.out.print("Yakin ingin menghapus? (y/n): ");
        String konfirmasi = input.nextLine();

        if (konfirmasi.equalsIgnoreCase("y")) {

            daftarServis.remove(index);
            daftarPelanggan.remove(index);
            daftarLaptop.remove(index);

            System.out.println("Data servis berhasil dihapus!");

        } else {

            System.out.println("Data tidak jadi dihapus.");
        }
    }

    // ==============================
    // CARI DATA
    // ==============================

    public static void cariDataServis() {

        System.out.println("\n=== CARI DATA SERVIS ===");

        System.out.print("Masukkan ID Servis: ");
        String id = input.nextLine();

        int index = cariIndexServis(id);

        if (index == -1) {
            System.out.println("\nData servis tidak ditemukan!");
            return;
        }

        Pelanggan pelanggan = daftarPelanggan.get(index);
        Laptop laptop = daftarLaptop.get(index);
        Servis servis = daftarServis.get(index);

        System.out.println("\nData ditemukan!");
        System.out.println("------------------------------------------");

        System.out.println("ID Servis      : " + servis.getIdServis());
        System.out.println("Tanggal Masuk  : " + servis.getTanggalMasuk());

        System.out.println("ID Pelanggan   : " + pelanggan.getIdPelanggan());
        System.out.println("Nama Pelanggan : " + pelanggan.getNama());
        System.out.println("No. Telepon    : " + pelanggan.getNoTelepon());

        System.out.println("Laptop         : "
                + laptop.getMerk() + " " + laptop.getTipe());

        System.out.println("Kerusakan      : " + laptop.getKerusakan());
        System.out.println("Status         : " + servis.getStatus());
        System.out.println("Biaya          : Rp" + servis.getBiaya());
    }

    // ==============================
    // CARI INDEX SERVIS
    // ==============================

    public static int cariIndexServis(String id) {

        for (int i = 0; i < daftarServis.size(); i++) {

            if (daftarServis.get(i).getIdServis().equalsIgnoreCase(id)) {
                return i;
            }
        }

        return -1;
    }

    // ==============================
    // CARI INDEX PELANGGAN
    // ==============================

    public static int cariIndexPelanggan(String id) {

        for (int i = 0; i < daftarPelanggan.size(); i++) {

            if (daftarPelanggan.get(i).getIdPelanggan().equalsIgnoreCase(id)) {
                return i;
            }
        }

        return -1;
    }

    // ==============================
    // CARI INDEX LAPTOP
    // ==============================

    public static int cariIndexLaptop(String id) {

        for (int i = 0; i < daftarLaptop.size(); i++) {

            if (daftarLaptop.get(i).getIdPerangkat().equalsIgnoreCase(id)) {
                return i;
            }
        }

        return -1;
    }

    // ==============================
    // INPUT ANGKA
    // ==============================

    public static int inputAngka(String pesan) {

        while (true) {

            System.out.print(pesan);
            String teks = input.nextLine();

            try {

                return Integer.parseInt(teks);

            } catch (NumberFormatException e) {

                System.out.println("Input harus berupa angka!");
            }
        }
    }

    // ==============================
    // INPUT DOUBLE
    // ==============================

    public static double inputDouble(String pesan) {

        while (true) {

            System.out.print(pesan);
            String teks = input.nextLine();

            try {

                return Double.parseDouble(teks);

            } catch (NumberFormatException e) {

                System.out.println("Input harus berupa angka!");
            }
        }
    }
}