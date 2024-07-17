package SmallProjects.showcase.Snake.Objects.Food;

import SmallProjects.showcase.Snake.Objects.*;

public abstract class AbstractFood extends AbstractObject
{
    protected int foodQuality;
    protected String name;
    //Getter-methods
    public int getFoodQuality(){return foodQuality;}
    public String getName(){return name;}
}