package model;

import java.io.Serializable;

public class XuongSanXuat implements Serializable {
    private int ma;
    private String tenXuong;
    private int heSoCongViec;

    public XuongSanXuat() {
    }

    public XuongSanXuat(int ma, String tenXuong, int heSoCongViec) {
        this.ma = ma;
        this.tenXuong = tenXuong;
        this.heSoCongViec = heSoCongViec;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getTenXuong() {
        return tenXuong;
    }

    public void setTenXuong(String tenXuong) {
        this.tenXuong = tenXuong;
    }

    public int getHeSoCongViec() {
        return heSoCongViec;
    }

    public void setHeSoCongViec(int heSoCongViec) {
        this.heSoCongViec = heSoCongViec;
    }
    public Object[] toObjects(){
        return new Object[]{
          ma,tenXuong,heSoCongViec
        };
    }
}
