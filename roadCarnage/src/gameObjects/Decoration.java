package gameObjects;

import gameObjects.stuff.Bonuses;
import gameObjects.stuff.Constants;
import gameObjects.stuff.Decorations;

public class Decoration extends GameObject {

    Decorations typeOf;

    public Decoration(float scale, int x, int y, Decorations decoration) {
        super(decoration.getPath(), scale, x, y);
        typeOf = decoration;
    }

    public void draw() {
        getImage().draw(x, y);
    }

    @Override
    public void update(float shift, int delta) {
        y += shift * delta / Constants.DIVIDE_DELTA;
    }

    /**
     * EMPTY BODY
     * @param delta
     */
    @Override
    public void update(int delta) {

    }

}
