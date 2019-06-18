package gameObjects.levelGenerators;

import gameObjects.*;

import java.util.HashMap;

public abstract class LevelGenerator {
    protected final int stages;
    protected final int[][] grid;
    protected final int roadLines;
    protected int none_chance;
    protected int car_chance;
    protected int obstacle_chance;
    protected int bonus_chance;
    private HashMap<Integer, GameObject> obstacles;
    private HashMap<Integer, Integer> probability;
    public static final float X = Road.X;
    public static final float Y = -Road.HEIGHT;

    public static final int TYPE_NONE = 0;
    public static final int TYPE_OBSTACLES = 1;
    public static final int TYPE_CARS = 2;
    public static final int TYPE_BONUSES = 3;

    protected int auxiliaryList=0;

    LevelGenerator(int stages, int roadLines) {
        this.stages = stages;
        this.roadLines = roadLines;
        grid = new int[stages][roadLines];
        initObstacles();
        initProbability();
    }

    public void initObstacles() {
        obstacles = new HashMap<>();
    }

    public void initProbability() {
        none_chance = 25;
        car_chance = 25;
        obstacle_chance = 25;
        bonus_chance = 25;
        probability = new HashMap<>();
    }

    public void initBonuses() {
        obstacles = new HashMap<>();
    }

    public void generate() {

    }

    public HashMap<Integer, GameObject> getObstacles() {
        return obstacles;
    }

    public HashMap<Integer, Integer> getProbability() {
        return probability;
    }

    public int getObstacleIdByName(String name) {
        for (int i = 0; i < getObstacles().size(); i++) {
            if (getObstacles().get(i) == null) {
                continue;
            }
            if (getObstacles().get(i).getName().equals(name)) {
                return i;
            }
        }
        return 0;
    }

    public int getLastObstacleTypeId(int type) {
        for (int i = getObstacles().size()-auxiliaryList; i > 0; i--) {
            if (type == TYPE_NONE) {
                if (getObstacles().get(i) == null) {
                    return i;
                }
            }
            if (type == TYPE_OBSTACLES) {
                if (getObstacles().get(i) instanceof Obstacle) {
                    return i;
                }
            }
            if (type == TYPE_CARS) {
                if (getObstacles().get(i) instanceof Car) {
                    return i;
                }
            }
            if (type == TYPE_BONUSES) {
                if (getObstacles().get(i) instanceof Bonus) {
                    return i;
                }
            }
        }
        return 0;
    }

    public int getFirstObstacleTypeId(int type) {
        for (int i = 0; i < getObstacles().size() - auxiliaryList; i++) {
            if (type == TYPE_NONE) {
                if (getObstacles().get(i) == null) {
                    return i;
                }
            }
            if (type == TYPE_OBSTACLES) {
                if (getObstacles().get(i) instanceof Obstacle) {
                    return i;
                }
            }
            if (type == TYPE_CARS) {
                if (getObstacles().get(i) instanceof Car) {
                    return i;
                }
            }
            if (type == TYPE_BONUSES) {
                if (getObstacles().get(i) instanceof Bonus) {
                    return i;
                }
            }
        }
        return 0;
    }

    public int[][] getGrid() {
        return grid;
    }

    public boolean checkForId(int id){
        for(int[] array:grid){
            for(int i:array){
                if(i == id){
                    return true;
                }
            }
        }
        return false;
    }
    public int howManyId(int id){
        int counter = 0;
        for(int[] array:grid){
            for(int i:array){
                if(i == id){
                    counter++;
                }
            }
        }
        return counter;
    }
}
