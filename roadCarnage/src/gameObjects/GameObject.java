package gameObjects;

import gameObjects.stuff.Constants;
import org.newdawn.slick.*;

public class GameObject {
    protected float x;
    protected float y;
    protected int width;
    protected int height;
    private Image image;
    private Animation animation;

    public GameObject(Image image, float scale, float x, float y) {
        this.image = image.getScaledCopy(scale);
        this.animation = new Animation();
        animation.addFrame(image,100);
        this.x = x;
        this.y = y;
        width = this.image.getWidth();
        height = this.image.getHeight();
    }

    public GameObject(Animation animation, float scale, float x, float y) {
        Animation temp = new Animation();
        for(int i =0;i < animation.getFrameCount();i++){
            temp.addFrame(animation.getImage(i).getScaledCopy(scale),animation.getDuration(i));
        }
        this.image = temp.getImage(0);
        this.animation = temp;
        this.x = x;
        this.y = y;
        width = this.image.getWidth();
        height = this.image.getHeight();
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Animation getAnimation() {
        return animation;
    }

    public void setAnimation(Animation animation) {
        this.animation = animation;
    }

    public void update(float shift, int delta){

    }

    public void update(int delta){

    }

    public void draw(){

    }

    public int collisionOccured(){
        return Constants.NO_OUTPUT;
    }
}
