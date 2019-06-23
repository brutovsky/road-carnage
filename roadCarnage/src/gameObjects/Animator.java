package gameObjects;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Animator {

    private Animator(){

    }

    public static Animation animate(Image image,int columns,int lines,int duration,boolean looping){
        Animation animation = new Animation();
        SpriteSheet sprite_sheet = null;
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
                        sprite_sheet.getSprite(x, y), duration);
            }
        }
        animation.setLooping(looping);
        return animation;
    }

}
