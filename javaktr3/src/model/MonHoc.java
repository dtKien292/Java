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
public class MonHoc implements Serializable{
    private int ma;
    private String tenMon;
    private int soTinChi;
    private String loai;

    public MonHoc() {
    }

    public MonHoc(int ma, String tenMon, int soTinChi, String loai) {
        this.ma = ma;
        this.tenMon = tenMon;
        this.soTinChi = soTinChi;
        this.loai = loai;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public int getSoTinChi() {
        return soTinChi;
    }

    public void setSoTinChi(int soTinChi) {
        this.soTinChi = soTinChi;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }
    
    public Object[] toObjects(){
        return new Object[]{
            ma,tenMon,soTinChi,loai
        };
    }
    
}
