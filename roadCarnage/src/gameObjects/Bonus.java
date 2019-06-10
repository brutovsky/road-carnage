package gameObjects;

import gameObjects.stuff.Bonuses;

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
