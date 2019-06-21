package gameObjects;

import gameObjects.stuff.Constants;
import gameObjects.stuff.Obstacles;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Obstacle extends GameObject {
    Obstacles typeOf;
    public static final int ONE_LINE_SIZE = 1;
    public static final int TWO_LINES_SIZE = 2;
    public static final int THREE_LINES_SIZE = 3;
    public static final int FOUR_LINES_SIZE = 4;


    public Obstacle(float scale, float x, float y, Obstacles obstacle) {
        super(Animator.animate(obstacle.getPath(),obstacle.getColumns(),obstacle.getLines(),100,true), scale, x , y);
        if(obstacle.getName().equals("FALLEN TREE")){
            setImageForFallenTree();
            System.out.println("HELLO");
        }
        typeOf = obstacle;
    }

    private void setImageForFallenTree() {
        int num = Constants.random.nextInt(4)+1;
        String path = "res/obstacles/fallenTree" + num +".png";
        Animation anim = new Animation();
        anim.addFrame(Animator.createImage(path),100);
        setAnimation(anim);
        setImage(anim.getImage(0));
    }

    public void draw() {
        getAnimation().draw(x, y);
    }

    @Override
    public void update(float shift, int delta) {
        y += (shift * delta) / Constants.DIVIDE_DELTA;
    }

    @Override
    public int collisionOccured() {
        return typeOf.collision();
    }

    public String getName(){
        return typeOf.getName();
    }

    public Obstacles getType() {
        return typeOf;
    }
}
