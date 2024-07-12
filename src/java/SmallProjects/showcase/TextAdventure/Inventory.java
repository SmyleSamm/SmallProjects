package SmallProjects.showcase.TextAdventure;

public class Inventory {
    InventoryItem[] items;
    Inventory(){
        this.items = new InventoryItem[0];
    }
    Inventory(InventoryItem[] items){
        this.items = items;
    }
    public class InventoryItem
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
