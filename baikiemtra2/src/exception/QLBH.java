package exception;

import Interface.IChucNang;
import model.HoaDon;
import model.HoaDonBanLe;
import model.HoaDonBanSi;

import java.util.*;

public class QLBH implements IChucNang {
    public Scanner sc = new Scanner(System.in);
    public ArrayList<HoaDonBanLe> HDBL = new ArrayList<>();
    public ArrayList<HoaDonBanSi> HDBS = new ArrayList<>();
    @Override
    public void nhapHoaDonSi() {
        System.out.println("Nhap hoa don ban si");
        String ma;
        while (true){

            System.out.println("Nhap ma:");
            ma = sc.nextLine();
            if(ma.matches("[NX][0-9]{2}")){
                System.out.println("Ma hop le");
                break;
            }else{
                System.out.println("Nhap lai");
            }
        }
        System.out.println("Nhap ten khach hang:");
        String ten = sc.nextLine();
        System.out.println("Nhap tong tien");
        double tongTien = sc.nextDouble();
        System.out.println("tra truoc nhap true, tra sau nhap false");
        boolean thanhToan ;
        thanhToan = sc.nextBoolean();
        sc.nextLine();
        HDBS.add(new HoaDonBanSi(ma,ten,tongTien,thanhToan));
    }

    @Override
    public void nhapHoaDonLe() {
        System.out.println("Nhap hoa don ban le");
        String ma;
        while (true){
            System.out.println("Nhap ma:");
            ma = sc.nextLine();
            if(ma.matches("[NX][0-9]{2}")){
                System.out.println("Ma hop le");
                break;
            }else{
                System.out.println("Nhap lai");
            }
        }
        System.out.println("Nhap ten khach hang:");
        String ten = sc.nextLine();
        System.out.println("Nhap tong tien");
        double tongTien = sc.nextDouble();
        sc.nextLine();
        System.out.println("Nhap so dien thoan");
        String sdt ;
        sdt = sc.nextLine();
        HDBL.add(new HoaDonBanLe(ma,ten,tongTien,sdt));
    }

    @Override
    public void in() {
        int tong = 0;
        for(HoaDonBanSi x : HDBS){
            System.out.println(x);
            tong+=1;
        }
        for(HoaDonBanLe x : HDBL){
            System.out.println(x);
            tong+=1;
        }
        System.out.println("Tong so hoa don la:"+tong);
    }

    @Override
    public void timKiem() {
        System.out.println("Nhap nam tu");
        int nam1 = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhap dem nam");
        int nam2 = sc.nextInt();
        for(HoaDonBanSi x : HDBS){
            if(x.getNgayLap().getYear() <= nam2 && x.getNgayLap().getYear() >= nam1 ){
                System.out.println(x);
            }
        }
        for(HoaDonBanLe x : HDBL){
            if(x.getNgayLap().getYear() <= nam2 && x.getNgayLap().getYear() >= nam1 ){
                System.out.println(x);
            }
        }
    }

    @Override
    public ArrayList<HoaDon> sapXep() {
        return null;
    }

    @Override
    public void tinhTong() {
        Set<Integer> tongTien = new HashSet<>();
        for(HoaDonBanSi x : HDBS){
            tongTien.add(x.getNgayLap().getYear());
        }
        for(HoaDonBanLe x : HDBL){
            tongTien.add(x.getNgayLap().getYear());
        }
        for (Integer y: tongTien){
            double sum =0;
            for(HoaDonBanSi x : HDBS){
                sum+=x.getTongTien();
            }
            for(HoaDonBanLe x : HDBL){
                sum+=x.getTongTien();
            }
            System.out.println("Tong tien nam "+y+"la "+sum);
        }
    }
}
