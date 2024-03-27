package src.showcase;

import src.Helper;
import src.Exception.IntInputException;

public class Calculator {
    private static boolean running;
    private static double num1, num2;
    public static void main(String[] args) {
        running=true;
        Helper.c();
        System.out.println("Welcome to the Calculator!");
        loop();
    }
    public static void loop(){
        while(running){
            System.out.println("What do you want to calculate?\n1. Easy calculations(addition to division)\n0. Exit");
            int ans = 0;
            try{
            ans = Helper.intInput();
            }catch(IntInputException e){
                Helper.c();
                System.out.println(e);
                loop();
            }
            Helper.c();
            switch (ans) {
                case 1:
                    easyCalculations();
                    break;
                case 0:
                    running=false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("Have a great day!");
        src.Main.start();
    }
    private static void easyCalculations(){
        System.out.println("What shall be the first number?");
        num1=0;
        try{
            num1 = Helper.intInput();
        }catch(IntInputException e){
            Helper.c();
            System.out.println(e);
            easyCalculations();
        }
        Helper.c();
        System.out.println("What shall be the second number?");
        num2=0;
        try{
            num2 = Helper.intInput();
        }catch(IntInputException e){
            Helper.c();
            System.out.println(e);
            easyCalculations();
        }
        Helper.c();
        System.out.println("What do you want to do?\n1. addition\n2. substraction\n3. multiplication\n4. division");
        int ans = 0;
        try{
            ans = Helper.intInput();
        }catch(IntInputException e){
            Helper.c();
            System.out.println(e);
            easyCalculations();
        }
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
            default:
                System.out.println("Invalid number!");
                break;
        }
    }
    private static double addition(){
        return num1+num2;
    }
    private static double substraction(){
        return num1-num2;
    }
    private static double multiplication(){
        return num1*num2;
    }
    private static double division(){
        if(num2==0)
            return 0;
        return num1/num2;
    }
}