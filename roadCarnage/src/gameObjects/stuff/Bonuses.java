package gameObjects.stuff;

import gameObjects.Animator;
import gameObjects.Obstacle;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public enum Bonuses {
    CHERRY("res/bonuses/cherry.png", "CHERRY", 3, 1, Constants.BONUS_CHERRY),
    SURPRISE("res/bonuses/surprise.png", "SURPRISE", 3, 1, Constants.BONUS_SURPRISE),
    FIRE("res/bonuses/fire.png", "FIRE", 3, 1, Constants.BONUS_FIRE),
    ICE("res/bonuses/ice.png", "ICE", 3, 1, Constants.BONUS_ICE),
    BARRIER("res/bonuses/barrier.png", "BARRIER", 3, 1, Constants.BONUS_BARRIER),
    WRENCH("res/bonuses/wrench.png", "WRENCH", 3, 1, Constants.BONUS_WRENCH),
    FAN("res/bonuses/fan.png", "FAN", 3, 1, Constants.BONUS_FAN),
    TOMAT("res/bonuses/tomat.png", "TOMAT", 1, 1, Constants.BONUS_TOMAT);
    private int collision;
    private String name;
    private String path;
    private int columns;
    private int lines;

    Bonuses(String path, String name, int columns, int lines, int collision) {
        this.path = path;
        this.collision = collision;
        this.name = name;
        this.columns = columns;
        this.lines =lines;
    }

    public int collision() {
        return collision;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public int getLines() {
        return lines;
    }

    public int getColumns() {
        return columns;
    }
}
