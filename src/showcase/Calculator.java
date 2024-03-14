package src.showcase;

import src.Helper;

public class Calculator {
    private static boolean running;
    private static int num1, num2, num3;
    public static void main(String[] args) {
        running=true;
        Helper.c();
        System.out.println("Welcome to the Calculator!");
        loop();
    }
    public static void loop(){
        while(running){
            System.out.println("What do you want to calculate?\n1. Easy calculations(addition to division)\n2. Complex calculations(abc calculations)");
            int ans = Helper.intInput();
            Helper.c();
            switch (ans) {
                case 1:
                    easyCalculations();
                    break;
                case 2:
                    complexCalculations();
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
    private static void complexCalculations(){
        System.out.println("What shall be the first number?");
        num1=Helper.intInput();
        Helper.c();
        System.out.println("What shall be the second number?");
        num2=Helper.intInput();
        Helper.c();
        System.out.println("What shall be the third number?");
        num3=Helper.intInput();
        Helper.c();
        System.out.println("Your numbers are: "+abc()[0]+" and "+abc()[1]);
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
    private static double[] abc(){
        double[] x = new double[2];
        x[0] = ((-num2)+Math.sqrt(Math.pow(num2, 2)-4.0*(double)num1*(double)num3))/((double)num1*2);
        x[1] = ((-num2)-Math.sqrt(Math.pow(num2, 2)-4.0*(double)num1*(double)num3))/((double)num1*2);
        return x;
    }
}
