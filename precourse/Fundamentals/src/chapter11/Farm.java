package chapter11;

public class Farm {

    public static void main(String args[]){

        Pig pig = new Pig();
        pig.makeSound();
        pig.eat(pig);

        Duck donald = new Duck();
        donald.makeSound();
        donald.eat(donald);
    }
}
