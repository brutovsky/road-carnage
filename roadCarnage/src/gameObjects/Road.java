package gameObjects;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;


public class Road extends StaticObject {
    public static final float X = 195;
    public static final float Y = 0;
    public static final float WIDTH = 610;
    public static final float HEIGHT = 700;
    public static final float STRIP_LENGTH = 100;
    public static final float ROUGH_ROAD_LENGTH = 70;
    public static final int STRIP1 = 1;
    public static final int STRIP2 = 2;
    public static final int STRIP3 = 3;
    public static final int ROUGH_ROAD1 = 0;
    public static final int ROUGH_ROAD2 = 4;
    public static final int SPEED = 21;
    public static final Rectangle FULL_ROAD = new Rectangle(X, Y, WIDTH, HEIGHT);
    public static final Rectangle ROAD = new Rectangle(X + ROUGH_ROAD_LENGTH, Y, WIDTH - 2 * ROUGH_ROAD_LENGTH, HEIGHT);
    private int id;
    Image road, secondRoad;
    float x, y, yS;
    MovingObject player;


    public Road(Image image, float scale, int x, int y, MovingObject player) {
        super(image, scale, x, y, player);
        this.road = image;
        this.secondRoad = image;
        this.x = (1000 - image.getWidth()) / 2;
        this.y = -500;
        this.player = player;
        yS = -road.getHeight();

    }


    @Override
    public void update() {
        y += player.speed * 5f;
        yS += player.speed * 5f;
        if (y > 700) {
            y = -800;
        }
        if (yS > 700) {
            yS = -800;
        }
    }

    @Override
    public void update(int delta) {
        y += player.speed * delta *SPEED;
        yS += player.speed * delta*SPEED;
        if (y > 700) {
            y = -1500;
        }
        if (yS > 700) {
            yS = -1500;
        }
    }

    public float getStripX(int strip) {
        switch (strip) {
            case STRIP1: {
                return X + ROUGH_ROAD_LENGTH;
            }
            case STRIP2: {
                return X + ROUGH_ROAD_LENGTH + STRIP_LENGTH + 10;
            }
            case STRIP3: {
                return X + ROUGH_ROAD_LENGTH + 2 * STRIP_LENGTH + 40;
            }
            case ROUGH_ROAD1: {
                return X;
            }
            case ROUGH_ROAD2: {
                return X + ROUGH_ROAD_LENGTH + 3 * STRIP_LENGTH;
            }
            default: {
                return 0;
            }
        }
    }


    @Override
    public void draw() {
        road.draw(x, y);
        secondRoad.draw(x, yS);
    }


}
