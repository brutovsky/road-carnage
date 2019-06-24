package gameObjects.stuff;

import gameObjects.Animator;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public enum PlayerCars {
    ANISTON("res/playerCars/aniston", "Aniston BD4", 100f, 1, 100f, 0),
    Stinger("res/playerCars/stinger", "Stinger", 300f, 2, 200f, 100),
    Z_TYPE("res/playerCars/ztype", "Z-Type", 300f, 4, 300f, 200),
    FURORE("res/playerCars/furore", "Furore GT", 500f, 3, 400f, 400),
    TANK("res/playerCars/tank","Tank",200f,5,100,1000);
    private Image image;
    private float speed;
    private int durability;
    private float mobility;
    private int price;
    private String name;
    private String path;

    PlayerCars(String path, String name, float speed, int durability, float mobility, int price) {
        this.path = path;
        image = Animator.createImage(path+".png");
        this.speed = speed;
        this.durability = durability;
        this.mobility = mobility;
        this.price = price;
        this.name = name;
    }

    public Image getImage() {
        return image;
    }

    public float getSpeed() {
        return speed;
    }

    public int getDurability() {
        return durability;
    }

    public float getMobility() {
        return mobility;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }
}
