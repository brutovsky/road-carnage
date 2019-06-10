package gameObjects;

import gameObjects.stuff.Obstacles;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;

public class Obstacle extends GameObject {
    public static final int ONE_LINE_SIZE = 1;
    public static final int TWO_LINES_SIZE = 2;
    public static final int THREE_LINES_SIZE = 3;

    public Obstacle(float scale, float x, float y, Obstacles obstacle) {
        super(obstacle.getAnimation(), scale, x, y);
    }
}
