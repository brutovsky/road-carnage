package gameObjects;

import gameObjects.stuff.Constants;
import gameObjects.stuff.Obstacles;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;

public class Obstacle extends GameObject {
    Obstacles typeOf;
    public static final int ONE_LINE_SIZE = 1;
    public static final int TWO_LINES_SIZE = 2;
    public static final int THREE_LINES_SIZE = 3;
    public static final int FOUR_LINES_SIZE = 4;


    public Obstacle(float scale, float x, float y, Obstacles obstacle) {
        super(obstacle.getAnimation(), scale, x - obstacle.getImage().getWidth()/2, y);
        typeOf = obstacle;
    }

    public void draw() {
        getAnimation().draw(x, y);
    }

    @Override
    public void update(float shift, int delta) {
        y += shift * delta / Constants.DIVIDE_DELTA;
    }

    @Override
    public int collisionOccured() {
        return typeOf.collision();
    }
}
