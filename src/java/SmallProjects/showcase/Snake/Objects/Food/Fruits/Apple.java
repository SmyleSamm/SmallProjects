package SmallProjects.showcase.Snake.Objects.Food.Fruits;

public class Apple extends SmallProjects.showcase.Snake.Objects.Food.AbstractFood{
    Apple(int x, int y){
        this.foodQuality = 5;
        this.name = "Apple";
        this.xy[0] = x;
        this.xy[1] = y;
    }
}
