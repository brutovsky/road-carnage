package gameObjects.stuff;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import java.util.Random;

public enum Decorations {

    TREE("\\res\\decorations\\tree"+(new Random().nextInt(9))+".png", 1f );

    private Image image;
    private float scale;

    Decorations(String path, float scale) {
        try {
            image = new Image(path);
        } catch (SlickException e) {
            e.printStackTrace();
        }
        this.scale = scale;

    }

    public Image getImage() {
        return image;
    }

    public float getScale() {
        return scale;
    }


}
