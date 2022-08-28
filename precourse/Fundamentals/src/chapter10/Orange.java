package chapter10;

public class Orange extends Fruit{

    @Override
    public void makeJuice(Fruit orange){
        System.out.println("Freshly squeezed Orange juice");
    }

    public void peel(Fruit orange){
        System.out.println("Peels " + orange.getClass().getSimpleName());
    }
    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }


}
