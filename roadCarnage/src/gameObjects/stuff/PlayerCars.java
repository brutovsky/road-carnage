package gameObjects.stuff;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public enum PlayerCars {
    ANISTON("res/playerCars/playerCar.png", "Aniston", 5f, 1, 5f, 0);
    private Image image;
    private float speed;
    private int durability;
    private float mobility;
    private int price;
    private String name;

    PlayerCars(String path, String name, float speed, int durability, float mobility, int price) {
        try {
            image = new Image(path);
        } catch (SlickException e) {
            e.printStackTrace();
        }
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
}
