package model;

public class IntlPhoneNumber extends PhoneNumber{
    private String maQG;
    public IntlPhoneNumber (){}
    public IntlPhoneNumber(String maQG,String maVung, String noiVung) {
        super(maVung, noiVung);
        this.maQG = maQG;
    }

    public String getMaQG() {
        return maQG;
    }

    public void setMaQG(String maQG) {
        this.maQG = maQG;
    }

    @Override
    public String toString() {
        return maQG + '-' + getMaVung() + '-' + getNoiVung();
    }
}
