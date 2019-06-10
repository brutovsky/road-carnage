package gameObjects;

import gameObjects.stuff.Cars;
import gameObjects.stuff.Constants;
import org.newdawn.slick.geom.Rectangle;

public class Car extends MovingObject{

    private Cars typeOfCar;

    public Car(float scale, float x, float y, Rectangle borders, Cars car) {
        super(car.getImage(), scale, x, y, car.getSpeed(), borders);
        typeOfCar = car;
    }

    @Override
    public void update() {
        y += speed;
    }


    @Override
    public void draw() {
        getImage().draw(x,y);
    }

    @Override
    public int collisionOccured() {
        return Constants.MINUS_DURABILITY;
    }
}
