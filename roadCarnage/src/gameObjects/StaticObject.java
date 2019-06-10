package gameObjects;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;

public class StaticObject extends GameObject {

    protected float supposedSpeed;
    private MovingObject relationTo;

    public StaticObject(Image image, float scale, int x, int y, MovingObject player) {
        super(image, scale, x, y);
    }

    public StaticObject(Animation animation, float scale, int x, int y, MovingObject player) {
        super(animation, scale, x, y);
        relationTo = player;
    }

    public void setRelationTo(MovingObject object) {
        relationTo = object;
    }

    public void update() {
        supposedSpeed = relationTo.getSpeed();
    }


}
