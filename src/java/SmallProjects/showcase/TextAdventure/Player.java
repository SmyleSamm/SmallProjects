package SmallProjects.showcase.TextAdventure;

public class Player {
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
}