package SmallProjects.showcase.Snake.Objects.Snake;

import SmallProjects.showcase.Snake.Objects.*;

public class SnakeHead extends AbstractObject{
    private SnakeBody next;
    public static void main(String[] args) {
        SnakeHead sh = new SnakeHead(0, 0);
        System.out.println("Snakehead alone");
        sh.move(1, 0);
        sh.move(2, 0);
        sh.move(2, 1);
        sh.move(2, 2);
        SnakeHead sh1 = new SnakeHead(0, 0, new SnakeBody(-1, 0, new SnakeBody(-2, 0)));
        System.out.println("Snakehead with two body parts");
        sh1.move(1, 0);
        sh1.move(2, 0);
        sh1.move(2, 1);
        sh1.move(2, 2);
    }
    SnakeHead(int x, int y){
        this.xy[0] = x;
        this.xy[1] = y;
        this.next = null;
    }
    SnakeHead(int x, int y, SnakeBody next){
        this.xy[0] = x;
        this.xy[1] = y;
        this.next = next;
    }
    private void move(int newX, int newY){
        System.out.println("SnakeHead: "+this.xy[0] +", "+this.xy[1]+"; "+newX+", "+newY);
        if(this.next!=null)
            this.next.move(this.xy[0], this.xy[1]);
        this.xy[0] = newX;
        this.xy[1] = newY;
    }
}
