package chapter3;

import java.util.Scanner;

public class LoneQualifyer {

    public static void main(String arg[]){

        int minimumSalary = 30000;
        int minYears = 2;

        System.out.println("enter your salary");
        Scanner scanner = new Scanner(System.in);
        double salary = scanner.nextDouble();
        System.out.println("enter how long you have been employed");
        double years = scanner.nextDouble();

        if(salary >= minimumSalary){
            if(years >= minYears){
                System.out.println("Congrats, you are qualified for a loan");
            }
            else{
                System.out.println("Sorry, you must have worked for at least"
                + minYears + " years at the company to qualify");
            }
        }
        else
            System.out.println("Sorry, you must earn at least " + minimumSalary
            + " to qualify");
    }
}
