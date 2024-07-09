package SmallProjects.showcase;
import SmallProjects.Helper;

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
        Inventory playerInventory;
        Player(){
            this.name = null;
            this.carisma = 0;
        }
        Player(String name, int carisma, Inventory playerInventory){
            this.name = name;
            this.carisma = carisma;
            this.playerInventory = playerInventory;
        }
        public String getName(){return this.name;}
        public void setName(String name){this.name = name;}
        public int getCarisma(){return this.carisma;}
        public void setCarisma(int carisma){this.carisma = carisma;}

        public static class Inventory
        {
            InventoryItem[] items;
            Inventory(){
                this.items = new InventoryItem[0];
            }
            Inventory(InventoryItem[] items){
                this.items = items;
            }
            
            public static class InventoryItem
            {
                String name;
                String description;
                int weight;
                int size;
                InventoryItem(){
                    this.name = null;
                    this.description = null;
                    this.weight = 0;
                    this.size = 0;
                }
                InventoryItem(String name, String description, int weight, int size){
                    this.name = name;
                    this.description = description;
                    this.weight = weight;
                    this.size = size;
                }
            }
        }
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
