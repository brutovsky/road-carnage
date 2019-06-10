package gameObjects.stuff;

import gameObjects.Obstacle;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import java.util.Random;

public enum Obstacles {
    CACTUS("res/obstacles/cactus", "CACTUS", 1, 1, Obstacle.ONE_LINE_SIZE,Constants.MINUS_DURABILITY),
    DUNA("res/obstacles/duna.png", "DUNA", 1, 1,Obstacle.THREE_LINES_SIZE,Constants.MINUS_DURABILITY);
    private Animation animation;
    private Image image;
    private SpriteSheet sprite_sheet;
    private int collision;
    private int size;

    Obstacles(String path, String name, int columns, int lines, int size, int collision) {
        this.collision = collision;
        animation = new Animation();
        try {
            if (path.endsWith("cactus")) {
                Random random = new Random();
                image = new Image(path + (random.nextInt(5) + 1) + ".png");
                animation.addFrame(image, 100);
                return;
            } else {
                image = new Image(path);
            }
        } catch (SlickException e) {
            e.printStackTrace();
        }
        int spriteSheetWidth = image.getWidth();
        int spriteSheetHeight = image.getHeight();
        int spriteWidth = (int) (spriteSheetWidth / columns);
        int spriteHeight =
                (int) (spriteSheetHeight / lines);
        sprite_sheet = new SpriteSheet(image,
                spriteWidth,
                spriteHeight);
        for (int y = 0; y < lines; y++) {
            for (int x = 0; x < columns; x++) {
                animation.addFrame(
                        sprite_sheet.getSprite(x, y), 100);
            }
        }
    }

    public Animation getAnimation() {
        return animation;
    }

    public Image getImage() {
        return image;
    }

    public int getSize() {
        return size;
    }

    public int collision() {
        return collision;
    }
}
