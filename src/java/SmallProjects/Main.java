package SmallProjects;

public class Main
{
    public static final String showcasePath = "./src/java/SmallProjects/showcase";
    public static final String showcaseClassPath = "SmallProjects.showcase.";
    public static String[] programs = null;
    public static void main(String[] args) {
        Helper.c();
        System.out.println("Hello!\nThis is a program for many small projects of mine!\nAll of them are controlled via the console.\nHave fun,\nYour Samm :]\n");
        start();
    }
    public static void start(){
        printPrograms();
        System.out.println("Enter the number of the desired application!");
        int folderSize = SFR.returnTotalAmountInFolder(showcasePath);
        int ans = Helper.intInputInRange(0, folderSize);
        if(ans==0){
            Helper.c();
            System.out.println("See you again soon!");
            System.exit(0);
        }else{
            if(ans <= SFR.returnFileAmountInFolder(showcasePath)){
                choseApplication(programs[ans-1]);
            }else{
            }
            
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
    private static void printPrograms(){
        programs = Helper.combineArrays(
            SFR.returnFileNamesWithoutExtensionInDirectory(showcasePath), 
            SFR.returnDirectoriesInFolder(showcasePath));
        for(int i = 0; i < programs.length; ++i){
            System.out.println((i+1)+". program is "+programs[i]);
        }
        System.out.println("0. Exit");
    }
}