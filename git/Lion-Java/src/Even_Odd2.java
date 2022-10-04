import java.util.Scanner;

public class Even_Odd2 {

    public static String odd(int num){
        if(num % 2== 0)
            return "짝수";
        else
            return "홀수";
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = scan.nextInt();
        int num2 = scan.nextInt();

        System.out.println(odd(num) + " + " + odd(num2) + " = " + odd(num + num2));

    }
}
