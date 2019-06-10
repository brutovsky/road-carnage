package gameObjects;

import gameObjects.MovingObject;
import gameObjects.StaticObject;
import gameObjects.stuff.Bonuses;
import org.newdawn.slick.Image;

public class Bonus extends GameObject {

    Bonuses typeOf;
    public Bonus(float scale, int x, int y, Bonuses bonus) {
        super(bonus.getAnimation(), scale, x, y);
        typeOf = bonus;
    }

    public void draw(){
        getAnimation().draw(x,y);
    }

    @Override
    public int collisionOccured() {
        return typeOf.collision();
    }
}
