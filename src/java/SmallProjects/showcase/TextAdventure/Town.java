package SmallProjects.showcase.TextAdventure;

public class Town {
    String name;
    String description;
    int difficultyLVL;
    Town(){
        this.name = null;
        this.description = null;
        this.difficultyLVL = 0;
    }
    Town(String name, String description, int difficultyLVL){
        this.name = name;
        this.description = description;
        this.difficultyLVL = difficultyLVL;
    }
    public String getName(){return this.name;}
    public void setName(String name){this.name = name;}
    public String getDescription(){return this.description;}
    public void setDescription(String description){this.description = description;}
}
