package model;

public class Servis {

    private String idServis;
    private String tanggalMasuk;
    private String status;
    private double biaya;

    // Constructor
    public Servis(String idServis, String tanggalMasuk, String status, double biaya) {
        this.idServis = idServis;
        this.tanggalMasuk = tanggalMasuk;
        this.status = status;
        this.biaya = biaya;
    }

    // Getter dan Setter
    public String getIdServis() {
        return idServis;
    }

    public void setIdServis(String idServis) {
        this.idServis = idServis;
    }

    public String getTanggalMasuk() {
        return tanggalMasuk;
    }

    public void setTanggalMasuk(String tanggalMasuk) {
        this.tanggalMasuk = tanggalMasuk;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getBiaya() {
        return biaya;
    }

    public void setBiaya(double biaya) {
        this.biaya = biaya;
    }
}