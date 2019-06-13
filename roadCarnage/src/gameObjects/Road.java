package gameObjects;

import gameObjects.stuff.Constants;
import gameObjects.stuff.Decorations;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;
import java.util.List;


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
    public static final float LINE2 = X + ROUGH_ROAD_WIDTH + BLACK_LINE_WIDTH + STRIP_LENGTH / 2;
    public static final float LINE3 = X + ROUGH_ROAD_WIDTH + BLACK_LINE_WIDTH + 1.5f * STRIP_LENGTH + YELLOW_LINE_WIDTH;
    public static final float LINE4 = X + ROUGH_ROAD_WIDTH + BLACK_LINE_WIDTH + 2.5f * STRIP_LENGTH + YELLOW_LINE_WIDTH + CENTER_LINES_WIDTH;
    public static final float LINE5 = X + ROUGH_ROAD_WIDTH + BLACK_LINE_WIDTH + 3.5f * STRIP_LENGTH + 2 * YELLOW_LINE_WIDTH + CENTER_LINES_WIDTH;
    public static final float LINE6 = X + ROUGH_ROAD_WIDTH + 2 * BLACK_LINE_WIDTH + 4 * STRIP_LENGTH + 2 * YELLOW_LINE_WIDTH + CENTER_LINES_WIDTH;
    public static final Rectangle DANGER_ZONE_LEFT = new Rectangle(X, Y, ROUGH_ROAD_WIDTH, HEIGHT);
    public static final Rectangle DANGER_ZONE_RIGHT = new Rectangle(LINE6, Y, ROUGH_ROAD_WIDTH, HEIGHT);
    public static final float WIDTH = 2 * ROUGH_ROAD_WIDTH + 2 * BLACK_LINE_WIDTH + 4 * STRIP_LENGTH + 2 * YELLOW_LINE_WIDTH + CENTER_LINES_WIDTH;
    public static final float ROAD_END = X + WIDTH;
    public static final float CENTR = X + WIDTH/2;
    public static final Rectangle FULL_ROAD = new Rectangle(X, Y, WIDTH, HEIGHT);
    public static final Rectangle ROAD = new Rectangle(X + ROUGH_ROAD_WIDTH, Y, WIDTH - 2 * ROUGH_ROAD_WIDTH, HEIGHT);
    private int id;
    Image road, secondRoad;
    float yS;

    private List<GameObject> line1;
    private List<GameObject> line2;
    private List<GameObject> line3;
    private List<GameObject> line4;
    private List<GameObject> line5;
    private List<GameObject> line6;

    {
        line1 = new ArrayList();
        line2 = new ArrayList();
        line3 = new ArrayList();
        line4 = new ArrayList();
        line5 = new ArrayList();
        line6 = new ArrayList();
    }


    public Road() throws SlickException {
        super(new Image(PATH), 1f, 0, 0);
        x = states.Game.WIDTH - getImage().getWidth();
        y = states.Game.HEIGHT - getImage().getHeight();
        this.road = getImage();
        this.secondRoad = getImage();
        yS = -road.getHeight();
    }


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

    public List<GameObject> getLine1() {
        return line1;
    }

    public List<GameObject> getLine2() {
        return line2;
    }

    public List<GameObject> getLine3() {
        return line3;
    }

    public List<GameObject> getLine4() {
        return line4;
    }

    public List<GameObject> getLine5() {
        return line5;
    }

    public List<GameObject> getLine6() {
        return line6;
    }

    public List<GameObject> getAllLines(){
        ArrayList<GameObject> list = new ArrayList<>();
        list.addAll(line1);
        list.addAll(line2);
        list.addAll(line3);
        list.addAll(line4);
        list.addAll(line5);
        list.addAll(line6);
        return list;
    }
}
