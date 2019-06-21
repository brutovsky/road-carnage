package gameObjects.stuff;

import gameObjects.Animator;
import org.newdawn.slick.Image;

public enum Cars {
    TRUCK("res/cars/truck.png", "Truck", 150f),
    TAXI("res/cars/taxi.png", "Taxi", 230f),
    HOTDOG("res/cars/hotdog.png", "HOTDOG", 500f),
    CASUAL_BLACK("res/cars/blackCar.png", "BLACK", 300f),
    CASUAL_GREEN("res/cars/greenCar.png", "GREEN", 200f),
    CASUAL_BLUE("res/cars/blueCar.png", "BLUE", 100f),
    MEGABUS("res/cars/megabus.png", "MEGABUS", 100f),
    ICECREAM("res/cars/icecream.png", "ICECREAM", 500f),
    POLICE("res/cars/police.png", "ICECREAM", 400f),
    AMBULANCE("res/cars/ambulance.png", "ICECREAM", 800f);
    private float speed;
    private String name;
    private String path;

    Cars(String path, String name, float speed) {
        this.speed = speed;
        this.name = name;
        this.path = path;
    }

    public float getSpeed() {
        return speed;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }
}
