package controller;

import model.Bao;
import model.ChucNang;
import model.Sach;
import model.TaiLieu;

import java.util.*;

public class QLTV implements ChucNang  {
    private List<TaiLieu> list;
    private Scanner sc = new Scanner(System.in);
    public QLTV() {
        list = new ArrayList<>();
    }

    public void setList(List<TaiLieu> list) {
        this.list = list;
    }

    // tim tai lieu theo ma - tra ve vi tri
    private int timViTri(String ma){
        for (int i = 0;i< list.size();i++){
            if(list.get(i).getMa().equalsIgnoreCase(ma)){
                return i;
            }
        }
        return -1;
    }
    private TaiLieu nhap(){
        String ma ,tenNXB;
        int soPH;
        String re = "[ABCD]{1}\\d{3}";
        while(true) {
            try {
                System.out.print("Ma: ");
                ma = sc.nextLine().toUpperCase();
                if (timViTri(ma) == -1 && ma.matches(re)) {
                    break;
                } else {
                    throw new VaildException("Ma bi trung hoac khong dung dinh dang");
                }
            } catch (VaildException e) {
                System.err.println(e);
            }
        }
        System.out.print("Ten NXB: ");
        tenNXB = sc.nextLine();
        while (true){
            try {
                System.out.print("so ban PH: ");
                soPH = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e){
                System.err.println(e);
            }
        }
        return  (new TaiLieu(ma, tenNXB, soPH));
    }
    public void nhapSach(){
        TaiLieu t =nhap();
        String tenTG,tenSach;
        int soTrang;
        System.out.print("Ten Sach: ");
        tenSach = sc.nextLine();
        System.out.print("Ten tac gia: ");
        tenTG = sc.nextLine();
        while (true){
            try {
                System.out.print("so trang: ");
                soTrang = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e){
                System.err.println(e);
            }
        }
        list.add(new Sach(t.getMa(),t.getTenNXB(),t.getSoBanPH(),tenTG,tenSach,soTrang));
    }
    public void nhapBao(){
        TaiLieu t =  nhap();
        String ngay;
        String re = "\\d{1,2}/\\d{1,2}/\\d{4}";
        while(true) {
            try {
                System.out.print("Ngay phat hanh : ");
                ngay = sc.nextLine();
                if (ngay.matches(re)) {
                    break;
                } else {
                    throw new VaildException("Ngay PH khong dung dinh dang");
                }
            } catch (VaildException e) {
                System.err.println(e);
            }
        }
        list.add(new Bao(t.getMa(),t.getTenNXB(),ngay,t.getSoBanPH()));
    }
    public void hienthiDS(){
        for(TaiLieu t:list){
            System.out.println(t);
        }
        System.out.println("-------------");
        System.out.println("Tong: "+list.size());
    }

    @Override
    public void luu(String fname) {
        IOFile.write(fname,list);
    }

    @Override
    public void docra(String fname) {
        setList(IOFile.read(fname));
    }

    @Override
    public void xoa() {
        System.out.println("Nhao vao ma can xoa");
        String ma = sc.nextLine();
        int vt = timViTri(ma);
        if( vt ==-1){
            System.out.println("Khong tim thay ma can xoa");
        } else {
            System.out.println("Tai lieu xoa: "+ list.remove(vt));
            System.out.println("Xoa thanh cong!!");
        }
    }

    @Override
    public void sua() {
        System.out.println("Nhao vao ma can xoa");
        String ma = sc.nextLine();
        int vt = timViTri(ma);
        if( vt ==-1){
            System.out.println("Khong tim thay ma can sua !!!");
        } else {
            TaiLieu t = list.get(vt);
            System.out.println("Nhap ten NXB: ");
            String tenNXB = sc.nextLine();
            int soPH;
            while (true){
                try{
                    System.out.println("So ban PH: ");
                    soPH = Integer.parseInt(sc.nextLine());
                    break;
                }catch (NumberFormatException e){
                    System.err.println(e);
                }
            }
            t.setTenNXB(tenNXB);
            t.setSoBanPH(soPH);
            if (t instanceof Sach){
                String tenTG, tenSach;
                int soTrang;
                System.out.println("Ten Sach: ");
                tenSach = sc.nextLine();
                System.out.println("Ten TG: ");
                tenTG = sc.nextLine();
                while(true){
                    try{
                        System.out.println("So trang: ");
                        soTrang = Integer.parseInt(sc.nextLine());
                        break;
                    } catch(NumberFormatException e){
                        System.err.println(e);
                    }
                }
                ((Sach) t).getTenTG();
                ((Sach) t).setTenTG(tenTG);
                ((Sach) t).setSoTrang(soTrang);
            }
            if (t instanceof Bao ){
                String ngay;
                String re = "\\d{1,2}/\\d{1,2}/\\d{4}";
                while(true) {
                    try {
                        System.out.print("Ngay phat hanh : ");
                        ngay = sc.nextLine();
                        if (ngay.matches(re)) {
                            break;
                        } else {
                            throw new VaildException("Ngay PH khong dung dinh dang");
                        }
                    } catch (VaildException e) {
                        System.err.println(e);
                    }
                }
                ((Bao)t).setNgayPH(ngay);
            }
            System.out.println("Sua thanh cong");
        }
    }

    @Override
    public void timTheoTenSach() {
        List<Sach> sach = new ArrayList<>();
        for (TaiLieu i : list){
            if (i instanceof  Sach){
                sach .add((Sach)i);
            }
        }
        System.out.println("Nhap ten sach can tim: ");
        String ten = sc.nextLine();
        int k = 0;
        for(Sach i : sach){
            if(i.getTenTG().toLowerCase().indexOf(ten.toLowerCase())>=0){
                System.out.println(i);
                k++;
            }
        }
        if(k==0){
            System.out.println("Khong tim thay cuon nao!");
        }
        else{
            System.out.println("Tong tim thay: "+k);

        }
    }

    @Override
    public void timBaoTuDenNam() {
        List<Bao> bao = new ArrayList<>();
        for (TaiLieu i : list){
            if (i instanceof  Bao){
                bao.add((Bao)i);
            }
        }
        try{
            System.out.println("Nhap tu nam : ");
            int nam1 = Integer.parseInt(sc.nextLine());
            System.out.println("Nhap den nam : ");
            int nam2 = Integer.parseInt(sc.nextLine());
            int k =0 ;
            for(Bao i : bao){
                if (i.getNam()>= nam1 && i.getNam()<=nam2){
                    System.out.println(i);
                    k++;
                }
            }
            if(k==0){
                System.out.println("Khong tim thay ");
            }
            else {
                System.out.println("Tong so sach: "+k);
            }
        } catch (NumberFormatException e){
            System.err.println(e);
        }
    }

    @Override
    public void sapxepSoBanPH() {
        Collections.sort(list);
        hienthiDS();
    }

    @Override
    public void sapxepSachTheoTenTG() {
        List<Sach> sach = new ArrayList<>();
        for (TaiLieu i : list){
            if (i instanceof  Sach){
                sach .add((Sach)i);
            }
        }
        sach.sort(new Comparator<Sach>() {
            @Override
            public int compare(Sach o1, Sach o2) {
                String ten1 = o1.getTenTG();
                String ten2 = o2.getTenTG();
                String t1 = ten1.substring(ten1.lastIndexOf(" ")+1)+ten1;
                String t2 = ten2.substring(ten2.lastIndexOf(" ")+1)+ten2;
                return t1.compareToIgnoreCase(t2);
            }
        });
        for(Sach i:sach){
            System.out.println(i);
        }
        System.out.println("tong: "+sach.size());
    }

    @Override
    public void sapxepBaoTheo2TTinh() {
        List<Bao> bao = new ArrayList<>();
        for (TaiLieu i : list){
            if (i instanceof  Bao){
                bao.add((Bao)i);
            }
        }
        bao.sort(new Comparator<Bao>() {
            @Override
            public int compare(Bao o1, Bao o2) {
                StringTokenizer n1 = new StringTokenizer(o1.getNgayPH());
                StringTokenizer n2 = new StringTokenizer(o2.getNgayPH());
                String ng1="";
                while(n1.hasMoreTokens()){
                    ng1 = n1.nextToken()+ng1;
                }
                String ng2="";
                while(n2.hasMoreTokens()){
                    ng2 = n2.nextToken()+ng2;
                }
                if (ng1.equalsIgnoreCase(ng2)){
                    return o1.getSoBanPH()-o2.getSoBanPH();
                }else{
                    return ng1.compareToIgnoreCase(ng2);
                }
            }
        });
        for(Bao i:bao){
            System.out.println(i);
        }
        System.out.println("tong: "+bao.size());
    }

    @Override
    public void thongke1() {

    }

    @Override
    public void thongke2() {

    }
}
