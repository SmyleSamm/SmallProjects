package SmallProjects;

public class Main
{
    public static final String showcasePath = "./src/java/SmallProjects/showcase";
    public static final String showcaseClassPath = "SmallProjects.showcase.";
    public static void main(String[] args) {
        Helper.c();
        System.out.println("Hello!\nThis is a program for many small projects of mine!\nAll of them are controlled via the console.\nHave fun, your Samm :]");
        start();
    }
    public static void start(){
        printProgramms();
        System.out.println("Enter the number of the desired application!");
        int ans = Helper.intInputInRange(0, SFR.returnAmountInFolder(showcasePath));
        if(ans>=1&&ans<=SFR.returnAmountInFolder(showcasePath)){
            choseApplication(SFR.returnFileNamesInDirectory(showcasePath)[ans-1]);
        }else{
            Helper.c();
            System.out.println("See you again soon!");
            System.exit(0);
        }
    }
    public static void choseApplication(String app){
        try{
            Class.forName(showcaseClassPath+app).getMethod("main", String[].class).invoke(null, (Object)null);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    //it prints all the programs it can find in the showcase folder and then prints the exit thing... bro do not ask me xD
    private static void printProgramms(){
        String[] programs = SFR.returnFileNamesInDirectory(showcasePath);
        for(int i = 0; i < SFR.returnAmountInFolder(showcasePath); ++i){
            System.out.println((i+1)+". program is "+programs[i]);
        }
        System.out.println("0. Exit");
    }
}