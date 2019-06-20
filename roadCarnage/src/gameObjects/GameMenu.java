package gameObjects;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class GameMenu implements Drawable {
    Animation exit0 ;
    Animation exit1 ;
    Animation exit ;
    public GameMenu(){
        createExitAnimations();
    }

    private void createExitAnimations() {
        exit0 = new Animation();
        exit1 = new Animation();

        //0
        Image image = null;
        SpriteSheet sprite_sheet = null;
        int columns = 3;
        int lines = 1;
        try {
            image = new Image("res/menu/exit0.png");
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
                exit0.addFrame(
                        sprite_sheet.getSprite(x, y), 100);
            }
        }
        exit0.setLooping(true);
        //1
        image = null;
        sprite_sheet = null;
        columns = 3;
        lines = 1;
        try {
            image = new Image("res/menu/exit1.png");
        } catch (SlickException e) {
            e.printStackTrace();
        }
        spriteSheetWidth = image.getWidth();
        spriteSheetHeight = image.getHeight();
        spriteWidth = (int) (spriteSheetWidth / columns);
        spriteHeight =
                (int) (spriteSheetHeight / lines);
        sprite_sheet = new SpriteSheet(image,
                spriteWidth,
                spriteHeight);
        for (int y = 0; y < lines; y++) {
            for (int x = 0; x < columns; x++) {
                exit1.addFrame(
                        sprite_sheet.getSprite(x, y), 100);
            }
        }
        exit1.setLooping(true);
    }

    @Override
    public void update(float shift, int delta) {

    }

    @Override
    public void update(int delta) {

    }

    @Override
    public void draw() {
        exit0.draw(50,50);
        exit1.draw(50,100);
    }
}
