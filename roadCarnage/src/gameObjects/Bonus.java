package gameObjects;

import gameObjects.stuff.Bonuses;
import gameObjects.stuff.Constants;

public class Bonus extends GameObject {

    Bonuses typeOf;
    public Bonus(float scale, float x, float y, Bonuses bonus) {
        super(bonus.getAnimation(), scale, x, y);
        typeOf = bonus;
    }

    public void draw(){
        getAnimation().draw(x,y);
    }

    @Override
    public void update(float shift, int delta) {
        y += shift*delta/ Constants.DIVIDE_DELTA;
    }

    @Override
    public int collisionOccured() {
        return typeOf.collision();
    }

    public Bonuses getType() {
        return typeOf;
    }

    public String getName(){
        return typeOf.getName();
    }
}
