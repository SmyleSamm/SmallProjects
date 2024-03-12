public class Main
{
    private static String[] programms;
    public static void main(String[] args) {
        programms = new String[countProgramms()];
        fillProgrammsList();
        start();
    }

    public static void start(){
        System.out.println("Hello!\nThis is a programm for many small projects of mine!\nAll of them are controlled via the console.\nHave fun, your Samm :]");
        printProgramms();
    }
    private static void printProgramms(){
        for(int i = 0; i < countProgramms(); ++i){
            System.out.println((i+1)+". programm is "+programms[i]);
        }
    }
    private static int countProgramms(){
        //searches the whole Folder for "Showcase[...].java"
        return 3;
    }
    private static String[] returnAllShowcaseProgramms(){
        String[] s = new String[4];
        s[0]="test1";
        s[1]="test2";
        s[2]="test3";
        s[3]="test4";
        return s;
    }
    private static void fillProgrammsList(){
        //remove "Showcase" & ".java"
        String[] a = returnAllShowcaseProgramms();
        for(int i = 0; i < countProgramms(); ++i){
            programms[i]=a[i];
        }
    }
}