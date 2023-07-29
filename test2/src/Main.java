

import implement.PhoneBookImp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PhoneBookImp phoneBookImp =new PhoneBookImp();
        while(true){
            System.out.println("1. Nhap sdt");
            System.out.println("2. Tim sdt theo ma vung");
            System.out.println("3. Liet ke tat ca cac sdt");
            System.out.println("4. Tinh tong so dt theo tung vung");
            System.out.println("5. Tim kiem theo duoi");
            System.out.println("6. Sap xep so dt");
            System.out.println("0. Thoat");
            System.out.println("Nhap 0-5");
            int choice;
            Scanner sc = new Scanner(System.in);
            choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 0 ->{
                    System.out.println("Bye!!!");
                    System.exit(0);
                }
                case 1 ->{
                    phoneBookImp.themSDT();
                }
                case 2 ->{
                    System.out.println(phoneBookImp.timSDT());
                }
                case 3 ->{
                    System.out.println(phoneBookImp.lietKeSDT());
                }
                case 4 ->{
                    System.out.println(phoneBookImp.tongSDT());
                }
                case 5 ->{
                    System.out.println(phoneBookImp.timTheoDuoi());
                }
                case 6 ->{
                    System.out.println(phoneBookImp.sapXepSDT());
                }
                default -> {
                    System.out.println("Ban chi chon 0-6");
                }
            }
        }
    }
}