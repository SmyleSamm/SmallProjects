package SmallProjects.showcase;

import SmallProjects.Helper;

public class Guesser {
    private boolean running;
    private int won, loss;
    public static void main(String[] args) {
        Helper.c();
        System.out.println("Welcome to the Guesser!");
        new Guesser();
    }
    public Guesser(){
        this.running=true;
        this.won=0;
        this.loss=0;
        loop();
        Helper.c();
        System.out.println("Have a greate day!");
        SmallProjects.Main.start();
    }
    private void loop(){
        while(running){
            int maxNumbers = askMaxNumbers();
            System.out.println("The random number is between 0 and "+maxNumbers);
            int playerGuess = letThePlayerGuess(maxNumbers);
            checkIfPlayerGuessedCorrectls(playerGuess, maxNumbers);
            printStatistics();
            this.running = playAgain();
        }
    }
    private int askMaxNumbers(){
        Helper.c();
        System.out.println("Choose the maximum numbers you want!");
        return Helper.intInputInRange(2, Integer.MAX_VALUE);
    }
    private int letThePlayerGuess(int maxValue){
        Helper.c();
        System.out.println("Please enter a number you think is the correct number!");
        return Helper.intInputInRange(0, maxValue);
    }
    private void checkIfPlayerGuessedCorrectls(int playerGuess, int maxValue){
        int num = new java.util.Random().nextInt(maxValue);
        Helper.c();
        if(playerGuess == num){
            System.out.println("You guessed correctly!");
            this.won++;
        }else{
            System.out.println("Your guessed incorrectly :(");
            System.out.println("The correct number was: "+num);
            this.loss++;
        }
    }
    private void printStatistics(){
        Helper.c();
        System.out.println("Statistics:");
        System.out.println("Won: "+this.won);
        System.out.println("Loss: "+this.loss);
        System.out.println("Percentage of wins: "+((double)((double)this.won/(double)(this.won+this.loss))*100)+"%");
    }
    private boolean playAgain(){
        System.out.println("Do you want to play again?");
        System.out.println("1. Yes");
        System.out.println("0. No");
        return Helper.intInputInRange(0, 1) == 1;
    }
}