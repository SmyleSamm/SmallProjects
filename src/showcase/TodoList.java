package src.showcase;
import java.util.LinkedList;

import src.Helper;

public class TodoList {
    private static LinkedList<String> list = new LinkedList<String>();
    public static void main(String[] args) {
        Helper.c();
        System.out.println("Welcome to the TodoList!");
        intro();
    }   
    public static void intro(){
        System.out.println("1. View Todo-List");
        System.out.println("2. Edit Todo-List");
        System.out.println("0. Exit");
        int ans = Helper.intInput();
        Helper.c();
        switch(ans){
            case 1:
                view();
                intro();
                break;
            case 2:
                edit();
                break;
            default:
                src.Main.start();
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
        int ans = Helper.intInput();
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
        System.out.println("Name the index of the, to be removeble task.");
        view();
        int ans = Helper.intInput();
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
        int ansI = Helper.intInput();
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
}
