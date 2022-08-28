package chapter14;

import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;

public class CoinTossGame {

    public static void main(String args[]){

        System.out.println("Enter name Player 1: ");
        Scanner scanner = new Scanner(System.in);
        Player player1 = new Player(scanner.next());
        System.out.println("Enter name Player 2: ");
        Player player2 = new Player(scanner.next());
        String guess = "";
        boolean valid;
        do{
            System.out.println("Enter guess, 'Heads' or 'Tails'");
            guess = scanner.next();
            if (guess.equals("Heads"))
                valid = true;
            else if (guess.equals("Tails"))
                valid = true;
            else{
                System.out.println("guess invalid, choose 'Heads' or 'Tails'");
                valid = false;
            }
        }while (!valid);
        if (guess.equals("Heads")){
            player1.setGuess(guess);
            player2.setGuess("Tails");
        }
        else{
            player1.setGuess(guess);
            player2.setGuess("Heads");
        }
        Coin coin = new Coin();
        coin.flip();
        String winner = coin.getSide();
        if (winner.equals(guess))
            System.out.println(player1.getName() + " wins!");
        else System.out.println(player2.getName() + " wins!");
    }
}
