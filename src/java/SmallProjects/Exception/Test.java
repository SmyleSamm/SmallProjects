package SmallProjects.Exception;

import SmallProjects.SFR;

public class Test{
    public static final String showcasePath = "./src/java/SmallProjects/showcase";
    public static final String showcaseClassPath = "SmallProjects.showcase.";
    public static void main(String[] args) {
        printPrograms();
    }
    private static void printPrograms(){
        String[] programs = SFR.returnFileNamesWithoutExtensionInDirectory(showcasePath);
        int i;
        for(i = 0; i < programs.length; ++i){
            System.out.println((i+1)+". program is "+programs[i]);
        }
        printInDirectoryPrograms(i);
        System.out.println("0. Exit");
    }
    private static void printInDirectoryPrograms(int counter){
        String[] directories = SFR.returnDirectoriesInFolder(showcasePath);
        for(int i = counter; i < directories.length + counter; i++){
            System.out.println((i+1)+". program is "+directories[i-counter]);
        }
    }
}
