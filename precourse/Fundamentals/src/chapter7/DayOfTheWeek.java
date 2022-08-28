package chapter7;

import java.util.Scanner;

public class DayOfTheWeek {

    public static void main(String[] args){

        String[] weekdays = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        System.out.println("Enter a number between 1 and 7");
        Scanner scanner = new Scanner(System.in);
        int day = scanner.nextInt();
        System.out.println("You entered #" + day + "\nwhich corresponds to "
        + weekdays[day - 1]);
    }
}
