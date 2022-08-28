package chapter12;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CollectionsDemo {

    public static void main(String args[]){
    //    setDemo();
//        listDemo();
//        queueDemo();
      mapDemo();
    }
    public static void setDemo(){
        Set<String> fruit = new HashSet();
        fruit.add("apple");
        fruit.add("lemon");
        fruit.add("banana");
        fruit.add("orange");
        fruit.add("lemon");

        System.out.println(fruit.size());
        System.out.println(fruit);

        var i = fruit.iterator();
        while (i.hasNext()){
            System.out.println(i.next());
        }
        for(String item: fruit){
            System.out.println(item);
        }
        fruit.forEach(x -> System.out.println(x));
        fruit.forEach((System.out::println));

    }
    public static void listDemo(){


    }
    public static void queueDemo(){

    }
    public static void mapDemo(){

        // Første parameter i put e "key" og andre e "value"
        Map<String, Integer> fruitCalories = new HashMap();
        fruitCalories.put("apple", 95);
        fruitCalories.put("lemon", 20);
        fruitCalories.put("banana", 105);
        fruitCalories.put("orange", 45);
        fruitCalories.put("lemon", 17);

        for(var entry: fruitCalories.entrySet()){
            System.out.println(entry.getValue());
        }
        fruitCalories.forEach((k, v) -> System.out.println("Fruit: "
                + k + "\nCalories: " + v));
    }
}
