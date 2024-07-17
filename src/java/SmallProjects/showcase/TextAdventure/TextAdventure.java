package SmallProjects.showcase.TextAdventure;
import SmallProjects.Helper;

public class TextAdventure {
    private static boolean running;
    private static String name;
    private Player player;
    public class Town
    {
        String name, description;
    }
    public static void main(String[] args) {
        running=true;
        Helper.c();
        System.out.println("Welcome to the textAdventure!");
        new TextAdventure();
    }
    TextAdventure(){
        this.player = new Player();
        new Npc(this.player);
        gameLoop();
    }
    public void gameLoop(){
        while(running){
            System.out.println("I am playing this game like cwazy!");
            running = false;
        }
        Helper.c();
        System.out.println("See you again soon!");
        SmallProjects.Main.start();
        return;
    }
}
