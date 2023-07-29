package model;

import java.io.Serializable;
import java.util.Calendar;

public class Bao extends TaiLieu implements ITaiLieu, Serializable {
    private String ngayPH;

    public Bao() {
    }

    public String getNgayPH() {
        return ngayPH;
    }

    public void setNgayPH(String ngayPH) {
        this.ngayPH = ngayPH;
    }

    public Bao(String ma, String tenNXB, String ngayPH, int soBanPH) {
        super(ma, tenNXB, soBanPH);
        this.ngayPH = ngayPH;
    }

    @Override
    public String getCode() {
        String c = getMa().toUpperCase()+ngayPH.substring(ngayPH.lastIndexOf("/")+1);
        return c;
    }
    public int getNam(){
        try {
            return Integer.parseInt(ngayPH.substring(ngayPH.lastIndexOf("/")+1));
        }catch (NumberFormatException e){
            Calendar c = Calendar.getInstance();
            return c.get(Calendar.YEAR);
        }
    }
    @Override
    public String toString() {
        return getMa()+"\t"+getTenNXB()+"\t"+ngayPH+"\t"+getSoBanPH();
    }
}
