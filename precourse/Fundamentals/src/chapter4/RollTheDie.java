package chapter4;

import java.util.Random;

public class RollTheDie {

    public static void main(String args[]) {

        int space = 0;

        for (int i = 0; i < 5; i++) {
            Random random = new Random();
            int die = random.nextInt(6) + 1;
            space += die;
            if (space > 20) {
                System.out.println("Rolled too high. You lose");
                break;
            } else if (space < 20) {
                System.out.println("Roll #" + i + ": You've rolled a "
                        + die + ". You are now on space " + space +
                        " and have " + (20 - space) + " more to go.");
            } else if (space == 20) {
                System.out.println("Roll #" + i + ": You're rollad "
                        + die + ". You are now on space 20. You win!");
            }
        }
        if (space < 20)
        System.out.println("You ran out of rolls. You lose.");
    }
}
