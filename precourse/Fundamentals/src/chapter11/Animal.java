package chapter11;

public abstract class Animal {

    abstract void makeSound();

    void eat(Animal dyr){
        System.out.println(dyr.getClass().getSimpleName() + " munches");
    }
}
