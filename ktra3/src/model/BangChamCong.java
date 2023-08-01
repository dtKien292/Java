package model;

import java.io.Serializable;

public class BangChamCong implements Serializable {
    private CongNhan congNhan;
    private XuongSanXuat xuongSanXuat;
    private int soNgayLamViec;

    public BangChamCong() {
    }

    public BangChamCong(CongNhan congNhan, XuongSanXuat xuongSanXuat, int soNgayLamViec) {
        this.congNhan = congNhan;
        this.xuongSanXuat = xuongSanXuat;
        this.soNgayLamViec = soNgayLamViec;
    }

    public CongNhan getCongNhan() {
        return congNhan;
    }

    public void setCongNhan(CongNhan congNhan) {
        this.congNhan = congNhan;
    }

    public XuongSanXuat getXuongSanXuat() {
        return xuongSanXuat;
    }

    public void setXuongSanXuat(XuongSanXuat xuongSanXuat) {
        this.xuongSanXuat = xuongSanXuat;
    }

    public int getSoNgayLamViec() {
        return soNgayLamViec;
    }

    public void setSoNgayLamViec(int soNgayLamViec) {
        this.soNgayLamViec = soNgayLamViec;
    }
    public Object[] toObjects(){
        return new Object[]{
                congNhan.getMa(),congNhan.getHoTen(),xuongSanXuat.getMa(),soNgayLamViec
        };
    }

}
