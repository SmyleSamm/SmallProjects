package src.showcase;

import src.Helper;

public class Calculator {
    private static boolean running;
    private static int num1, num2;
    public static void main(String[] args) {
        running=true;
        Helper.c();
        System.out.println("Welcome to the Calculator!");
        loop();
    }
    public static void loop(){
        while(running){
            System.out.println("What shall be the first number?");
            num1=Helper.intInput();
            Helper.c();
            System.out.println("What shall be the second number?");
            num2=Helper.intInput();
            Helper.c();
            
        }
        System.out.println("Have a great day!");
    }
    private static int addition(){
        
    }
    private static int substraction(){

    }
    private static int multiplication(){

    }
    private static int division(){

    }
}
