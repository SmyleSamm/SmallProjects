package SmallProjects.showcase.Snake.Objects.Food.Animals;

public class Fish extends SmallProjects.showcase.Snake.Objects.Food.AbstractFood{
    Fish(){
        this.foodQuality = new java.util.Random().nextInt(400) + 100;
        this.name = "Fish";
        //Image manipulation?
    }
}
