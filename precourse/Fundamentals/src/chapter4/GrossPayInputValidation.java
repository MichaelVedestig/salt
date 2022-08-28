package chapter4;

import java.util.Scanner;

public class GrossPayInputValidation {

    public static void main(String arg[]){

        int rate = 15;
        int maxHours = 40;

        System.out.println("How many hours did you work this week?");
        Scanner scanner = new Scanner(System.in);
        double hoursWokred = scanner.nextDouble();

        while (hoursWokred > maxHours || hoursWokred < 1){
            System.out.println("invalid entry. hours must be between 1 and 40. Try again.");
            hoursWokred = scanner.nextDouble();
        }
        scanner.close();
        double gross = rate * hoursWokred;
        System.out.println("Gross pay: " + gross);
    }
}
