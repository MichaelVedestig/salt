package chapter10;

public class Lemon extends Fruit{

    @Override
    public void makeJuice(Fruit lemon){
        System.out.println("Freshly squeezed lemon juice");
    }
    public void slice(Fruit lemon){
        String fruit = lemon.getClass().getSimpleName();
        System.out.println("Slices " + fruit + " into pieces");
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }
}
