import javax.swing.*;
import java.sql.SQLOutput;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        MaTranVuong maTranVuong = new MaTranVuong();
        IntegerProcess integerProcess = new IntegerProcess();
        XuLy2SoThuc xuLy2SoThuc = new XuLy2SoThuc();
        Scanner sc = new Scanner(System.in);
        int choice = 1;
        while(choice!=0){
            choice=menu(sc);
            switch (choice){
                case 1->{
                    xuLy2SoThuc.input();
                }
//                case 2->{
//                    integerProcess.integerInput();
//                    System.out.println("So ban da nhap la: ");
//                }
                case 3->{
                    integerProcess.integerInput();
                }
                case 4->{
                    System.out.println("Tong cac chu so cua so la: ");
                    System.out.println(integerProcess.sumaryOfNumber());
                }
                case 5->{
                    if (integerProcess.isPalindromeNumber()){
                        System.out.println("So nay la so thuan nghich");
                    } else {
                        System.out.println("So nay khong phai so thuan nghich");
                    }
                }
                case 6->{
                    maTranVuong.matrixInput();
                }
                case 7->{
                    maTranVuong.tongHang();
                }
                case 8->{
                    maTranVuong.hieuMatranB();
                }
                default -> choice = 0;
            }
        }
    }
    private static int menu(Scanner sc){
        int choice;
        System.out.println("---------Menu------------");
        System.out.println("0.Thoat chuong trinh");
        System.out.println("1.Nhap vao 2 so thucj x va epsilon");
        System.out.println("2.Tinh sinx");
        System.out.println("3.Nhap 1 so nguyen");
        System.out.println("4.Viet tong cac chu so cua n");
        System.out.println("5.Kiem tra co phai so thuan nghich");
        System.out.println("6.Nhap ma tran vuong A");
        System.out.println("7.Dua ra tong cac hang cua ma tran A");
        System.out.println("8.Dua ra hieu cua 2 ma tran A-B");
        System.out.println("9.Tinh dinh thuc cua A");
        choice = sc.nextInt();
        return choice;
    }
}