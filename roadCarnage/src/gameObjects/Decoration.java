package gameObjects;
import gameObjects.stuff.Bonuses;
import gameObjects.stuff.Constants;

public class Decoration extends GameObject {

    Bonuses typeOf;
    public Decoration(float scale, int x, int y, Bonuses bonus) {
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
    private void drawDecorations() {

        //  Decorations.TREE.getImage().draw(10, (yD ));
        coordinates.add(yD);
    }
}
