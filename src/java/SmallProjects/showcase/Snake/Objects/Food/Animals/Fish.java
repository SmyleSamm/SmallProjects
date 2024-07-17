package SmallProjects.showcase.Snake.Objects.Food.Animals;

public class Fish extends SmallProjects.showcase.Snake.Objects.Food.AbstractFood{
    Fish(int x, int y){
        this.foodQuality = new java.util.Random().nextInt(400) + 100;
        this.name = "Fish";
        this.xy[0] = x;
        this.xy[1] = y;
    }
}
