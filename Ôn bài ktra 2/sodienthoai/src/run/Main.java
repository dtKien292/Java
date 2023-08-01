package run;

import controller.QLTV;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        QLTV q = new QLTV();
        String fname = "src/run/tailieu.dat";
        while(true){
            System.out.println("1. nhap sach");
            System.out.println("2. nhap bao");
            System.out.println("3. hien thi");
            System.out.println("4. luu vao file");
            System.out.println("5. doc vao file");
            System.out.println("6. xoa");
            System.out.println("7. sua");
            System.out.println("8. tim sach theo ten");
            System.out.println("9. tim bao tu nam den nam");
            System.out.println("10. sap xep theo so ban PH");
            System.out.println("11. sap xep theo ten TG");
            System.out.println("12. sap xep theo ngau PH va so ban");
            System.out.println("0. Thoat");
            System.out.println("Nhap 0-12");
            int choice;
            Scanner sc = new Scanner(System.in);
            choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 0 ->{
                    System.out.println("Bye!!!");
                    System.exit(0);
                }
                case 1 ->{
                    q.nhapSach();
                }
                case 2 ->{
                    q.nhapBao();
                }
                case 3 ->{
                    q.hienthiDS();
                }
                case 4 ->{
                    q.luu(fname);
                }
                case 5 ->{
                    q.docra(fname);
                }
                case 6 ->{
                    q.xoa();
                }
                case 7 ->{
                    q.sua();
                }
                case 8 ->{
                    q.timTheoTenSach();
                }
                case 9 ->{
                    q.timBaoTuDenNam();
                }
                case 10 ->{
                    q.sapxepSoBanPH();
                }
                case 11 ->{
                    q.sapxepSachTheoTenTG();
                }
                case 12 ->{
                    q.sapxepBaoTheo2TTinh();
                }
                default -> {
                    System.out.println("Ban chi chon 0-12");
                }
            }
        }
    }
}
