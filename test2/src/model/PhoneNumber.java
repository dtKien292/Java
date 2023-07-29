package model;

public class PhoneNumber {
    private String maVung;
    private String noiVung;

    public PhoneNumber() {
    }

    public PhoneNumber(String maVung, String noiVung) {
        this.maVung = maVung;
        this.noiVung = noiVung;
    }

    public String getMaVung() {
        return maVung;
    }

    public void setMaVung(String maVung) {
        this.maVung = maVung;
    }

    public String getNoiVung() {
        return noiVung;
    }

    public void setNoiVung(String noiVung) {
        this.noiVung = noiVung;
    }

    @Override
    public String toString() {
        return maVung +"-"+ noiVung ;
    }
}
