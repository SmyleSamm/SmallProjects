package SmallProjects.showcase;
import SmallProjects.Helper;
import SmallProjects.Exception.IntInputException;

public class TextAdventure {
    private static boolean running;
    private static String name;
    private static Player player;
    public class Town
    {
        String name, description;
    }
    public static class Player
    {
        String name;
        int carisma; 
        Player(){
            this.name = null;
            this.carisma = 0;
        }
        public String getName(){return this.name;}
        public void setName(String name){this.name = name;}
        public int getCarisma(){return this.carisma;}
        public void setCarisma(int carisma){this.carisma = carisma;}
    }
    public static class NPC
    {
        int likesThePlayer;
        NPC(){
            likesThePlayer = new java.util.Random().nextInt(5 + player.getCarisma());
            System.out.println(likesThePlayer);
        }
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
