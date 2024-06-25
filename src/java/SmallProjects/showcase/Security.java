package SmallProjects.showcase;

import SmallProjects.Helper;
import SmallProjects.SFR;

public class Security
{
    private static final int bitIncreasement = 6;
    public static void main(String[] args){
        Helper.c();
        System.out.println("Welcome to Security!");
        encrypt("user/save/Todo-List/MyNewTodo.txt");
        decrypt("user/save/Todo-List/TestEnc.txt");
    }
    public static void encrypt(String file){
        String fileName = "TestEnc";
        String filePath = "user/save/Todo-List";
        SFR.createFile(fileName, filePath);
        for(int j = 0; j < SFR.returnContentFromTextFile(file).length; j++){
            String newString = new String();
            char[] parts = SFR.returnContentFromTextFile(file)[j].toCharArray();
            for(int i = 0; i < parts.length; i++){
                newString += (char) ((int)parts[i]+bitIncreasement);
            }
            String[] oldStringFromEncFile = SFR.returnContentFromTextFile(filePath+"/"+fileName+".txt");
            String[] newStringForEncFile = new String[oldStringFromEncFile.length+1];
            for(int i = 0; i < oldStringFromEncFile.length; i++){
                newStringForEncFile[i] = oldStringFromEncFile[i];
            }
            newStringForEncFile[oldStringFromEncFile.length] = newString;
            SFR.writeContentToTextFile(newStringForEncFile, filePath+"/"+fileName+".txt");
        }
        
        
    }
    public static void decrypt(String file){
        String fileName = "TestDec";
        String filePath = "user/save/Todo-List";
        SFR.createFile(fileName, filePath);
        for(int j = 0; j < SFR.returnContentFromTextFile(file).length; j++){
            String newString = new String();
            char[] parts = SFR.returnContentFromTextFile(file)[j].toCharArray();
            for(int i = 0; i < parts.length; i++){
                newString += (char) ((int)parts[i]-bitIncreasement);
            }
            String[] oldStringFromEncFile = SFR.returnContentFromTextFile(filePath+"/"+fileName+".txt");
            String[] newStringForEncFile = new String[oldStringFromEncFile.length+1];
            for(int i = 0; i < oldStringFromEncFile.length; i++){
                newStringForEncFile[i] = oldStringFromEncFile[i];
            }
            newStringForEncFile[oldStringFromEncFile.length] = newString;
            SFR.writeContentToTextFile(newStringForEncFile, filePath+"/"+fileName+".txt");
        }
    }
}