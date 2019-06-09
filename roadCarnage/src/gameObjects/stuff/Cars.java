package gameObjects.stuff;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public enum Cars {
    TRUCK("res/cars/truck.png", "Truck", 1f),
    TAXI("res/cars/taxi.png", "Taxi", 1.5f);
    private Image image;
    private float speed;
    private String name;

    Cars(String path, String name, float speed) {
        try {
            image = new Image(path);
        } catch (SlickException e) {
            e.printStackTrace();
        }
        this.speed = speed;
        this.name = name;
    }

    public Image getImage() {
        return image;
    }

    public float getSpeed() {
        return speed;
    }
    public String getName() {
        return name;
    }
}
