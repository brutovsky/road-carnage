package gameObjects.stuff;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public enum Bonuses {
    CHERRY("res/bonuses/cherry_sprite_list.png","CHERRY",3, 1,Constants.BONUS_CHERRY);
    private Animation animation;
    private Image image;
    private SpriteSheet sprite_sheet;
    private int collision;
    Bonuses(String path, String name, int columns,int lines,int collision) {
        this.collision = collision;
        animation = new Animation();
        try {
            image = new Image(path);
        } catch (SlickException e) {
            e.printStackTrace();
        }
        int spriteSheetWidth = image.getWidth();
        int spriteSheetHeight = image.getHeight();
        int spriteWidth = (int)(spriteSheetWidth/columns);
        int spriteHeight =
                (int)(spriteSheetHeight/lines);
        sprite_sheet = new SpriteSheet(image,
                spriteWidth,
                spriteHeight);
        for(int y = 0;y < lines;y++){
            for(int x = 0;x < columns;x++){
                animation.addFrame(
                        sprite_sheet.getSprite(x,y),100);
            }
        }

    }

    public Animation getAnimation() {
        return animation;
    }

    public Image getImage() {
        return image;
    }

    public int collision(){
        return collision;
    }
}
