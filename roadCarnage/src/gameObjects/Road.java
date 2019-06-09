package gameObjects;

import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;


public class Road extends StaticObject {

    private int id;
    Image road, secondRoad;
    int[] duration = {200, 200};
    float x, y, yS = -road.getHeight();

    public Road(Image image, float scale, int x, int y, MovingObject player) {
        super(image, scale, x, y, player);
        this.road = image;
        this.secondRoad = image;
        this.x = (1000 - image.getWidth()) / 2;
        this.y = y;
        road.draw(x, y);
        secondRoad.draw(x, yS);


    }


    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        Input input = gameContainer.getInput();
        if (input.isKeyDown(Input.KEY_UP)) {
            y += 5 * 1f;
            yS += 5 * 1f;
            if (y > 710) {
                road.draw(x, -854);
                y = -854;
            }
            if (yS > 710) {
                secondRoad.draw(x, -854);
                yS = -854;
            }

        }
    }
}
