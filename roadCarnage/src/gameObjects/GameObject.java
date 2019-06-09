package gameObjects;

import org.newdawn.slick.*;

public class GameObject {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    private Image image;

    public GameObject(Image image,float scale){
        this.image = image.getScaledCopy(scale);
        x = 0;
        y = 0;
        width = this.image.getWidth();
        height = this.image.getHeight();
    }

    public GameObject(Image image,float scale,int x, int y){
        this.image = image.getScaledCopy(scale);
        this.x = x;
        this.y = y;
        width = this.image.getWidth();
        height = this.image.getHeight();
    }

}
