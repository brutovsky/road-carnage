package gameObjects.stuff;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public enum Cars {
    TRUCK("res/cars/truck.png", "Truck", 150f),
    TAXI("res/cars/taxi.png", "Taxi", 230f),
    HOTDOG("res/cars/hotdog.png","HOTDOG",500f),
    CASUAL_BLACK("res/cars/blackCar.png","BLACK",300f),
    CASUAL_GREEN("res/cars/greenCar.png","GREEN",200f),
    CASUAL_BLUE("res/cars/blueCar.png","BLUE",100f);
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
