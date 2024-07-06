package SmallProjects.showcase;

import SmallProjects.Helper;

public class Calculator {
    private boolean running;
    private double num1, num2;
    public static void main(String[] args) {
        Helper.c();
        System.out.println("Welcome to the Calculator!");
        new Calculator();
    }
    public Calculator(){
        this.running=true;
        while(running){
            askUserToEnterNumbers();
            int calculationID = askUserWhatCalculationTheyWantToPerform();
            Helper.c();
            double result = calculateTheResult(calculationID);
            System.out.println("The result is: "+result);
            Helper.delay(1000);
            this.running = calculateAgain();
            Helper.c();
        }
        System.out.println("Have a great day!");
        SmallProjects.Main.start();
    }

    private void askUserToEnterNumbers(){ 
        System.out.println("Enter your first number!");
        this.num1 = Helper.intInputInRange(Integer.MIN_VALUE, Integer.MAX_VALUE);
        Helper.c();
        System.out.println("Enter your second number!");
        this.num2 = Helper.intInputInRange(Integer.MIN_VALUE, Integer.MAX_VALUE);
        Helper.c();
    }
    private int askUserWhatCalculationTheyWantToPerform(){
        System.out.println("Enter your preferred calculation method!");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        return Helper.intInputInRange(1, 4);
    }
    private double calculateTheResult(int calculationID){
        switch(calculationID){
            case 1:
                return this.num1 + this.num2;
            case 2:
                return this.num1 - this.num2;
            case 3:
                return this.num1 * this.num2;
            case 4:
                if(num2==0)
                    return 0;
                return this.num1 / this.num2;
            default:
                System.out.println("Calculation not successful");
                return -1;
        }
    }
    private boolean calculateAgain(){
        System.out.println("Do you want to calculate something else?");
        System.out.println("1. Yes");
        System.out.println("0. No");
        return Helper.intInputInRange(0, 1) == 1;
    }
}