package model;

public class Laptop extends Perangkat {

    private String kerusakan;

    // Constructor
    public Laptop(String idPerangkat, String merk, String tipe, String kerusakan) {
        super(idPerangkat, merk, tipe);
        this.kerusakan = kerusakan;
    }

    // Getter dan Setter
    public String getKerusakan() {
        return kerusakan;
    }

    public void setKerusakan(String kerusakan) {
        this.kerusakan = kerusakan;
    }
}