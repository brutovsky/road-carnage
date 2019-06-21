package gameObjects;

import gameObjects.stuff.Bonuses;
import gameObjects.stuff.Constants;

public class Bonus extends GameObject {

    public static final int DURATION = 100;

    Bonuses typeOf;
    public Bonus(float scale, float x, float y, Bonuses bonus) {
        super(Animator.animate(bonus.getPath(),bonus.getColumns(),bonus.getLines(),DURATION,true), scale, x, y);
        typeOf = bonus;
    }

    public void draw(){
        getAnimation().draw(x,y);
    }

    @Override
    public void update(float shift, int delta) {
        y += (shift*delta)/ Constants.DIVIDE_DELTA;
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
