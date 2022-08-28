package chapter10;

public class Market {

    public static void main(String args[]){

        Orange appelsin = new Orange();
        appelsin.setCalories(100);
        appelsin.peel(appelsin);
        appelsin.makeJuice(appelsin);

        Fruit sitron = new Lemon();
        ((Lemon) sitron).setCalories(50);
        ((Lemon) sitron).slice(sitron);
        sitron.makeJuice(sitron);

        sitron = new Orange();
        ((Orange) sitron).peel(sitron);
        ((Orange) sitron).setCalories(70);


        double smoothy = appelsin.getCalories() + ((Orange) sitron).getCalories();
        System.out.println("the smoothy contains " + smoothy + " calories");

    }
}
