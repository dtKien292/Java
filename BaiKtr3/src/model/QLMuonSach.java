/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author hoabo
 */
public class QLMuonSach implements Serializable{
    private Sach sach;
    private BanDoc banDoc;
    private boolean tinhTrang;
    private ArrayList<Integer> maSachMuon ;

    public QLMuonSach() {
    }

    public QLMuonSach(Sach sach, BanDoc banDoc, boolean tinhTrang, ArrayList<Integer> maSachMuon) {
        this.sach = sach;
        this.banDoc = banDoc;
        this.tinhTrang = tinhTrang;
        this.maSachMuon = maSachMuon;
    }

    

    public Sach getSach() {
        return sach;
    }

    public void setSach(Sach sach) {
        this.sach = sach;
    }

    public BanDoc getBanDoc() {
        return banDoc;
    }

    public void setBanDoc(BanDoc banDoc) {
        this.banDoc = banDoc;
    }

    public boolean isTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public ArrayList<Integer> getMaSachMuon() {
        return maSachMuon;
    }

    public void setMaSachMuon(ArrayList<Integer> maSachMuon) {
        this.maSachMuon = maSachMuon;
    }
    
    public Object[] toObjects(){
        return new Object[]{
            banDoc.getMa(),banDoc.getTen(),maSachMuon 
        };
    }
    
}
