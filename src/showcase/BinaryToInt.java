package src.showcase;

import src.Helper;

public class BinaryToInt
{
    public static void main(String[] args){
        Helper.c();
        System.out.println("Welcome to the Number Translator!");
        intro();
    }
    public static void intro(){
        System.out.println("Do you want to input a 1. Binary or a 2. Integer?");
        int ans = Helper.intInput();
        switch(ans){
            case 1:
                System.out.println("Input your Binary number:");
                double sol1 = toInteger(Helper.intInput());
                System.out.println("This binary represents the number "+sol1);
                break;
            case 2:
                System.out.println("Input your number!");
                double sol2 = toBinary(Helper.intInput());
                System.out.println("In Binary it is "+sol2);

                break;
            default:
                System.out.println("Invalid input! Try again.");
                main(null);
        }
        intro();
    }
    public static int toInteger(int binary){
        String[] num = Integer.toString(binary).split("");
        int ans = 0;
        if(Integer.parseInt(num[0])==1)
            ans+=1;
        for(int i = 0; i < num.length; ++i){
            double temp = Math.pow(Integer.parseInt(num[i])+1, i);
            if(temp%2==0)
                ans+=temp;
        }
        return ans;
    }
    public static int toBinary(int integer){
        return 0;
    }
}