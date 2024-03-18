package src;

import java.io.IOException;

public class Helper {
    public static String stringInput(){
        return new java.util.Scanner(System.in).nextLine();
    }
    public static int intInput(){
        return new java.util.Scanner(System.in).nextInt();
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
