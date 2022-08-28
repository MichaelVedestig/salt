package chapter12;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static chapter12.GradeBook.TestResults.getMakeUpGrades;
import static chapter12.GradeBook.TestResults.getOriginalGrades;

public class UpdatedGrades {

    public static void main(String args[]){

        Map<String, Integer> originalGrades = getOriginalGrades();
        Map<String, Integer> updatedGrades = getMakeUpGrades();

       for (var student : updatedGrades.entrySet()){
           Integer originalGrade = originalGrades.get(student.getKey());
           Integer makeUpGrade = updatedGrades.get(student.getKey());

           if (originalGrade < makeUpGrade) {
               originalGrades.put(student.getKey(), makeUpGrade);
           }
    }
        originalGrades.forEach((k, v) -> System.out.println(k + v));
    }

//    public static void main(String[] args) {
//        Map<String, Integer> gradeBook = getOriginalGrades();
//        Map<String, Integer> test2 = getMakeUpGrades();
//
//        for (var student : test2.entrySet()) {
//            Integer firstGrade = gradeBook.get(student.getKey());
//            Integer secondGrade = test2.get(student.getKey());
//
//            if (secondGrade > firstGrade) {
//                gradeBook.put(student.getKey(), secondGrade);
//            }
//
//        }
//        gradeBook.forEach((k, v) -> System.out.println(k + v));
//    }
}
