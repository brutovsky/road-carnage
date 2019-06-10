package gameObjects;

import gameObjects.stuff.Constants;
import gameObjects.stuff.PlayerCars;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public class Player extends MovingObject {

    private int durability;
    private float mobility;
    private PlayerCars typeOfCar;
    private boolean unbroken;
    private boolean immortal;
    private int immortal_counter;
    private Animation immortalAnimation;


    public Player(float scale, int x, int y, Rectangle borders, PlayerCars car) {
        super(car.getImage(), scale, x, y,car.getSpeed(),borders);
        typeOfCar = car;
        durability = typeOfCar.getDurability();
        mobility = typeOfCar.getMobility();
        if (durability >= 0) {
            unbroken = true;
        }
        immortal = false;
        immortal_counter = 0;
        try {
            Image temp = new Image(typeOfCar.getPath()+"Immortal"+".png").getScaledCopy(scale);
            immortalAnimation = new Animation();
            immortalAnimation.addFrame(getImage(),100);
            immortalAnimation.addFrame(temp,100);
        } catch (SlickException e) {
            e.printStackTrace();
        }
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

    public boolean moveForward(int delta) {
        y -= speed * delta/ Constants.DIVIDE_DELTA;
        if (y <= startY()) {
            y = startY();
            return false;
        }
        return true;
    }

    public boolean moveBackward(int delta) {
        y += speed * delta/ Constants.DIVIDE_DELTA;
        if (y + height >= bordersHeight() + startY()) {
            y = bordersHeight() - height;
            return false;
        }
        return true;
    }

    public boolean moveRight(int delta) {
        x += getCurrentMobility() * delta/ Constants.DIVIDE_DELTA;
        if (x + width >= startX() + bordersWidth()) {
            x = bordersWidth() + startX() - width;
            return false;
        }
        return true;
    }

    public boolean moveLeft(int delta) {
        x -= getCurrentMobility() * delta / Constants.DIVIDE_DELTA;
        if (x <= startX()) {
            x = startX();
            return false;
        }
        return true;
    }

    public void draw() {
        if (immortal) {
            immortalAnimation.draw(x, y);
        } else {
            getImage().draw(x, y);
        }
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
                if (durability <= 0) {
                    unbroken = false;
                } else {
                    immortal = true;
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

    public boolean isImmortal() {
        return immortal;
    }

    @Override
    public float getSpeed() {
        return typeOfCar.getSpeed();
    }

    @Override
    public void update(int delta) {
        if (immortal) {
            immortal_counter += delta;
            if (immortal_counter >= 5000) {
                immortal = false;
                immortal_counter = 0;
            }
        }
    }
}
