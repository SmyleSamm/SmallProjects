package SmallProjects.showcase.Snake.Objects.Food.Animals;

public class Bear extends SmallProjects.showcase.Snake.Objects.Food.AbstractFood{
    Bear(int x, int y){
        this.foodQuality = new java.util.Random().nextInt(400) + 100;
        this.name = "Bear";
        this.xy[0] = x;
        this.xy[1] = y;
    }
}
