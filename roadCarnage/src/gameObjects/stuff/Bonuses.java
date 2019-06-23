package gameObjects.stuff;

import gameObjects.Obstacle;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public enum Bonuses {
    CHERRY("res/bonuses/cherry.png","CHERRY",3, 1,Constants.BONUS_CHERRY),
    SURPRISE("res/bonuses/surprise.png","SURPRISE",3, 1,Constants.BONUS_SURPRISE),
    FIRE("res/bonuses/fire.png","FIRE",3, 1,Constants.BONUS_FIRE),
    ICE("res/bonuses/ice.png","ICE",3, 1,Constants.BONUS_ICE),
    BARRIER("res/bonuses/barrier.png","BARRIER",3, 1,Constants.BONUS_BARRIER),
    WRENCH("res/bonuses/wrench.png","WRENCH",3, 1,Constants.BONUS_WRENCH),
    FAN("res/bonuses/fan.png","FAN",3, 1,Constants.BONUS_FAN),
    TOMAT("res/bonuses/tomat.png", "TOMAT", 1, 1,Constants.BONUS_TOMAT);
    private Animation animation;
    private Image image;
    private SpriteSheet sprite_sheet;
    private int collision;
    private String name;
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
        this.name = name;
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

    public String getName() {
        return name;
    }
}
