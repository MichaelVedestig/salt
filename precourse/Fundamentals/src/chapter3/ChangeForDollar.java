package chapter3;

import java.util.Scanner;

public class ChangeForDollar {

    public static void main(String arg[]){

        int penny = 1;
        int nickel = 5;
        int dimes = 10;
        int quarter = 25;

        System.out.println("Enter how many pennies you'd like");
        Scanner scanner = new Scanner(System.in);
        penny *= scanner.nextInt();
        System.out.println("Enter how many nickels you'd like");
        nickel *= scanner.nextInt();
        System.out.println("Enter how many dimes you'd like");
        dimes *= scanner.nextInt();
        System.out.println("Enter how many quarters you'd like");
        quarter *= scanner.nextInt();
        int total = penny + nickel + dimes + quarter;
        if(total == 100)
            System.out.println("you win!");
        else if (total < 100)
        System.out.println("You went under by: " + (100 - total) + " cents");
        else {
            System.out.println("you went over by ");
            if(total / 100 > 1)
            {
                int dollars = total / 100;
                System.out.println(dollars + " dollar(s)");
                if (total % 100 != 0)
                    System.out.println(" and");
            }
            int cents = total % 100;
            System.out.println(cents + " cents");
        }

    }
}
