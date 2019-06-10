package gameObjects;

import gameObjects.stuff.Obstacles;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;

public class Obstacle extends GameObject {

    public Obstacle(float scale, float x, float y, Obstacles obstacle) {
        super(obstacle.getAnimation(), scale, x, y);
    }
}
