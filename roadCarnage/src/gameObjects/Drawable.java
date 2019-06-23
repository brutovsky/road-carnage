package gameObjects;

public interface Drawable {
    public void update(float shift, int delta);

    public void update(int delta);

    public void draw();
}
