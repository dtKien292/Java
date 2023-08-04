/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

/**
 *
 * @author hoabo
 */
public class BangDiem implements Serializable{
    private SinhVien sinhVien;
    private MonHoc monHoc;
    private float diem;

    public BangDiem() {
    }

    public BangDiem(SinhVien sinhVien, MonHoc monHoc, float diem) {
        this.sinhVien = sinhVien;
        this.monHoc = monHoc;
        this.diem = diem;
    }

    public SinhVien getSinhVien() {
        return sinhVien;
    }

    public void setSinhVien(SinhVien sinhVien) {
        this.sinhVien = sinhVien;
    }

    public MonHoc getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(MonHoc monHoc) {
        this.monHoc = monHoc;
    }

    public float getDiem() {
        return diem;
    }

    public void setDiem(float diem) {
        this.diem = diem;
    }
    
    public Object[] toObjects(){
        return new Object[]{
            sinhVien.getMa(),sinhVien.getHoTen(),monHoc.getTenMon(),diem
        };
    }
    
}
