package chapter10;

public class Cat extends Animal{

    @Override
    public void makeSound(){
        System.out.println("Meow!");
    }

    public void scratch(){
        System.out.println("Cat used Scratch, it's super effective!");
    }
}
