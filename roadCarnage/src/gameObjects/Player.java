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
    private boolean jumping;
    private boolean falling;
    private int counter;
    private Animation immortalAnimation;
    private Animation jumpAnimation;
    private Animation fallAnimation;
    private int jumpAnimDur = 50;
    private int fallAnimDur = 100;


    public Player(float scale, float x, float y, Rectangle borders, PlayerCars car) {
        super(car.getImage(), scale, x, y, car.getSpeed(), borders);
        typeOfCar = car;
        durability = typeOfCar.getDurability();
        mobility = typeOfCar.getMobility();
        if (durability >= 0) {
            unbroken = true;
        }
        immortal = false;
        counter = 0;
        try {
            Image temp = new Image(typeOfCar.getPath() + "Immortal" + ".png").getScaledCopy(scale);
            immortalAnimation = new Animation();
            immortalAnimation.addFrame(getImage(), 100);
            immortalAnimation.addFrame(temp, 100);
        } catch (SlickException e) {
            e.printStackTrace();
        }

        jumpAnimation = new Animation();
        jumpAnimation.addFrame(getImage().getScaledCopy(1.1f), jumpAnimDur);
        jumpAnimation.addFrame(getImage().getScaledCopy(1.15f), jumpAnimDur);
        jumpAnimation.addFrame(getImage().getScaledCopy(1.20f), jumpAnimDur);
        jumpAnimation.addFrame(getImage().getScaledCopy(1.25f), jumpAnimDur);
        jumpAnimation.addFrame(getImage().getScaledCopy(1.30f), jumpAnimDur);
        jumpAnimation.addFrame(getImage().getScaledCopy(1.35f), jumpAnimDur);
        jumpAnimation.addFrame(getImage().getScaledCopy(1.40f), jumpAnimDur);
        jumpAnimation.addFrame(getImage().getScaledCopy(1.45f), jumpAnimDur);
        jumpAnimation.addFrame(getImage().getScaledCopy(1.50f), jumpAnimDur);
        jumpAnimation.addFrame(getImage().getScaledCopy(1.45f), jumpAnimDur);
        jumpAnimation.addFrame(getImage().getScaledCopy(1.40f), jumpAnimDur);
        jumpAnimation.addFrame(getImage().getScaledCopy(1.30f), jumpAnimDur);
        jumpAnimation.addFrame(getImage().getScaledCopy(1.25f), jumpAnimDur);
        jumpAnimation.addFrame(getImage().getScaledCopy(1.20f), jumpAnimDur);
        jumpAnimation.addFrame(getImage().getScaledCopy(1.15f), jumpAnimDur);
        jumpAnimation.addFrame(getImage().getScaledCopy(1.1f), jumpAnimDur);
        jumpAnimation.setLooping(false);

        fallAnimation = new Animation();
        fallAnimation.addFrame(getImage().getScaledCopy(0.9f), fallAnimDur);
        fallAnimation.addFrame(getImage().getScaledCopy(0.8f), fallAnimDur);
        fallAnimation.addFrame(getImage().getScaledCopy(0.7f), fallAnimDur);
        fallAnimation.addFrame(getImage().getScaledCopy(0.6f), fallAnimDur);
        fallAnimation.addFrame(getImage().getScaledCopy(0.5f), fallAnimDur);
        fallAnimation.addFrame(getImage().getScaledCopy(0.4f), fallAnimDur);
        fallAnimation.addFrame(getImage().getScaledCopy(0.3f), fallAnimDur);
        fallAnimation.addFrame(getImage().getScaledCopy(0.2f), fallAnimDur);
        fallAnimation.addFrame(getImage().getScaledCopy(0.1f), fallAnimDur);
        fallAnimation.addFrame(getImage().getScaledCopy(0.05f), fallAnimDur);
        fallAnimation.setLooping(false);
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
        y -= speed * delta / Constants.DIVIDE_DELTA;
        if (y <= startY()) {
            y = startY();
            return false;
        }
        return true;
    }

    public boolean moveBackward(int delta) {
        y += getCurrentMobility()*0.3*speed * delta / Constants.DIVIDE_DELTA;
        if (y + height >= bordersHeight() + startY()) {
            y = bordersHeight() - height;
            return false;
        }
        return true;
    }

    public boolean moveRight(int delta) {
        x += getCurrentMobility() * delta / Constants.DIVIDE_DELTA;
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
        if (jumping) {
            jumpAnimation.draw(x, y);
        } else if (immortal) {
            immortalAnimation.draw(x, y);
        } else if(falling){
            y -= 0.5;
            fallAnimation.draw(x,y);
        }
        else {
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

    public boolean checkForCollision(Rectangle object) {
        float thisTop = y;
        float thisBottom = thisTop + height;
        float thisLeft = x;
        float thisRight = thisLeft + width;

        float otherTop = object.getY();
        float otherBottom = otherTop + object.getHeight();
        float otherLeft = object.getX();
        float otherRight = otherLeft + object.getWidth();

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
                    counter = 3;
                }
                break;
            }
            case Constants
                    .DEAD_END: {
                durability = 0;
                unbroken = false;
                falling = true;
                setAnimation(fallAnimation);
                break;
            }
            case Constants
                    .JUMP: {
                jumping = true;
                setAnimation(jumpAnimation);
                break;
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
            counter += delta;
            if (counter >= 5000) {
                immortal = false;
                counter = 0;
            }
        } else if (jumping) {
            counter += (jumpAnimation.getFrameCount() * jumpAnimDur) / 60;
            if (counter >= jumpAnimation.getFrameCount() * jumpAnimDur) {
                jumping = false;
            }
        } else if (falling) {
            counter += (fallAnimation.getFrameCount() * fallAnimDur) / 40;
            if (counter >= jumpAnimation.getFrameCount() * fallAnimDur) {
                falling = false;
            }
        }

    }

    public boolean isJumping() {
        return jumping;
    }

    public boolean isFalling() {
        return falling;
    }

    public void dangerZone() {
        if (Constants.random.nextInt(1001) < Constants.RISK) {
            collision(Constants.MINUS_DURABILITY);
        }
    }
}
