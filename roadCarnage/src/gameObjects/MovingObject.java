package gameObjects;

import org.newdawn.slick.Image;

public class MovingObject extends GameObject{

    protected float speed;

    public MovingObject(Image image, float scale, int x, int y, float start_speed) {
        super(image, scale, x, y);
        speed = start_speed;
    }

    public float getSpeed(){
        return speed;
    }
}
