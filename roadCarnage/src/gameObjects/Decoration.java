package gameObjects;

import gameObjects.stuff.Constants;
import gameObjects.stuff.Decorations;

public class Decoration extends GameObject {


    public Decoration(float scale, int x, int y, Decorations decoration) {
        super(decoration.getImage(), scale, x, y);

    }

    public void draw() {
        getImage().draw(x, y);
    }

    @Override
    public void update(float shift, int delta) {
        y += shift * delta / Constants.DIVIDE_DELTA;
    }

}
