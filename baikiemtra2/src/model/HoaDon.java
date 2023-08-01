package model;

import java.time.LocalDateTime;

public class HoaDon {
    private String ma;
    private String hoVaTen;
    private LocalDateTime ngayLap;
    private double tongTien;

    public HoaDon(String ma, String hoVaTen, LocalDateTime ngayLap, int tongTien) {
    }

    public HoaDon(String ma, String hoVaTen, double tongTien) {
        this.ma = ma;
        this.hoVaTen = hoVaTen;
        this.ngayLap = LocalDateTime.now();
        this.tongTien = tongTien;
    }

    public HoaDon() {
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public LocalDateTime getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(LocalDateTime ngayLap) {
        this.ngayLap = ngayLap;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

}
