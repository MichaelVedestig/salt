package chapter4;

import java.util.Scanner;

public class AvarageTestScores {

    public static void main(String args[]){

        int numberOfStudents = 4;
        int numberOfTests = 4;

        Scanner scanner = new Scanner(System.in);

        for(int i=0; i < numberOfStudents; i++){

            double total = 0;
            for(int j=0; j <numberOfTests; j++){
                System.out.println("Enter the score for Test #" + (j+1));
                double score = scanner.nextDouble();
                total += score;
            }
            double avarage = total/numberOfTests;
            System.out.println("The test avarage for student #" + (i+1)
             + " is " + avarage);
        }
        scanner.close();
    }
}
