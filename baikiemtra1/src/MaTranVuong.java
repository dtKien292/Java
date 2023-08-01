import java.util.ArrayList;
import java.util.Scanner;

public class MaTranVuong {
    private final Scanner sc = new Scanner(System.in);
    private int n;
    public int[][] mt1 = new int[10][10];
    public int[][] mt2 = new int[10][10];
    public void matrixInput(){
        System.out.println("Nhap canh cua ma tran: ");
        this.n = sc.nextInt();
        System.out.println("Nhap cho ma tran A :");
        for (int i=0;i<this.n;i++){
            for (int j=0;j<this.n;j++){
                this.mt1[i][j] = sc.nextInt();
            }
        }
    }
    public void tongHang(){
        for (int i=0;i<this.n;i++){
            int sum=0;
            System.out.print("Tong hang thu "+(i+1)+" la: ");
            for (int j=0;j<this.n;j++){
                sum+=mt1[i][j];
            }
            System.out.println(sum);
        }
    }
    public void hieuMatranB(){
        int[][] mt3 = new int[n][n];
        System.out.println("Nhap cho ma tran b :");
        for (int i=0;i<this.n;i++){
            for (int j=0;j<this.n;j++){
                this.mt2[i][j] = sc.nextInt();
            }
        }
        System.out.println("Hieu ma tran A-B la: ");
        for (int i=0;i<this.n;i++){
            for (int j=0;j<this.n;j++){
                mt3[i][j] = this.mt1[i][j] - this.mt2[i][j];
            }
        }
        System.out.println("Hieu ma tran A-B la:");
        for (int i=0;i<this.n;i++){
            for (int j=0;j<this.n;j++){
                System.out.print(mt3[i][j]+" ");
            }
            System.out.println();
        }
    }
}
