package gameObjects;

import gameObjects.stuff.Constants;
import gameObjects.stuff.PlayerCars;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;

public class Player extends MovingObject {

    private int durability;
    private float mobility;
    private PlayerCars typeOfCar;
    private boolean unbroken;
    private boolean immortal;
    private int immortal_counter;

    public Player(float scale, int x, int y, Rectangle borders, PlayerCars car) {
        super(car.getImage(), scale, x, y, car.getSpeed(), borders);
        typeOfCar = car;
        durability = typeOfCar.getDurability();
        mobility = typeOfCar.getMobility();
        if(durability >= 0){
            unbroken = true;
        }
        immortal = false;
        immortal_counter = 0;
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
        if (y + height >= bordersHeight() + startY()) {
            y = bordersHeight() - height;
            return false;
        }
        return true;
    }

    public boolean moveRight() {
        x += getCurrentMobility();
        if (x + width >= startX() + bordersWidth()) {
            x = bordersWidth() + startX() - width;
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

    public void draw() {
        getImage().draw(x, y);
    }

    public boolean checkForCollision(GameObject object) {
        float thisTop = y;
        float thisBottom = thisTop + height;
        float thisLeft = x;
        float thisRight = thisLeft + width;

        float otherTop = object.y;
        float otherBottom = otherTop + object.height;
        float otherLeft = object.x;
        float otherRight = otherLeft + object.width;

        if (thisBottom < otherTop) return (false);
        if (thisTop > otherBottom) return (false);

        if (thisRight < otherLeft) return (false);
        if (thisLeft > otherRight) return (false);

        return (true);
    }

    public void collision(int collision) {
        switch (collision) {
            case Constants
                    .MINUS_DURABILITY: {
                durability--;
                if(durability <= 0){
                    unbroken = false;
                }else{
                    immortal_counter = 3;
                }
            }
        }
    }

    public boolean isUnbroken() {
        return unbroken;
    }

    public void setUnbroken(boolean unbroken) {
        this.unbroken = unbroken;
    }
}
