package model;

import java.io.Serializable;


/**
 *
 * @author ducmanh
 */
public class BangChamCong implements Serializable{
    private CongNhan congnhan;
    private Xuong xuong;
    private int songay;

    public BangChamCong() {
    }

    public BangChamCong(CongNhan congnhan, Xuong xuong, int songay) {
        this.congnhan = congnhan;
        this.xuong = xuong;
        this.songay = songay;
    }

    public CongNhan getCongnhan() {
        return congnhan;
    }

    public void setCongnhan(CongNhan congnhan) {
        this.congnhan = congnhan;
    }

    public Xuong getXuong() {
        return xuong;
    }

    public void setXuong(Xuong xuong) {
        this.xuong = xuong;
    }

    public int getSongay() {
        return songay;
    }

    public void setSongay(int songay) {
        this.songay = songay;
    }
    
    public String vietTK(){
        return congnhan.getMa() + ": "+ congnhan.getHoten();
    }
    public int getThuNhap(){
        return songay*xuong.getHeso()*140000;
    }
    
    public Object[] toObject(){
        return new Object[]{
            congnhan.getMa(), congnhan.getHoten(), 
            xuong.getMa(), songay
        };
    }
}
