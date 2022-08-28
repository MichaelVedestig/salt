package chapter13;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

public class ExceptionHandling {

    public static void main(String args[]){

       // createNewFile();
        numbersExceptionHandling();
    }
    public static void numbersExceptionHandling(){
        File file = new File("arne/bjarne.txt");
        try(Scanner filereader = new Scanner(file);){

            while (filereader.hasNext()){
                double num = filereader.nextDouble();
                System.out.println(num);
            }
        }catch (FileNotFoundException | InputMismatchException e){
             e.printStackTrace();
        }
        }
    public static void createNewFile(){
        File file = new File("arne/bjarne.txt");
        try{
            file.createNewFile();
        }catch (Exception e){
            System.out.println("directory does not exist.");
            e.printStackTrace();
        }

    }
}
