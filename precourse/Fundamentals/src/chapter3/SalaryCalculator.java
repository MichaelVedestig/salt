package chapter3;

import java.util.Scanner;

public class SalaryCalculator {

    public static void main(String arg[]){

        int salary = 1000;
        int bonus = 250;

        System.out.println("How many sales did you make?");
        Scanner scanner = new Scanner(System.in);
        int sales = scanner.nextInt();
        scanner.close();
        if(sales > 10){
            salary += bonus;
        }
        System.out.println("your salary this week is " + salary);
    }
}
