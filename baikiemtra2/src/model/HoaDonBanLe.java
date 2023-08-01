package model;

import java.time.LocalDateTime;

public class HoaDonBanLe extends HoaDon{
    private String sdt;

    public HoaDonBanLe() {
    }

    public HoaDonBanLe(String ma, String hoVaTen, double tongTien, String sdt) {
        super(ma, hoVaTen, tongTien);
        this.sdt = sdt;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    @Override
    public String toString() {
        return getMa()+"\t"+getHoVaTen()+"\t"+getNgayLap()+"\t"+getTongTien();
    }
}
