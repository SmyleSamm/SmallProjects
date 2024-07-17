package SmallProjects.showcase.Snake.Objects.Snake;

import SmallProjects.showcase.Snake.Objects.*;

public class SnakeBody extends AbstractObject{
    protected SnakeBody next;
    SnakeBody(int x, int y){
        this.next = null;
        this.xy[0] = x;
        this.xy[1] = y;
    }
    SnakeBody(int x, int y, SnakeBody next){
        this.next = next;
        this.xy[0] = x;
        this.xy[1] = y;
    }
    protected void move(int newX, int newY){
        System.out.println("SnakeBody: "+this.xy[0] +", "+this.xy[1]+", "+newX+", "+newY);
        if(next!=null)
            next.move(this.xy[0], this.xy[1]);
        this.xy[0] = newX;
        this.xy[1] = newY;
    }
}
