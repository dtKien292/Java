package implement;

import Interface.IHoaDon;
import model.HoaDonBanSi;

public class HoaDonSI implements IHoaDon {
    public HoaDonBanSi HD = new HoaDonBanSi();
    @Override
    public double tinhTongTien() {
        if (HD.isThanhToan()) {
            return HD.getTongTien()*0.15;
        }else {
            return HD.getTongTien();
        }
    }
}
