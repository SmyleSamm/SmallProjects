package src;

public class Main
{
    public static final String showcasePath = "./src/showcase";
    public static void main(String[] args) {
        Helper.c();
        System.out.println("Hello!\nThis is a programm for many small projects of mine!\nAll of them are controlled via the console.\nHave fun, your Samm :]");
        start();
    }

    public static void start(){
        printProgramms();
        System.out.println("Enter the number of the desired application!");
        int ans = 0;
        if(Helper.intInput()!=-409){
            if(ans>=1&&ans<SFR.returnAmountInFolder(showcasePath))
                choseApplication(SFR.returnFileNamesInDirectory(showcasePath)[ans-1]);
            else
                //invalid input!
                start();
            
        }else{
            start();
        }
        if(ans>=1&&ans<SFR.returnAmountInFolder(showcasePath)){
            
        }else if(ans==0){
            Helper.c();
            System.exit(0);
        }else{
            System.out.println("Invalid input!\nTry again.");
            start();
        }
    }
    //a switch statement to see what application the user wants to use. If a new application is added, u have to add it in heare and do what every u want it to do!
    public static void choseApplication(String app){
        switch(app){
            case "Calculator":
                src.showcase.Calculator.main(null);
                break;
            case "TextAdventure":
                src.showcase.TextAdventure.main(null);
                break;
            case "Guesser":
                src.showcase.Guesser.main(null);
                break;
            case "BinaryToInt":
                src.showcase.BinaryToInt.main(null);
                break;
            case "TodoList":
                src.showcase.TodoList.main(null);
                break;
        }
    }
    //it prints all the programms it can find in the showcase folder and then prints the exit thing... bro dont ask me xD
    private static void printProgramms(){
        String[] programms = SFR.returnFileNamesInDirectory(showcasePath);
        for(int i = 0; i < SFR.returnAmountInFolder(showcasePath); ++i){
            System.out.println((i+1)+". programm is "+programms[i]);
        }
        System.out.println("0. Exit");
    }
}