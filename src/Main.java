package src;

import src.showcase.Test2;

public class Main
{
    private static String[] programms;
    public static void main(String[] args) {
        programms = new String[countProgramms()];
        start();
    }

    public static void start(){
        System.out.println("Hello!\nThis is a programm for many small projects of mine!\nAll of them are controlled via the console.\nHave fun, your Samm :]");
        printProgramms();
    }
    private static void printProgramms(){
        for(int i = 0; i < countProgramms(); ++i){
            System.out.println((i+1)+". programm is "+returnFileName("./src/showcase",i));
        }
    }
    public static String returnFileName(String filePath, int index){
        String names = SFR.returnFilesInFolder(filePath).get(index);
        String[] name = names.split("\\.");
        return name[0];
    }
    private static int countProgramms(){
        return SFR.returnAmountInFolder("./src/showcase");
    }
}