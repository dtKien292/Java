package model;

import java.io.Serializable;

public class TaiLieu implements Serializable,Comparable<TaiLieu> {
    private  String ma,tenNXB;
    private int soBanPH;
    public TaiLieu(){
    }

    public TaiLieu(String ma, String tenNXB, int soBanPH) {
        this.ma = ma;
        this.tenNXB = tenNXB;
        this.soBanPH = soBanPH;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTenNXB() {
        return tenNXB;
    }

    public void setTenNXB(String tenNXB) {
        this.tenNXB = tenNXB;
    }

    public int getSoBanPH() {
        return soBanPH;
    }

    public void setSoBanPH(int soBanPH) {
        this.soBanPH = soBanPH;
    }

    public int compareTo(TaiLieu o){
        return soBanPH-o.getSoBanPH();
    }
}
