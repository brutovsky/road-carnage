package gameObjects;

import org.newdawn.slick.*;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;


public class MovingObject extends GameObject{

    protected float speed;
    private Rectangle borders;

    public MovingObject(Image image, float scale, float x, float y, float start_speed, Rectangle borders) {
        super(image, scale, x, y);
        speed = start_speed;
        this.borders = borders;
    }

    public MovingObject(Animation animation, float scale, float x, float y, float start_speed, Rectangle borders) {
        super(animation, scale, x, y);
        speed = start_speed;
        this.borders = borders;
    }

    public int startX(){
        return (int)borders.getX();
    }

    public int startY(){
        return (int)borders.getY();
    }

    public int bordersWidth(){
        return (int)borders.getWidth();
    }

    public int bordersHeight(){
        return (int)borders.getHeight();
    }

    public float getSpeed(){
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }


}
