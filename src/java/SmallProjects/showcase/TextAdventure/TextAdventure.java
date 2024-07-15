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
        //SmallProjects.Main.start();
    }
    TextAdventure(){
        this.player = new Player();
        new Npc(this.player);
    }
}
