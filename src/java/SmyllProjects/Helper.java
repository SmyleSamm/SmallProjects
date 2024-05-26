package src;

import java.io.*;
import java.util.*;

import src.Exception.IntInputException;

public class Helper {
    public static String stringInput(){
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }
    public static int intInput() throws IntInputException{
        int ans=0;
        Scanner scan = new java.util.Scanner(System.in);
        try{
            ans = scan.nextInt();
        }catch(InputMismatchException e){
            throw new src.Exception.IntInputException();
        }
        return ans;
    }
    public static int intInputInRange(int minNumber, int maxNumber){
        Scanner scan = new Scanner(System.in);
        int ans=0;
        IntInputException inputException = new src.Exception.IntInputException();
        try{
            try{
                ans=scan.nextInt();
                if(ans<minNumber||ans>maxNumber)
                    throw inputException;
            }catch(Exception e){
                throw inputException;
            }
        }catch(Exception e){
            scan.nextLine();
            System.out.println("Invalid Input!\nPlease try again with a valid input.\nNumbers between "+minNumber+" and "+maxNumber);
            return intInputInRange(minNumber, maxNumber);
        }
        return ans;
    }
    public static void c() {
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
    public static void delay(int i){
        try{
            Thread.sleep(i);
        }catch(InterruptedException e){}
    }
}
