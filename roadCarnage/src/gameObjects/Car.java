package gameObjects;

import gameObjects.stuff.Cars;
import gameObjects.stuff.Constants;
import org.newdawn.slick.geom.Rectangle;
/**
 * @author Vadym Nakytniak
 * Car object class
 */
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
        if(typeOf == Cars.POLICE){
            return Constants.DEAD_END;
        }
        return Constants.MINUS_DURABILITY;
    }

    public Cars getType() {
        return typeOf;
    }

    public String getName(){
        return typeOf.getName();
    }
}
