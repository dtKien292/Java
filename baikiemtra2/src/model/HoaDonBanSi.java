package model;

import java.time.LocalDateTime;

public class HoaDonBanSi extends HoaDon{
    private boolean thanhToan;

    public HoaDonBanSi() {

    }

    public HoaDonBanSi(String ma, String hoVaTen,  double tongTien, boolean thanhToan) {
        super(ma, hoVaTen, tongTien);
        this.thanhToan = thanhToan;
    }

    public boolean isThanhToan() {
        return thanhToan;
    }

    public void setThanhToan(boolean thanhToan) {
        this.thanhToan = thanhToan;
    }

    @Override
    public String toString() {
        return getMa()+"\t"+getHoVaTen()+"\t"+getNgayLap()+"\t"+getTongTien();
    }
}
