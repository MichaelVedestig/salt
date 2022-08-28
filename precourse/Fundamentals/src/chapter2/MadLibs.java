package chapter2;

import java.util.Scanner;

public class MadLibs {

    public static void main(String arg[]){

        System.out.println("Please enter an adjective");
        Scanner scanner = new Scanner(System.in);
        String adjective = scanner.next();
        System.out.println("Please enter a season of the year");
        String season = scanner.next();
        System.out.println("Please enter a whole number.");
        int number = scanner.nextInt();
        scanner.close();

    System.out.println("On a " + adjective + " " + season + " day, I drink a minimum of " + number + " cups of coffee.");
    }


}
