package gameObjects;

import org.newdawn.slick.*;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;

/**
 * @author Vadym Nakytniak
 * Superclass for all moving objects
 */
public class MovingObject extends GameObject {

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

    public boolean checkForCollision(Rectangle object) {
        float thisTop = y;
        float thisBottom = thisTop + height;
        float thisLeft = x;
        float thisRight = thisLeft + width;

        float otherTop = object.getY();
        float otherBottom = otherTop + object.getHeight();
        float otherLeft = object.getX();
        float otherRight = otherLeft + object.getWidth();

        if (thisBottom < otherTop) return (false);
        if (thisTop > otherBottom) return (false);

        if (thisRight < otherLeft) return (false);
        if (thisLeft > otherRight) return (false);

        return (true);
    }

    public boolean checkForCollision(GameObject object) {
        float thisTop = y;
        float thisBottom = thisTop + height;
        float thisLeft = x;
        float thisRight = thisLeft + width;

        float otherTop = object.y;
        float otherBottom = otherTop + object.height;
        float otherLeft = object.x;
        float otherRight = otherLeft + object.width;

        if (thisBottom < otherTop) return (false);
        if (thisTop > otherBottom) return (false);

        if (thisRight < otherLeft) return (false);
        if (thisLeft > otherRight) return (false);

        return (true);
    }

    public int startX() {
        return (int) borders.getX();
    }

    public int startY() {
        return (int) borders.getY();
    }

    public int bordersWidth() {
        return (int) borders.getWidth();
    }

    public int bordersHeight() {
        return (int) borders.getHeight();
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }


}
