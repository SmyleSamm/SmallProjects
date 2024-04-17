package src.SmyleGameEngine.SmyleTextAdventureLibary;

import java.io.*;
import java.util.*;

public class SGE {
    /**
     * A String reader to read a String from the User. 
     * @return String Input from the User.
     */
    public static String stringInput(){
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }
    /**
     * A function that returns a Integer Input from the User with Invalid Input handling.
     * @param min is the minumum value that is allowed to be entered by the user as a input.
     * @param max is the maximum value that is allowed to be entered by the user as a input.
     * @return returns an Integer between min and max with Invalid Input handling.
     */
    public static int intInput(int min, int max){
        Scanner scan = new Scanner(System.in);
        int ans=0;
        try{
            ans=scan.nextInt();
        }catch(Exception e){
            scan.nextLine();
            System.out.println("Invalid Input!\nPlease try again with a valid input.\nOnly numbers between "+min+" and "+max+"!");
            return intInput(min, max);
        }
        if(ans<min||ans>max){
            System.out.println("Input is not in range of "+min+" and "+max+"!\nPlease try again.");
            return intInput(min, max);
        }
        return ans;
    }
    /**
     * Clears the console.
     */
    public static void clear(){
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
