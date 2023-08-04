/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

public class SinhVien implements Serializable{
    private int ma;
    private String hoTen;
    private String ngaySinh;
    private String chuyenNganh;

    public SinhVien() {
    }

    public SinhVien(int ma, String hoTen, String ngaySinh, String chuyenNganh) {
        this.ma = ma;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.chuyenNganh = chuyenNganh;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getChuyenNganh() {
        return chuyenNganh;
    }

    public void setChuyenNganh(String chuyenNganh) {
        this.chuyenNganh = chuyenNganh;
    }
    
    public Object[] toObjects(){
        return new Object[]{
            ma,hoTen,ngaySinh,chuyenNganh
        };
    }
    
}
