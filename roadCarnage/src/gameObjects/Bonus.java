package gameObjects;

import gameObjects.MovingObject;
import gameObjects.StaticObject;
import gameObjects.stuff.Bonuses;
import org.newdawn.slick.Image;

public class Bonus extends StaticObject {
    public Bonus(float scale, int x, int y, MovingObject player, Bonuses bonus) {
        super(bonus.getAnimation(), scale, x, y, player);
    }

    public void draw(){
        getAnimation().draw(x,y);
    }
}
