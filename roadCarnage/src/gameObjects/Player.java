package gameObjects;

import gameObjects.stuff.PlayerCars;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;

public class Player extends MovingObject {

    private int durability;
    private float mobility;
    private PlayerCars typeOfCar;

    public Player(float scale, int x, int y, Rectangle borders, PlayerCars car) {
        super(car.getImage(), scale, x, y, car.getSpeed(), borders);
        typeOfCar = car;
        durability = typeOfCar.getDurability();
        mobility = typeOfCar.getMobility();
    }

    public int getDurability() {
        return typeOfCar.getDurability();
    }

    public float getMobility() {
        return typeOfCar.getMobility();
    }

    public float getCurrentSpeed() {
        return speed;
    }

    public int getCurrentDurability() {
        return durability;
    }

    public float getCurrentMobility() {
        return mobility;
    }

    public boolean moveForward() {
        y -= speed;
        if (y <= startY()) {
            y = startY();
            return false;
        }
        return true;
    }

    public boolean moveBackward() {
        y += speed;
        if (y + height >= bordersHeight()+startY()) {
            y = bordersHeight() - height;
            return false;
        }
        return true;
    }

    public boolean moveRight() {
        x += getCurrentMobility();
        if (x + width >= startX() + bordersWidth()) {
            x = bordersWidth() + startX() - width ;
            return false;
        }
        return true;
    }

    public boolean moveLeft() {
        x -= getCurrentMobility();
        if (x <= startX()) {
            x = startX();
            return false;
        }
        return true;
    }

    public void draw(){
        getImage().draw(x,y);
    }

}
