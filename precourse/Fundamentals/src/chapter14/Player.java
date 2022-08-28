package chapter14;

public class Player {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public String getGuess() {
        return guess;
    }

    public void setGuess(String guess) {
        this.guess = guess;
    }

    private String guess;

    public Player(String name){

        this.name = name;
    }
}
