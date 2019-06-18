package gameObjects.levelGenerators;

import gameObjects.*;
import gameObjects.stuff.Bonuses;
import gameObjects.stuff.Constants;

import java.util.HashMap;
import java.util.Random;

import static gameObjects.stuff.Cars.*;
import static gameObjects.stuff.Cars.TRUCK;
import static gameObjects.stuff.Obstacles.*;
import static gameObjects.stuff.Obstacles.TRAMPOLINE;

public abstract class LevelGenerator {

    protected float stage_y;

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

    public void createObstacles(Road road) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                GameObject object = getObstacles().get(grid[i][j]);
                if (object == null) {
                    continue;
                } else if (object instanceof Obstacle) {
                    switch (((Obstacle) object).getType()) {
                        case CACTUS: {
                            road.getObstacles().add(new Obstacle(1f, road.getLineX(j + 1), Road.Y - (i + 1) * stage_y, CACTUS));
                            continue;
                        }
                        case DUNA: {
                            Obstacle duna = new Obstacle(1f, Road.CENTR, Road.Y - (i + 1) * stage_y, DUNA);
                            road.getObstacles().add(duna);
                            int r = Constants.random.nextInt(4) + 1;
                            float ty = duna.getY() + duna.getHeight();
                            float tx = road.getLineX(r);
                            System.out.println(r);
                            road.getObstacles().add(new Obstacle(1f, tx, ty, TRAMPOLINE));
                            j = grid[i].length;
                            break;
                        }
                        case HOLE: {
                            road.getObstacles().add(new Obstacle(1f, road.getLineX(j + 1), Road.Y - (i + 1) * stage_y, HOLE));
                            continue;
                        }
                        case KONUS: {
                            road.getObstacles().add(new Obstacle(1f, road.getLineX(j + 1), Road.Y - (i + 1) * stage_y, KONUS));
                            continue;
                        }
                        case TRAMPOLINE: {
                            road.getObstacles().add(new Obstacle(1f, road.getLineX(j + 1), Road.Y - (i + 1) * stage_y, TRAMPOLINE));
                            continue;
                        }
                        default: {
                            System.out.println("NO OBSTACLE");
                        }
                    }
                } else if (object instanceof Car) {
                    switch (((Car) object).getType()) {
                        case CASUAL_BLACK: {
                            road.getObstacles().add(new Car(1f, road.getLineX(j + 1), Road.Y - (i + 1) * stage_y, Road.ROAD, CASUAL_BLACK));
                            continue;
                        }
                        case CASUAL_BLUE: {
                            road.getObstacles().add(new Car(1f, road.getLineX(j + 1), Road.Y - (i + 1) * stage_y, Road.ROAD, CASUAL_BLUE));
                            continue;
                        }
                        case CASUAL_GREEN: {
                            road.getObstacles().add(new Car(1f, road.getLineX(j + 1), Road.Y - (i + 1) * stage_y, Road.ROAD, CASUAL_GREEN));
                            continue;
                        }
                        case HOTDOG: {
                            road.getObstacles().add(new Car(1f, road.getLineX(j + 1), Road.Y - (i + 1) * stage_y, Road.ROAD, HOTDOG));
                            continue;
                        }
                        case TAXI: {
                            road.getObstacles().add(new Car(1f, road.getLineX(j + 1), Road.Y - (i + 1) * stage_y, Road.ROAD, TAXI));
                            continue;
                        }
                        case TRUCK: {
                            road.getObstacles().add(new Car(1f, road.getLineX(j + 1), Road.Y - (i + 1) * stage_y, Road.ROAD, TRUCK));
                            continue;
                        }
                        default: {
                            System.out.println("NO CAR");
                        }
                    }
                } else if (object instanceof Bonus) {
                    switch (((Bonus) object).getType()) {
                        case TOMAT:{
                            road.getObstacles().add(new Bonus(1f, road.getLineX(j + 1), Road.Y - (i + 1) * stage_y, Bonuses.TOMAT));
                            continue;
                        }
                        case BARRIER: {
                            road.getObstacles().add(new Bonus(1f, road.getLineX(j + 1), Road.Y - (i + 1) * stage_y, Bonuses.BARRIER));
                            continue;
                        }
                        case CHERRY: {
                            road.getObstacles().add(new Bonus(1f, road.getLineX(j + 1), Road.Y - (i + 1) * stage_y, Bonuses.CHERRY));
                            continue;
                        }
                        case FAN: {
                            road.getObstacles().add(new Bonus(1f, road.getLineX(j + 1), Road.Y - (i + 1) * stage_y, Bonuses.FAN));
                            continue;
                        }
                        case FIRE: {
                            road.getObstacles().add(new Bonus(1f, road.getLineX(j + 1), Road.Y - (i + 1) * stage_y, Bonuses.FIRE));
                            continue;
                        }
                        case ICE: {
                            road.getObstacles().add(new Bonus(1f, road.getLineX(j + 1), Road.Y - (i + 1) * stage_y, Bonuses.ICE));
                            continue;
                        }
                        case SURPRISE: {
                            road.getObstacles().add(new Bonus(1f, road.getLineX(j + 1), Road.Y - (i + 1) * stage_y, Bonuses.SURPRISE));
                            continue;
                        }
                        case WRENCH: {
                            road.getObstacles().add(new Bonus(1f, road.getLineX(j + 1), Road.Y - (i + 1) * stage_y, Bonuses.WRENCH));
                            continue;
                        }
                        default: {
                            System.out.println("NO BONUS");
                        }
                    }
                }
            }
        }
    }

    private int getRandomType() {
        int sum = 0;
        int c = new Random().nextInt(101);
        sum += none_chance;
        if (c <= sum) {
            return TYPE_NONE;
        }
        sum += obstacle_chance;
        if (c <= sum) {
            return TYPE_OBSTACLES;
        }
        sum += car_chance;
        if (c <= sum) {
            return TYPE_CARS;
        }
        return TYPE_BONUSES;
    }


    public void createKonus(Road road){
        Obstacle obstacle = new Obstacle(1f,Road.CENTR,-Road.HEIGHT/2, KONUS);
        road.getObstacles().add(obstacle);
    }

}
