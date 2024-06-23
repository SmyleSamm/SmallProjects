package SmallProjects.showcase;
import java.util.*;
import java.io.*;

import SmallProjects.Helper;
import SmallProjects.SFR;
import SmallProjects.Exception.IntInputException;

public class TodoList {
    private static final String savePath = "user/save/Todo-List", todoExtension = ".txt";
    private static LinkedList<String> list = new LinkedList<String>();
    public static void main(String[] args) {
        Helper.c();
        System.out.println("Welcome to the TodoList!");
        intro();
    }   
    public static void intro(){
        String[] nameCon = {"View", "Edit", "Load", "Save"};
        for(int i = 1; i <= nameCon.length; ++i){
            System.out.println(i+". "+nameCon[i-1]+" Todo-List");
        }
        System.out.println("0. Exit");
        //create if-Statement for correct user Input: 0 => Index -1!!!!!
        //edit2: change to intInputInRange!!!!!!!!!
        int ans = 0;
        try{
            ans = Helper.intInput();
        }catch(IntInputException e){
            Helper.c();
            System.out.println(e);
            intro();
        }
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
            default:
                SmallProjects.Main.start();
                break;
        }
    } 
    public static void view(){
        if(list.size()<=0)
            System.out.println("Your Todo-List is empty!");
        else
        System.out.println("This is the content of your Todo-List:");
        for(int i = 0; i < list.size(); ++i){
            System.out.println(i+1+": "+list.get(i));
        }
    }
    public static void edit(){
        System.out.println("1. Add task to Todo-List");
        System.out.println("2. Remove task from Todo-List");
        System.out.println("3. Rename task from Todo-List");
        System.out.println("0. Back");
        int ans = 0;
        //edit2: change to intInputInRange!!!!!!!!!
        try{
            ans = Helper.intInput();
        }catch(IntInputException e){
            Helper.c();
            System.out.println(e);
            edit();
        }
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
        intro();
    }
    public static void remove(){
        System.out.println("Name the index of the, to be removable task.");
        view();
        int ans = 0;
        //edit2: change to intInputInRange!!!!!!!!!
        try{
            ans = Helper.intInput();
        }catch(IntInputException e){
            Helper.c();
            System.out.println(e);
            remove();
        }
        Helper.c();
        if(ans>=0&&ans<list.size())
            list.remove(ans-1);
        else
            System.out.println("No task found under the index of "+ans);
        intro();
    }
    public static void rename(){
        System.out.println("Name the index of the, to be renamed task.");
        view();
        int ansI = 0;
        //edit2: change to intInputInRange!!!!!!!!!
        try{
            ansI = Helper.intInput();
        }catch(IntInputException e){
            Helper.c();
            System.out.println(e);
            rename();
        }
        Helper.c();
        if(ansI<=0||ansI>list.size()){
            System.out.println("No task found under the index of "+ansI);
            rename();
        }
        System.out.println("Now enter the new name of the task.");
        String ansS = Helper.stringInput();
        list.set(ansI-1, ansS);
        Helper.c();
        intro();
    }
    public static void saveToFile(){
        System.out.println("Enter Todo-List name:");
        String ans = Helper.stringInput();
        Helper.c();
        if(!SFR.checkPath(savePath)){
            SFR.createFolder(savePath);
        }
        SFR.createFile(ans, savePath);
        if(saveContent(savePath+"/"+ans+todoExtension))
            System.out.println("ToDo-List successfully saved!");
        else
            System.out.println("Failed during saving Todo-List");
        intro();
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
        list = new LinkedList<String>();
        String[] content = SFR.returnContentFromTextFile(savePath+"/"+todoName+todoExtension);
        for(int i = 0; i < content.length; ++i){
            list.add(i, content[i]);
        }
    }
}
