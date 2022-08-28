package chapter6;

import java.util.Scanner;

public class PhoneBill {

    private int id;
    private double baseCost;
    private double allottedMinutes;
    private double minutesUsed;

    public PhoneBill(){

        id = 0;
        baseCost = 0;
        allottedMinutes = 0;
        minutesUsed = 0;
    }

    public PhoneBill(int id){
        setID(id);
    }
    public PhoneBill(int id, double baseCost, double allottedMinutes, double minutesUsed){
        this.id = id;
        this.baseCost = baseCost;
        this.allottedMinutes = allottedMinutes;
        this.minutesUsed = minutesUsed;
    }
    public void setID(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public double calculateOverage(double allottedMinutes, double minutesUsed){

        double overageRate = 0.25;

        if(allottedMinutes < minutesUsed)
            return (minutesUsed - allottedMinutes) * overageRate;
        else
            return 0;
    }

    public double calculateTax(double baseCost, double overage){

        double taxRate = 0.15;
        return (baseCost + overage) * taxRate;
    }

    public double calculateTotal(double baseCost, double overage, double tax){
        return baseCost + overage + tax;
    }
    public PhoneBill getBill(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your customer ID: ");
        int id = scanner.nextInt();
        System.out.println("Enter the base cost: ");
        double baseCost = scanner.nextDouble();
        System.out.println("Enter number of allotted minutes: ");
        double allottedMinutes = scanner.nextDouble();
        System.out.println("Enter number of minutes used");
        double minutesUsed = scanner.nextDouble();
        scanner.close();
        return new PhoneBill(id, baseCost, allottedMinutes, minutesUsed);
    }
    public void printBill(){

        double overage = calculateOverage(allottedMinutes, minutesUsed);
        double tax = calculateTax(baseCost, overage);
        double total = calculateTotal(baseCost, overage, tax);
        System.out.println("Customer ID: " + id + "\nBase cost: " +
                baseCost + "\nOverage: " + overage + "\nTax: " + tax +
                "\nTotal: " + total);
    }
}
