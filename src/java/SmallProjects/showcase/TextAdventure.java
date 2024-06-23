package SmallProjects.showcase;
import SmallProjects.Helper;
import SmallProjects.Exception.IntInputException;

public class TextAdventure {
    private static boolean running;
    private static String name;
    public static void main(String[] args) {
        running=true;
        Helper.c();
        System.out.println("Welcome to the textAdventure!");
        introduction();
    }
    private static void print(String str){
        System.out.println(str);
    }
    public static void slowPrint(String str){
        String[] text = str.split("");
        for(int i = 0; i < text.length; ++i){
            System.out.print(text[i]);
            Helper.delay(50);
        }
        
    }
    private static int inputReader(int low, int max){
        int ans = 0;
        try{
            ans = Helper.intInput();
        }catch(IntInputException e){
            Helper.c();
            System.out.println(e);
            inputReader(low, max);
        }
        if(ans<=max&&ans>=low){
            return ans;
        }else{
            print("False input, only type the number of the path you want to go!");
            inputReader(low, max);
        }
        return 0;    
    }
    private static void introduction(){
        print("You find yourself on a beach. Around you are debries from a ship.");
        print("Behind you are steps...");
        print("'Hello?! Are you alive?'");
        print("Will you 1. answer the person or 2. act as if you are dead?");
        switch(inputReader(1, 2)){
            case 1:
                answeredIntroduction();
                break;
            case 2:
                deadIntroduction();
                break;
        }
    }
    private static void nameChange(){
        print((name=Helper.stringInput())+" is that Correct?");
        print("1. yes, 2. change name");
    }
    private static void answeredIntroduction(){
        slowPrint("You answer 'yes I am alive? Why shouldn't I be? And where are we?'");
        slowPrint("'You are the first person I was able to find...");
        slowPrint("It seems that everyone else did not survive the catastrophic attack.");
        slowPrint("Our ship got cut in half. The debries lie around here on the beach.");
        slowPrint("Sorry for my manner, I did not introduce myself to you.");
        slowPrint("My name is captain Eins un Goal!'");
        slowPrint("What is your name?");
        nameChange();
    }
    private static void deadIntroduction(){

    }
}
