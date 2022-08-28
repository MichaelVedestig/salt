package chapter5;

import java.util.Scanner;

public class PhoneBillCalculator {

    public static void main(String arg[]){

        //ask for fee and minutes
        System.out.println("Enter the plan fee:");
        Scanner scanner = new Scanner(System.in);
        double fee = scanner.nextDouble();
        System.out.println("Enter the number of overage minutes:");
        double minutes = scanner.nextDouble();
        scanner.close();
        double overage = costOfOverage(minutes);
        double vat = calculateTax(fee, overage);
        System.out.println("Phone bill: \nPhone plan: " + fee
        + "\nOverage minutes: " + overage + "\nVAT: " + vat +
                "\nTotal: " + (fee + overage + vat));
        //charge 0.25 per minute
        //calculate 15% on the total cost, fee + minutes * 0.25
        //print out itemized bill
    }

    public static double calculateTax(double fee, double overage){

        double taxRate = 0.15;
        double vat = (fee + overage) * taxRate;
        return vat;
    }
    public static double costOfOverage(double minutes){

        double pricePerMin = 0.25;
        double overage = pricePerMin * minutes;
        return overage;
    }
}
