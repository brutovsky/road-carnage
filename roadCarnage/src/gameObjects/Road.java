package gameObjects;

import org.newdawn.slick.Image;

public class Road extends StaticObject {
    public Road(Image image, float scale, int x, int y, MovingObject player) {
        super(image, scale, x, y, player);
    }
}
