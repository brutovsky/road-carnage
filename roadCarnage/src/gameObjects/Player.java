package gameObjects;

import gameObjects.stuff.Constants;
import gameObjects.stuff.PlayerCars;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Rectangle;

public class Player extends MovingObject {

    private int durability;
    private float mobility;
    private PlayerCars typeOfCar;
    private boolean broken;

    private boolean immortal;
    private boolean jumping;
    private boolean falling;
    private boolean slipping;

    private float counter;
    private Animation immortalAnimation;
    private Animation jumpAnimation;
    private Animation fallAnimation;
    private Animation explosionAnimation;
    //private Animation slipAnimation;
    private Image wasted;
    private Image badtomat;

    private int immortalAnimDur = 100;
    private int jumpAnimDur = 60;
    private int fallAnimDur = 100;
    private int immortalTimer = 5;
    private int jumpingTimer;

    private float slipTimer = 1;
    private float slipCounter = 0;

    private int bonusTimer = 10;
    private float bonusCounter = 0;
    private boolean bonusActive = false;
    private boolean isTomat;


    public Player(float scale, float x, float y, Rectangle borders, PlayerCars car) {
        super(car.getImage(), scale, x, y, car.getSpeed(), borders);
        typeOfCar = car;
        setCarImage();
        durability = typeOfCar.getDurability();
        mobility = typeOfCar.getMobility();
        if (durability >= 0) {
            broken = true;
        }
        immortal = false;
        jumping = false;
        falling = false;
        counter = 0;
        wasted =   Animator.createImage("res/playerCars/wasted.png");
        badtomat = Animator.createImage("res/obstacles/badtomat.png");
        setImmortlaAnim();
        setJumpAnim();
        setFallAnim();
        setExplosionAnim();
    }

    private void setImmortlaAnim() {
        Image temp = Animator.createImage(typeOfCar.getPath() + "Immortal" + ".png").getScaledCopy(getScale());
        immortalAnimation = new Animation();
        immortalAnimation.addFrame(getImage(), immortalAnimDur);
        immortalAnimation.addFrame(temp, immortalAnimDur);
        immortalAnimation.setLooping(true);
    }

    private void setCarImage() {
        setImage(Animator.createImage(typeOfCar.getPath()+".png").getScaledCopy(getScale()));
    }

    public void setExplosionAnim() {
        explosionAnimation = new Animation();
        Image image = null;
        SpriteSheet sprite_sheet = null;
        int columns = 15;
        int lines = 1;
        image = Animator.createImage("res/playerCars/explosion.png");
        int spriteSheetWidth = image.getWidth();
        int spriteSheetHeight = image.getHeight();
        int spriteWidth = (int) (spriteSheetWidth / columns);
        int spriteHeight =
                (int) (spriteSheetHeight / lines);
        sprite_sheet = new SpriteSheet(image,
                spriteWidth,
                spriteHeight);
        for (int y = 0; y < lines; y++) {
            for (int x = 0; x < columns; x++) {
                explosionAnimation.addFrame(
                        sprite_sheet.getSprite(x, y), 100);
            }
        }
        explosionAnimation.setLooping(false);
    }

    private void setFallAnim() {
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
        fallAnimation.addFrame(getImage().getScaledCopy(0.05f), fallAnimDur);
        fallAnimation.setLooping(false);
    }

    private void setJumpAnim() {
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
        jumpAnimation.addFrame(getImage().getScaledCopy(1.35f), jumpAnimDur);
        jumpAnimation.addFrame(getImage().getScaledCopy(1.30f), jumpAnimDur);
        jumpAnimation.addFrame(getImage().getScaledCopy(1.25f), jumpAnimDur);
        jumpAnimation.addFrame(getImage().getScaledCopy(1.20f), jumpAnimDur);
        jumpAnimation.addFrame(getImage().getScaledCopy(1.15f), jumpAnimDur);
        jumpAnimation.addFrame(getImage().getScaledCopy(1.1f), jumpAnimDur);
        jumpAnimation.addFrame(getImage().getScaledCopy(1f), jumpAnimDur);
        jumpAnimation.setLooping(false);
        jumpingTimer = ((jumpAnimation.getFrameCount()) * jumpAnimDur) / Constants.DIVIDE_DELTA;
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
        y -= speed * delta * 1f / 1000;
        if (y <= startY()) {
            y = startY();
            return false;
        }
        return true;
    }

    public boolean moveBackward(int delta) {
        y += speed * delta * 1f / 1000;
        if (y + height >= bordersHeight() + startY()) {
            y = bordersHeight() - height;
            return false;
        }
        return true;
    }

    public boolean moveRight(int delta) {
        x += getCurrentMobility() * delta * 1f / 1000;
        if (x + width >= startX() + bordersWidth()) {
            x = bordersWidth() + startX() - width;
            return false;
        }
        return true;
    }

    public boolean moveLeft(int delta) {
        x -= getCurrentMobility() * delta * 1f / 1000;
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
        } else if (falling) {
            wasted.draw(50, 100);
        } else {
            getImage().draw(x, y);
        }
        if (isTomat) {
            badtomat.draw(Road.CENTR - badtomat.getWidth() / 2, Road.Y);
        }
    }

    public void collision(int collision) {
        switch (collision) {
            case Constants
                    .MINUS_DURABILITY: {
                if(slipping){
                    toNormalMode();
                }
                durability--;
                if (durability <= 0) {
                    broken = false;
                } else {
                    immortal = true;
                    counter = 0;
                }
                break;
            }
            case Constants
                    .DEAD_END: {
                if(slipping){
                    toNormalMode();
                }
                durability = 0;
                broken = false;
                falling = true;
                speed = 0;
                mobility = 0;
                setAnimation(fallAnimation);
                break;
            }
            case Constants
                    .JUMP: {
                if(slipping){
                    toNormalMode();
                }
                counter = 0;
                jumping = true;
                setAnimation(jumpAnimation);
                setJumpAnim();
                break;
            }
            case Constants.BONUS_BARRIER: {
                if(slipping){
                    toNormalMode();
                }
                immortal = true;
                counter = 0;
                break;
            }
            case Constants.BONUS_FIRE: {
                if(slipping){
                    toNormalMode();
                }
                bonusActive = true;
                speed *= 2;
                bonusCounter = 0;
                break;
            }
            case Constants.BONUS_ICE: {
                if(slipping){
                    toNormalMode();
                }
                bonusActive = true;
                speed /= 2;
                bonusCounter = 0;
                break;
            }
            case Constants.BONUS_WRENCH: {
                if(slipping){
                    toNormalMode();
                }
                durability++;
                break;
            }
            case Constants.BONUS_TOMAT: {
                if(slipping){
                    toNormalMode();
                }
                bonusActive = true;
                isTomat = true;
                bonusCounter = 0;
                break;
            }
            case Constants.BONUS_FAN: {
                if(slipping){
                    toNormalMode();
                }
                bonusActive = true;
                mobility *= 2;
                bonusCounter = 0;
                break;
            }
            case Constants.BONUS_SURPRISE: {
                if(slipping){
                    toNormalMode();
                }
                int bonus = 1000 + Constants.random.nextInt(7);
                collision(bonus);
                break;
            }
            case Constants.NO_MOVABILITY: {
                slipping = true;
                mobility = 0;
                slipCounter = 0;
                break;
            }
        }
    }

    public boolean isBroken() {
        return broken;
    }

    public void setBroken(boolean broken) {
        this.broken = broken;
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
            counter += (delta * 1f) / Constants.DIVIDE_DELTA;
            System.out.println(counter);
            if (counter >= immortalTimer) {
                immortal = false;
                counter = 0;
            }
        } else if (jumping) {
            counter += (delta * 1f) / Constants.DIVIDE_DELTA;
            System.out.println(counter);
            if (counter >= jumpingTimer) {
                jumping = false;
                counter = 0;
            }
        } else if (falling) {

        } else if (slipping) {
            slipCounter += (delta * 1f) / Constants.DIVIDE_DELTA;
            if (slipCounter >= slipTimer) {
                toNormalMode();
            } else {
                System.out.println("ROTATE");
                getImage().rotate(5);
            }
        }

        if (bonusActive) {
            bonusCounter += (delta * 1f) / Constants.DIVIDE_DELTA;
            System.out.println(bonusCounter);
            if (bonusCounter >= bonusTimer) {
                bonusActive = false;
                toNormalMode();
                bonusCounter = 0;
            }
        }


    }

    private void toNormalMode() {
        setCarImage();
        speed = getSpeed();
        mobility = getMobility();
        isTomat = false;
        slipping = false;
        System.out.println("NORMAL");
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
