package SmallProjects.showcase.Snake.Objects.Food.Animals;

public class Bear extends SmallProjects.showcase.Snake.Objects.Food.AbstractFood{
    Bear(){
        this.foodQuality = new java.util.Random().nextInt(400) + 100;
        this.name = "Bear";
        //Image manipulation?
    }
}
