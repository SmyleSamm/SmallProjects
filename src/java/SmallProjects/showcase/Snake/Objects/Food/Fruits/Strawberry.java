package SmallProjects.showcase.Snake.Objects.Food.Fruits;

public class Strawberry extends SmallProjects.showcase.Snake.Objects.Food.AbstractFood{
    Strawberry(int x, int y){
        this.foodQuality = 5;
        this.name = "Strawberry";
        this.xy[0] = x;
        this.xy[1] = y;
    }
}
