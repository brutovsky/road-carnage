package gameObjects;

import org.newdawn.slick.*;


public class Road extends StaticObject {
    public Road(Image image, float scale, int x, int y, MovingObject player) {
        super(image, scale, x, y, player);
        createAnimation();

    }

    private void createAnimation() {
        Animation roadAnimation ;
        Image roadImage;
        try {
             roadImage  = new Image("");
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
