import java.util.Scanner;

public class Even_Odd2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = scan.nextInt();
        int num2 = scan.nextInt();

        if(num % 2== 0)
            System.out.print("짝수");
        else
            System.out.print("홀수");

        System.out.print("+");

        if(num2 % 2== 0)
            System.out.print("짝수");
        else
            System.out.print("홀수");

        System.out.print("=");

        if((num+num2) %2==0)
            System.out.println("짝수");
        else
            System.out.println("홀수");
    }
}
