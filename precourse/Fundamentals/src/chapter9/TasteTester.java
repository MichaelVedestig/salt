package chapter9;

public class TasteTester {

    public static void main(String args[]){

        WeddingCake bryllup = new WeddingCake();
        bryllup.setTiers(4);
        bryllup.setFlavor("lemon");
        bryllup.setPrice(300);
        BirthdayCake grats = new BirthdayCake();
        grats.setCandles(32);
        grats.setPrice(200);
        grats.setFlavor("chocolate");
        Cake basicAssCake = new Cake();
        basicAssCake.setFlavor("vanilla");
        basicAssCake.setPrice(100);

        System.out.println(basicAssCake.flavor + basicAssCake.price);
        System.out.println(grats.flavor + grats.candles + grats.price);
        System.out.println(bryllup.flavor + grats.candles + grats.price);
    }
}
