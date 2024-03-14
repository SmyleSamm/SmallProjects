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
            System.out.println("What do you want to do?\n1. addition\n2. substraction\n3. multiplication\n4. division\n0. Exit");
            int ans = Helper.intInput();
            Helper.c();
            switch(ans){
                case 1:
                    System.out.println("Your number is: "+addition());
                    break;
                case 2:
                    System.out.println("Your number is: "+substraction());
                    break;
                case 3:
                    System.out.println("Your number is: "+multiplication());
                    break;
                case 4:
                    System.out.println("Your number is: "+division());
                    break;
                case 0:
                    running=false;
                    break;
                default:
                    System.out.println("Invalid number!");
                    break;
            }
        }
        System.out.println("Have a great day!");
        src.Main.start();
    }
    private static int addition(){
        return num1+num2;
    }
    private static int substraction(){
        return num1-num2;
    }
    private static int multiplication(){
        return num1*num2;
    }
    private static float division(){
        if(num2==0)
            return 0;
        return (float)num1/(float)num2;
    }
}
