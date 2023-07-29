import java.util.Scanner;
public class IntegerProcess {
    public int n;
    private final Scanner sc = new Scanner(System.in);
    public void integerInput(){
        System.out.println("Nhap so nguyen n: ");
        this.n= sc.nextInt();
    }
    public int sumaryOfNumber(){
        int sum=0;
        int number = n;
        while (number>0){
            int digit = number%10;
            sum += digit;
            number/=10;
        }
        return sum;
    }
    public boolean isPalindromeNumber(){
        int number = this.n;
        int originalNumber = number;
        int reversedNumber = 0;
        while (number>0){
            int digit = number%10;
            reversedNumber = reversedNumber *10 + digit;
            number/=10;
        }
        return originalNumber==reversedNumber;
    }
}
