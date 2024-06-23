package SmallProjects.showcase;

import SmallProjects.Helper;
import SmallProjects.Exception.IntInputException;

public class Guesser {
    private static boolean running;
    private static int won, loss;
    public static void main(String[] args) {
        running=true;
        won=0;
        loss=0;
        Helper.c();
        System.out.println("Welcome to the Guesser!");
        loop();
    }
    private static void loop(){
        while(running){
            System.out.println("Enter the maximum number!\n0 interupts the programm!");
            int ans = 0;
            try{
            ans = Helper.intInput();
        }catch(IntInputException e){
            Helper.c();
            System.out.println(e);
            loop();
        }
            Helper.c();
            if(ans==0){
                running=false;
                break;
            }
            int l = new java.util.Random().nextInt(ans+1);
            System.out.println("Your number is between and not includes 0 and "+(ans+1)+"! What number do you think it is?");
            int answer = 0;
            try{
                ans = Helper.intInput();
            }catch(IntInputException e){
                Helper.c();
                System.out.println(e);
                loop();
            }
            Helper.c();
            if(answer==l){
                System.out.println("You guessed correctly!");
                ++won;
            }
            else{
                System.out.println("You did not guess correctly T.T\nThe number was "+l);
                ++loss;
            }
            System.out.println("You have guessed "+won+" numbers correctly and "+loss+" numbers incorrectly!");
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){

            }
        }
        Helper.c();
        System.out.println("Have a great day!");
        src.Main.start();
    }
}
