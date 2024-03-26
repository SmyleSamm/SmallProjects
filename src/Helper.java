package src;

import java.io.*;
import java.util.*;

public class Helper {
    public static String stringInput(){
        Scanner scan = new Scanner(System.in);
        String ans = scan.nextLine();
        scan.close();
        return ans;
    }
    public static int intInput(){
        int ans=-1;
        Scanner scan = new java.util.Scanner(System.in);
        try{
            ans = scan.nextInt();
        }
        catch(InputMismatchException e){
            System.out.println("Input is wrong!\nPlease enter an Integer e.g. 1,2,...");
        }
        finally{
            scan.nextLine();
            scan.close();
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
        }catch(InterruptedException e){

        }
    }
}
