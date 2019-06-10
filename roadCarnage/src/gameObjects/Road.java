package gameObjects;

import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;


public class Road extends StaticObject {
    public static final float X = 195;
    public static final float Y = 0;
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
        y += player.speed * 3f;
        yS += player.speed* 3f;
        if (y > 800) {
            road.draw(x, -800);
            y = -800;
        }
        if (yS > 800) {
            secondRoad.draw(x, -800);
            yS = -800;
        }
    }


    @Override
    public void draw() {
        road.draw(x, y);
        secondRoad.draw(x, yS);
    }


}
