package chapter3;

import java.util.Scanner;

public class GradeMessage {

    public static void main(String args[]){

        System.out.println("enter your grade");
        Scanner scanner = new Scanner(System.in);
        String grade = scanner.next();

        String message;

        switch (grade){
            case "A":
                message = "excellent work";
                break;
            case "B":
                message = "great job";
                break;
            case "C":
                message = "good job";
                break;
            case "D":
                message = "work harder";
                break;
            case "F":
                message = "fucking loser";
                break;
            default:
                message = "invalid grade entered";
                break;
        }
        System.out.println("" + message);
    }
}
