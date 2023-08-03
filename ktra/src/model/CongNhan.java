package model;

import java.io.Serializable;

public class CongNhan implements Serializable {
    private int ma;
    private String hoTen;
    private String diaChi;
    private String sdt;
    private int bac;

    public CongNhan() {
    }

    public CongNhan(int ma, String hoTen, String diaChi, String sdt, int bac) {
        this.ma = ma;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.bac = bac;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public int getBac() {
        return bac;
    }

    public void setBac(int bac) {
        this.bac = bac;
    }
    public Object[] toObjects(){
        return new Object[]{
          ma,hoTen,diaChi,sdt,bac
        };
    }
}
