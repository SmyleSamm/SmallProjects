package SmallProjects.showcase;
import java.util.*;
import java.io.*;

import SmallProjects.Helper;
import SmallProjects.SFR;

public class TodoList {
    private static final String savePath = "user/save/Todo-List", todoExtension = ".txt";
    private static LinkedList<String> list = new LinkedList<String>();
    private static String currentSaveFileName = null;
    public static void main(String[] args) {
        Helper.c();
        System.out.println("Welcome to the TodoList!");
        intro();
    }   
    public static void intro(){
        String[] nameCon = {"View", "Edit", "Load", "Save", "Encrypt", "Decrypt"};
        for(int i = 1; i <= nameCon.length; ++i){
            System.out.println(i+". "+nameCon[i-1]+" Todo-List");
        }
        System.out.println("0. Exit");
        int ans = Helper.intInputInRange(0, 4);
        Helper.c();
        if(ans<=0&&ans<nameCon.length)
            SmallProjects.Main.start();
        switch(nameCon[ans-1]){
            case "View":
                view();
                intro();
                break;
            case "Edit":
                edit();
                break;
            case "Load":
                loadTodo();
                break;
            case "Save":
                saveToFile();
                break;
            case "Encrypt":
                encrypt();
                break;
            case "Decrypt":
                decrypt();
                break;
            default:
                SmallProjects.Main.start();
                break;
        }
    } 
    static void encrypt(){
        System.out.println("Please enter your password.");
        String password = Helper.stringInput();
        //encrypt
        //use encryption with password
    }
    static void decrypt(){
        System.out.println("Please enter your password.");
        String password = Helper.stringInput();
        
        //enter password
        //decrypt
        //open new decrypted File 
    }
    static void getCurrentName(){
        System.out.println("Current name:"+ currentSaveFileName);
        intro();
    }
    public static void view(){
        if(list.size()<=0)
            System.out.println("Your Todo-List is empty!");
        else{
            System.out.println("This is the content of your Todo-List:");
            System.out.println("--------------------------------");
            for(int i = 0; i < list.size(); ++i){
                System.out.println(i+1+": "+list.get(i));
            }
            System.out.println("--------------------------------");
        }
            
    }
    public static void edit(){
        System.out.println("1. Add task to Todo-List");
        System.out.println("2. Remove task from Todo-List");
        System.out.println("3. Rename task from Todo-List");
        System.out.println("0. Back");
        int ans = Helper.intInputInRange(0, 3);
        Helper.c();
        switch(ans){
            case 1:
                add();
                break;
            case 2:
                remove();
                break;
            case 3:
                rename();
                break;
            default:
                intro();
                break;
        }
    }
    public static void add(){
        System.out.println("Name your new task.");
        String task = Helper.stringInput();
        list.add(list.size(), task);
        Helper.c();
        if(list.contains(task))
            System.out.println("Task successfully added!");
        else
            System.out.println("Failed to add task!");
        edit();
    }
    public static void remove(){
        System.out.println("Name the index of the, to be removable task.");
        view();
        int ans = Helper.intInputInRange(1, list.size());
        Helper.c();
        if(ans>=0&&ans<list.size())
            list.remove(ans-1);
        else
            System.out.println("No task found under the index of "+ans);
        edit();
    }
    public static void rename(){
        System.out.println("Name the index of the, to be renamed task.");
        view();
        int ans = Helper.intInputInRange(1, list.size());
        Helper.c();
        if(ans<=0||ans>list.size()){
            System.out.println("No task found under the index of "+ans);
            rename();
        }
        System.out.println("Now enter the new name of the task.");
        String ansS = Helper.stringInput();
        list.set(ans-1, ansS);
        Helper.c();
        edit();
    }
    public static void saveToFile(){
        if(SFR.checkPath(savePath+"/"+currentSaveFileName+todoExtension)){
            replaceCurrentFile();
        }
        saveToNewFile();
    }
    public static void replaceCurrentFile(){
        System.out.println("Replace current save File?\n1. Yes\n0. No");
        int ans = Helper.intInputInRange(0, 1);
        Helper.c();
        if(ans==1){
            checkIfSavingWasSuccessful(savePath, currentSaveFileName, todoExtension);
            intro();
        }
    }

    public static void saveToNewFile(){
        System.out.println("Enter Todo-List name:");
        String newFileName = Helper.stringInput();
        Helper.c();
        checkExistingFileAndCreateIt(savePath, newFileName);
        checkIfSavingWasSuccessful(savePath, newFileName, todoExtension);
        currentSaveFileName = newFileName;
        intro();
    }

    private static void checkExistingFileAndCreateIt(String filePath, String fileName){
        if(!SFR.checkPath(savePath)){
            SFR.createFolder(savePath);
        }
        SFR.createFile(fileName, savePath);
    }
    private static void checkIfSavingWasSuccessful(String filePath, String fileName, String fileExtension){
        System.out.println(filePath+"/"+fileName+fileExtension);
        if(saveContent(filePath+"/"+fileName+fileExtension)){
            System.out.println("ToDo-List successfully saved!");
        }else{
            System.out.println("Failed during saving Todo-List");
        }
    }
    private static boolean saveContent(String path){
        File f = new File(path);
        if(f.exists()){
            SFR.writeContentToTextFile(list.toArray(new String[0]), path);
            return true;
        }
        return false;
    }
    public static void loadTodo(){
        for(int i = 0; i < SFR.returnAmountInFolder(savePath); ++i){
            System.out.println((i+1)+". ToDo-List is: "+SFR.returnFileNamesInDirectory(savePath)[i]);
        }
        System.out.println("Choose your ToDo-List!\nEvery unsaved changes will be lost in your current ToDo-List!\nEnter 0. to Exit!");
        int ans = 0;
        ans = Helper.intInputInRange(0, SFR.returnAmountInFolder(savePath));
        Helper.c();
        if(ans>=1)
            loadContentToCurrentSystem(SFR.returnFileNamesInDirectory(savePath)[ans-1]);
        intro();
    }
    private static void loadContentToCurrentSystem(String todoName){
        currentSaveFileName = todoName;
        list = new LinkedList<String>();
        String[] content = SFR.returnContentFromTextFile(savePath+"/"+todoName+todoExtension);
        for(int i = 0; i < content.length; ++i){
            list.add(i, content[i]);
        }
    }
}
