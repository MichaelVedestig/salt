package chapter3;

import java.util.Scanner;

public class QuotaCalculator {

    public static void main(String arg[]){

        int quota = 10;

        System.out.println("enter nr of sales");
        Scanner scanner = new Scanner(System.in);
        int sales = scanner.nextInt();
        scanner.close();

        if(sales >= quota)
        {
            System.out.println("Congrats, you met the quota");
        }
        else
        {
            int lack = quota - sales;
            System.out.println("Sorry you were " + lack + " sales short of making the quota");
        }
    }
}
