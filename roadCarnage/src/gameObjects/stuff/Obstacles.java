package gameObjects.stuff;

import gameObjects.Animator;
import gameObjects.Obstacle;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import java.util.Random;

public enum Obstacles {
    CACTUS("res/obstacles/cactus1.png", "CACTUS", 1, 1, Obstacle.ONE_LINE_SIZE,Constants.MINUS_DURABILITY),
    DUNA("res/obstacles/duna.png", "DUNA", 1, 1,Obstacle.FOUR_LINES_SIZE,Constants.MINUS_DURABILITY),
    PENGUINS("res/obstacles/penguins.png", "PENGUINS", 1, 1,Obstacle.FOUR_LINES_SIZE,Constants.MINUS_DURABILITY),
    KONUS("res/obstacles/stop.png", "KONUS", 1, 1,Obstacle.ONE_LINE_SIZE,Constants.MINUS_DURABILITY),
    HOLE("res/obstacles/hole.png", "HOLE", 1, 1,Obstacle.ONE_LINE_SIZE,Constants.DEAD_END),
    TRAMPOLINE("res/obstacles/trampoline.png", "TRAMPOLINE", 5, 1,Obstacle.ONE_LINE_SIZE,Constants.JUMP),
    ICE_POOL("res/obstacles/ice_pool.png", "ICE POOL", 1, 1,Obstacle.ONE_LINE_SIZE,Constants.NO_MOVABILITY),
    ROAD_BARRIER("res/obstacles/roadBarrier.png","ROAD BARRIER",1,1,Obstacle.ONE_LINE_SIZE,Constants.MINUS_DURABILITY),
    WOLF("res/obstacles/wolf.png","WOLF",1,1,Obstacle.ONE_LINE_SIZE,Constants.MINUS_DURABILITY),
    FALLEN_TREE("res/obstacles/fallenTree1.png","FALLEN TREE",1,1,Obstacle.TWO_LINES_SIZE,Constants.MINUS_DURABILITY),
    BIG_HOLE("res/obstacles/big_hole.png","BIG HOLE",1,1,Obstacle.FOUR_LINES_SIZE,Constants.DEAD_END),
    CENTRE_HOLE("res/obstacles/centre_hole.png","BIG CENTRE HOLE",1,1,Obstacle.ONE_LINE_SIZE,Constants.DEAD_END);
    private int collision;
    private String name;
    private String path;
    private int columns;
    private int lines;
    private int size;

    Obstacles(String path, String name, int columns, int lines, int size, int collision) {
        this.path = path;
        this.name = name;
        this.collision = collision;
        this.columns = columns;
        this.lines = lines;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public int collision() {
        return collision;
    }

    public int getColumns() {
        return columns;
    }

    public int getLines() {
        return lines;
    }

    public String getPath() {
        return path;
    }
}
