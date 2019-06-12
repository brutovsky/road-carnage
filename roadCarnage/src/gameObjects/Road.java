package gameObjects;

import gameObjects.stuff.Constants;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;



public class Road extends GameObject {

    public static final float X = 200;
    public static final float Y = 0;
    public static final float HEIGHT = 700;

    public static final String PATH = "res\\roadSkins\\desert" + ".png";

    public static final float ROUGH_ROAD_WIDTH = 56;
    public static final float BLACK_LINE_WIDTH = 13;
    public static final float YELLOW_LINE_WIDTH = 11;
    public static final float CENTER_LINES_WIDTH = 25;
    public static final float STRIP_LENGTH = 101;

    public static final float LINE1 = X;
    public static final float LINE2 = X+ROUGH_ROAD_WIDTH+BLACK_LINE_WIDTH + STRIP_LENGTH/2;
    public static final float LINE3 = X+ROUGH_ROAD_WIDTH+BLACK_LINE_WIDTH+1.5f*STRIP_LENGTH+YELLOW_LINE_WIDTH;
    public static final float LINE4 = X+ROUGH_ROAD_WIDTH+BLACK_LINE_WIDTH+2.5f*STRIP_LENGTH+YELLOW_LINE_WIDTH+CENTER_LINES_WIDTH;
    public static final float LINE5 = X+ROUGH_ROAD_WIDTH+BLACK_LINE_WIDTH+3.5f*STRIP_LENGTH+2*YELLOW_LINE_WIDTH + CENTER_LINES_WIDTH;
    public static final float LINE6 = X+ROUGH_ROAD_WIDTH+2*BLACK_LINE_WIDTH+4*STRIP_LENGTH+2*YELLOW_LINE_WIDTH + CENTER_LINES_WIDTH;
    public static final Rectangle DANGER_ZONE_LEFT = new Rectangle(X,Y,ROUGH_ROAD_WIDTH,HEIGHT);
    public static final Rectangle DANGER_ZONE_RIGHT= new Rectangle(LINE6,Y,ROUGH_ROAD_WIDTH,HEIGHT);
    public static final float WIDTH = 2*ROUGH_ROAD_WIDTH+2*BLACK_LINE_WIDTH+4*STRIP_LENGTH+2*YELLOW_LINE_WIDTH + CENTER_LINES_WIDTH;
    public static final float ROAD_END = X + WIDTH;
    public static final float CENTR = X + WIDTH/2;
    public static final Rectangle FULL_ROAD = new Rectangle(X, Y, WIDTH, HEIGHT);
    public static final Rectangle ROAD = new Rectangle(X + ROUGH_ROAD_WIDTH, Y, WIDTH - 2 * ROUGH_ROAD_WIDTH, HEIGHT);
    private int id;
    Image road, secondRoad;
    float yS;

    public Road() throws SlickException {
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


    @Override
    public void draw() {
        road.draw(x, y);
        secondRoad.draw(x, yS);

    }
}
