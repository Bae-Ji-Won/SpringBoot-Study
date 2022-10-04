import java.util.Scanner;


public class Money {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] num ={50000,10000,5000,1000,500,100,50,10};
        System.out.print("금액을 넣으세요 : ");
        int money = scan.nextInt();


        for(int i=0; i<num.length; i++){
            System.out.println(num[i]+"원 "+money / num[i]+"개");
            money = money%num[i];
        }
    }
}
