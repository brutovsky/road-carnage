package gameObjects;

import gameObjects.stuff.Cars;
import gameObjects.stuff.Constants;
import org.newdawn.slick.geom.Rectangle;

public class Car extends MovingObject{

    private Cars typeOf;

    public Car(float scale, float x, float y, Rectangle borders, Cars car) {
        super(Animator.createImage(car.getPath()), scale, x, y, car.getSpeed(), borders);
        typeOf = car;
    }

    @Override
    public void update(float shift,int delta) {
        y += ((speed+shift)*delta)/Constants.DIVIDE_DELTA;
    }

    @Override
    public void draw() {
        getImage().draw(x,y);
    }

    @Override
    public int collisionOccured() {
        return Constants.MINUS_DURABILITY;
    }

    public Cars getType() {
        return typeOf;
    }

    public String getName(){
        return typeOf.getName();
    }
}
