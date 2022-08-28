package chapter14;

import java.util.Random;

public class Coin {

    public String getSide() {
        return side;
    }

    public Coin(){
        side = "";
    }
    public void setSide(String side) {
        this.side = side;
    }

    private String side;

    final String HEADS = "Heads";
    final String TAILS = "Tails";

    public void flip(){

        Random coinToss = new Random();

        int result = coinToss.nextInt(2);
        if (result > 0)
        {
            setSide(HEADS);
            System.out.println("Coin lands on Heads!");
        }
        else {
            setSide(TAILS);
            System.out.println("Coin lands on Tails!");
        }
    }
}
