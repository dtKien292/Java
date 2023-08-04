package model;

import java.io.Serializable;


/**
 *
 * @author ducmanh
 */
public class CongNhan implements Serializable {
    private int ma;
    private String hoten, diachi, sdt;
    private int bac;

    public CongNhan() {
    }

    public CongNhan(int ma, String hoten, String diachi, String sdt, int bac) {
        this.ma = ma;
        this.hoten = hoten;
        this.diachi = diachi;
        this.sdt = sdt;
        this.bac = bac;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
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
    
    public Object[] toObject() {
        return new Object[]{
            ma, hoten, diachi, sdt, bac
        };
    }
}
