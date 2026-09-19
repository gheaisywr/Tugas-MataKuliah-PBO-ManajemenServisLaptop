package model;

public class Perangkat {

    private String idPerangkat;
    private String merk;
    private String tipe;

    // Constructor
    public Perangkat(String idPerangkat, String merk, String tipe) {
        this.idPerangkat = idPerangkat;
        this.merk = merk;
        this.tipe = tipe;
    }

    // Getter dan Setter
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