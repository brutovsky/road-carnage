package gameObjects.stuff;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public enum Cars {
    TRUCK("res/cars/truck.png", "Truck", 1.5f),
    TAXI("res/cars/taxi.png", "Taxi", 2.3f),
    HOTDOG("res/cars/hotdog.png","HOTDOG",5f),
    CASUAL_BLACK("res/cars/blackCar.png","BLACK",3f),
    CASUAL_GREEN("res/cars/greenCar.png","GREEN",2f),
    CASUAL_BLUE("res/cars/blueCar.png","BLUE",1f);
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
