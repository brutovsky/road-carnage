package gameObjects;

import gameObjects.stuff.Constants;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;


public class Road extends GameObject {
    public static final String PATH = "\\res\\roadSkins\\desert.jpg";
    public static final float X = 200;
    public static final float Y = 0;
    public static final float WIDTH = 600;
    public static final float HEIGHT = 700;
    public static final float STRIP_LENGTH = 100;
    public static final float ROUGH_ROAD_LENGTH = 70;
    public static final Rectangle DANGER_ZONE_LEFT = new Rectangle(X,Y,57,states.Game.HEIGHT);
    public static final Rectangle DANGER_ZONE_RIGHT= new Rectangle(737,0,63,states.Game.HEIGHT);
    public static final int STRIP1 = 2;
    public static final int STRIP2 = 3;
    public static final int STRIP3 = 4;
    public static final int ROUGH_ROAD1 = 1;
    public static final int ROUGH_ROAD2 = 5;
    //public static final int SPEED = 1;
    public static final Rectangle FULL_ROAD = new Rectangle(X, Y, WIDTH, HEIGHT);
    public static final Rectangle ROAD = new Rectangle(X + ROUGH_ROAD_LENGTH, Y, WIDTH - 2 * ROUGH_ROAD_LENGTH, HEIGHT);
    private int id;
    Image road, secondRoad;
    float  yS;


    public Road() throws SlickException{
        super(new Image(PATH), 1f, (1000 - new Image(PATH).getWidth()) / 2, -500);
        this.road = getImage();
        this.secondRoad = getImage();
        yS = -road.getHeight();
    }


    /*public void update(float shift) {
        y += shift * 5f;
        yS += shift * 5f;
        if (y > 700) {
            y = -800;
        }
        if (yS > 700) {
            yS = -800;
        }
    }*/

    public void update(float shift, int delta) {
        y += shift* delta / Constants.DIVIDE_DELTA;
        yS += shift * delta / Constants.DIVIDE_DELTA;
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
                return strip%5;
            }
        }
    }


    @Override
    public void draw() {
        road.draw(x, y);
        secondRoad.draw(x, yS);
    }


}
