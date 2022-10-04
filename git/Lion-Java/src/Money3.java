import java.util.Scanner;

public class Money3 {
    public static void main(String[] args) {
        int[] num ={50000,10000,5000,1000,500,100,50,10};
        int money = 28760;

        int curr50000 = 50000;
        int curr10000 = 10000;
        int curr5000 = 5000;
        int curr1000 = 1000;
        int curr500 = 500;
        int curr100 = 100;
        int curr50 = 50;
        int curr10 = 10;

        System.out.println(curr50000+"원 : " + money/curr50000 + " 나머지 금액 :" + money%curr50000);
        money = money%curr50000;

        System.out.println(curr10000+"원 : " + money/curr10000 + " 나머지 금액 :" + money%curr10000);
        money = money%curr10000;

        System.out.println(curr5000+"원 : " + money/curr5000 + " 나머지 금액 :" + money%curr5000);
        money = money%curr5000;

        System.out.println(curr1000+"원 : " + money/curr1000 + " 나머지 금액 :" + money%curr1000);
        money = money%curr1000;

        System.out.println(curr500+"원 : " + money/curr500 + " 나머지 금액 :" + money%curr500);
        money = money%curr500;

        System.out.println(curr100+"원 : " + money/curr100 + " 나머지 금액 :" + money%curr100);
        money = money%curr100;

        System.out.println(curr50+"원 : " + money/curr50 + " 나머지 금액 :" + money%curr50);
        money = money%curr50;

        System.out.println(curr10+"원 : " + money/curr10 + " 나머지 금액 :" +money%curr10);
    }
}
