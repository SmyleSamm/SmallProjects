package SmallProjects.showcase.TextAdventure;
import SmallProjects.Helper;

public class TextAdventure {
    private static boolean running;
    private static String name;
    private static Player player;
    public class Town
    {
        String name, description;
    }
    public static void main(String[] args) {
        running=true;
        Helper.c();
        System.out.println("Welcome to the textAdventure!");
        player = new Player();
        SmallProjects.Main.start();
    }
    public static void slowPrint(String str){
        String[] text = str.split("");
        for(int i = 0; i < text.length; ++i){
            System.out.print(text[i]);
            Helper.delay(50);
        }
    }
}
