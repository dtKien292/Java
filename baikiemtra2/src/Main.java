import exception.QLBH;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {QLBH QL = new QLBH();
        while(true){
            System.out.println("1. Nhap hoa don ban si");
            System.out.println("2. Nhap hoa don ban le");
            System.out.println("3. Viet ra danh sach");
            System.out.println("4. Tim kiem hoa don tu nam den nam");
            System.out.println("5. Sap xep theo ten");
            System.out.println("6. Dua ra tong tien tung nam");
            System.out.println("0. Thoat");
            System.out.println("Nhap 0-6");
            int choice;
            Scanner sc = new Scanner(System.in);
            choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 0 ->{
                    System.out.println("Bye!!!");
                    System.exit(0);
                }
                case 1 ->{
                    QL.nhapHoaDonSi();
                }
                case 2 ->{
                    QL.nhapHoaDonLe();                }
                case 3 ->{
                    QL.in();                }
                case 4 ->{
                    QL.timKiem();                }
                case 5 ->{
                    QL.sapXep();                }
                case 6 ->{
                    QL.tinhTong();                }
                default -> {
                    System.out.println("Ban chi chon 0-6");
                }
            }
        }
    }
}