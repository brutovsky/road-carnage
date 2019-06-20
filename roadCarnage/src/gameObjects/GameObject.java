package gameObjects;

import gameObjects.stuff.Constants;
import org.newdawn.slick.*;

public abstract class GameObject implements Drawable{
    protected float x;
    protected float y;
    protected float width;
    protected float height;
    private Image image;
    private Animation animation;
    private float scale;

    public GameObject(Image image, float scale, float x, float y) {
        this.scale = scale;
        this.image = image.getScaledCopy(scale);
        this.animation = new Animation();
        animation.addFrame(image,100);
        width = this.image.getWidth();
        height = this.image.getHeight();
        this.x = x - image.getWidth()/2;
        this.y = y;
    }

    public GameObject(Animation animation, float scale, float x, float y) {
        Animation temp = new Animation();
        for(int i =0;i < animation.getFrameCount();i++){
            temp.addFrame(animation.getImage(i).getScaledCopy(scale),animation.getDuration(i));
        }
        this.image = temp.getImage(0);
        this.animation = temp;
        width = this.image.getWidth();
        height = this.image.getHeight();
        this.x = x - image.getWidth()/2;
        this.y = y;
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

    /**
     * EMPTY BODY
     * @param delta
     */
    public void update(int delta){

    }

    /**
     * EMPTY BODY
     * @param shift
     * @param delta
     */
    @Override
    public void update(float shift, int delta) {

    }

    /**
     * EMPTY BODY
     */
    @Override
    public void draw() {

    }

    public void setAnimation(Animation animation) {
        this.animation = animation;
    }

    public String getName(){
        return "noname";
    }

    public int collisionOccured(){
        return Constants.NO_OUTPUT;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public float getScale() {
        return scale;
    }


}
