package gameObjects;

import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;


public class Road extends StaticObject {
    public static final float X = 195;
    public static final float Y = 0;
    public static final float WIDTH = 610;
    public static final float HEIGHT = 700;
    private int id;
    Image road, secondRoad;
    float x, y, yS;
    MovingObject player;


    public Road(Image image, float scale, int x, int y, MovingObject player) {
        super(image, scale, x, y, player);
        this.road = image;
        this.secondRoad = image;
        this.x = (1000 - image.getWidth()) / 2;
        this.y = y;
        this.player = player;
        yS = -road.getHeight();


    }

    @Override
    public void update() {
        y += player.speed * 2f;
        yS += player.speed* 2f;
        if (y > 710) {
            road.draw(x, -854);
            y = -854;
        }
        if (yS > 710) {
            secondRoad.draw(x, -854);
            yS = -854;
        }
    }

    @Override
    public void update(int delta) {
        y += player.speed * 2f*delta/10;
        yS += player.speed* 2f*delta/10;
        if (y > 710) {
            road.draw(x, -854);
            y = -854;
        }
        if (yS > 710) {
            secondRoad.draw(x, -854);
            yS = -854;
        }
    }


    @Override
    public void draw() {
        road.draw(x, y);
        secondRoad.draw(x, yS);
    }


}
