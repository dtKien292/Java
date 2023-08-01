package implement;

import Interface.IHoaDon;
import model.HoaDonBanLe;

public class HoaDonLe implements IHoaDon {
    public HoaDonBanLe HD = new HoaDonBanLe();
    @Override
    public double tinhTongTien() {
        if (HD.getSdt().substring(HD.getSdt().length() - 2).equals("66")){
            return HD.getTongTien()*9/10;
        }
        return HD.getTongTien();
    }
}
