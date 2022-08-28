package chapter5;

import java.util.Scanner;

public class InstantCreditCheck {

    static int reqSalary = 25000;
    static int reqCreditScore = 700;
    static Scanner scanner = new Scanner(System.in);


    public static void main(String arg[]){

        int salary = getSalary();
        int creditScore = getCreditScore();
        scanner.close();
        boolean qualified = isUserQualified(salary, creditScore);
        notifyUser(qualified);
    }

    public static void notifyUser(boolean isQualified){
        if(isQualified)
            System.out.println("Credit checks out!");
        else
            System.out.println("you're credit sucks");
    }
    public static int getCreditScore(){

        System.out.println("Enter your credit score");
        int creditScore = scanner.nextInt();
        return creditScore;
    }
    public static int getSalary(){
        System.out.println("Enter your salary");
        int salary = scanner.nextInt();
        return salary;
    }
    public static boolean isUserQualified(int salary, int creditScore){
        if (creditScore >= reqCreditScore && salary >= reqSalary)
            return true;
        else
            return false;
    }
}
