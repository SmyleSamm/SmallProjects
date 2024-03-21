package src;

public class Main
{
    public static String showcasePath = "./src/showcase";
    public static void main(String[] args) {
        Helper.c();
        System.out.println("Hello!\nThis is a programm for many small projects of mine!\nAll of them are controlled via the console.\nHave fun, your Samm :]");
        start();
    }

    public static void start(){
        printProgramms();
        System.out.println("Enter the number of the desired application!");
        choseApplication(returnFileName(showcasePath, Helper.intInput()-1));
    }
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
            case "null":
                Helper.c();
                System.exit(0);
                break;
            default:
                System.out.println("Invalid number, chose again!");
                choseApplication(returnFileName(showcasePath, Helper.intInput()-1));
        }
    }
    private static void printProgramms(){
        for(int i = 0; i < countProgramms(); ++i){
            System.out.println((i+1)+". programm is "+returnFileName(showcasePath,i));
        }
        System.out.println("0. Exit");
    }
    public static String returnFileName(String filePath, int index){
        if(index>=0){
            String names = SFR.returnFilesInFolder(filePath).get(index);
            String[] name = names.split("\\.");
            return name[0];
        }else
            return "null";
    }
    private static int countProgramms(){
        return SFR.returnAmountInFolder(showcasePath);
    }
}