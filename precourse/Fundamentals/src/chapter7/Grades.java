package chapter7;

import java.util.Scanner;

public class Grades {

    private static int grades[];
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){

        System.out.println("how many grades would you like to enter?");
        grades = new int[scanner.nextInt()];
        getGrades();
        System.out.println("Avarage: " + String.format("%.2f", calculateAvarage()));
        System.out.println("Lowest " + getLowest());
        System.out.println("Highest " + getHighest());
    }

    public static void getGrades(){

        for (int i=0; i<grades.length; i++){
            System.out.println("Enter grade #" + (i +1));
            grades[i] = scanner.nextInt();
        }
    }
    public static int calculateSum(){
        int sum = 0;
        for(int grade : grades){
            sum += grade;
        }
        return sum;
    }

    public static double calculateAvarage(){
        return calculateSum() / grades.length;
    }

    public static int getHighest(){
        int highest = grades[0];
        for(int grade: grades){
            if(grade > highest)
                highest = grade;
        }
        return highest;
    }

    public static int getLowest(){
        int lowest = grades[0];
        for(int grade: grades){
            if(grade < lowest)
                lowest = grade;
        }
        return lowest;
    }
}
