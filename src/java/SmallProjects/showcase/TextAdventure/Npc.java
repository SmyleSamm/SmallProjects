package SmallProjects.showcase.TextAdventure;

public class Npc {
    int likesThePlayer;
    public static void main(String[] args) {
        new Npc(new Player());
    }
    Npc(Player player){
        likesThePlayer = new java.util.Random().nextInt(5 + player.getCarisma());
        System.out.println(likesThePlayer);
    }
}
