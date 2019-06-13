package gameObjects.levelGenerators;

import gameObjects.GameObject;
import gameObjects.Road;

import java.util.HashMap;

public abstract class LevelGenerator {
    protected final int stages;
    protected int[][] grid;
    protected final int roadLines;
    private HashMap<Integer, GameObject> obstacles;
    static final float X = Road.X;
    static final float Y = -Road.HEIGHT;

    LevelGenerator(int stages,int roadLines){
        this.stages = stages;
        this.roadLines = roadLines;
        grid = new int[stages][roadLines];
        obstacles = new HashMap<>();
        initObstacles();
    }

    public void initObstacles(){

    }

    public void generate(){

    }

}
