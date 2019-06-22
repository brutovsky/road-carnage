package gameObjects;


import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class GameMenu implements Drawable {

    private float exit_x;
    private float exit_y;

    private Animation exit0;
    private Animation exit1;
    private Animation exit;
    private float indent = 100;

    public GameMenu() {
        createExitAnimations();
        exit = exit0;

    }

    private void createExitAnimations() {
        Image temp = null;
        exit0 = new Animation();
        exit1 = new Animation();
        //0
        try {
            temp = new Image("res/menu/exit0.png");
        } catch (SlickException e) {
            e.printStackTrace();
        }
        exit0 = Animator.animate(temp, 3, 1, 100, true);
        //1
        try {
            temp = new Image("res/menu/exit1.png");
        } catch (SlickException e) {
            e.printStackTrace();
        }
        exit1 = Animator.animate(temp, 3, 1, 100, true);
    }

    @Override
    public void update(float shift, int delta) {

    }

    @Override
    public void update(int delta) {

    }

    public void update(int delta, float mouse_x, float mouse_y) {
        if (isMouseOnExit(mouse_x, mouse_y)) {
            exit = exit1;
        }else{
            exit = exit0;
        }
        updateExitLocation();
    }

    @Override
    public void draw() {
        exit.draw(exit_x, exit_y);
    }

    public void updateExitLocation() {
        exit_x = Road.CENTR - exit.getWidth() / 2;
        exit_y = Road.HEIGHT / 2 - exit.getHeight() / 2 + indent;
    }

    public boolean isMouseOnExit(float x, float y) {
        if (x >= exit_x && x <= exit_x + exit.getImage(0).getWidth() && y >= exit_y && y <= exit_y + exit.getImage(0).getHeight()) {
            return true;
        } else {
            return false;
        }
    }


}
