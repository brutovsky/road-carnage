package gameObjects.levelGenerators;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import gameObjects.*;
import gameObjects.stuff.Bonuses;
import gameObjects.stuff.Cars;
import gameObjects.stuff.Constants;
import gameObjects.stuff.Obstacles;

import java.util.HashMap;
import java.util.Random;

import static gameObjects.stuff.Cars.*;
import static gameObjects.stuff.Obstacles.*;

public class DessertLevel extends LevelGenerator {

    private boolean isDuna;

    private static final float STAGE_Y = 200;
    //private static final float STAGE2_Y = 175*2;
    //private static final float STAGE3_Y = 175;

    public DessertLevel() {
        super(3, 4);
    }

    public void initObstacles() {
        super.initObstacles();
        int i = 0;
        getObstacles().put(i++, null);
        getObstacles().put(i++, new Obstacle(1f, X, Y, Obstacles.CACTUS));
        getObstacles().put(i++, new Obstacle(1f, X, Y, Obstacles.HOLE));
        getObstacles().put(i++, new Obstacle(1f, X, Y, Obstacles.TRAMPOLINE));
        getObstacles().put(i++, new Car(1f, X, Y, Road.ROAD, Cars.TRUCK));
        getObstacles().put(i++, new Car(1f, X, Y, Road.ROAD, Cars.TAXI));
        getObstacles().put(i++, new Car(1f, X, Y, Road.ROAD, Cars.CASUAL_BLUE));
        getObstacles().put(i++, new Car(1f, X, Y, Road.ROAD, Cars.CASUAL_GREEN));
        getObstacles().put(i++, new Car(1f, X, Y, Road.ROAD, CASUAL_BLACK));
        getObstacles().put(i++, new Bonus(1f, X, Y, Bonuses.TOMAT));
        getObstacles().put(i++, new Bonus(1f, X, Y, Bonuses.CHERRY));
        getObstacles().put(i++, new Bonus(1f, X, Y, Bonuses.SURPRISE));
        getObstacles().put(i++, new Bonus(1f, X, Y, Bonuses.FIRE));
        getObstacles().put(i++, new Bonus(1f, X, Y, Bonuses.ICE));
        getObstacles().put(i++, new Bonus(1f, X, Y, Bonuses.BARRIER));
        getObstacles().put(i++, new Bonus(1f, X, Y, Bonuses.WRENCH));
        getObstacles().put(i++, new Bonus(1f, X, Y, Bonuses.FAN));

        auxiliaryList = 2;

        getObstacles().put(i++, new Obstacle(1f, X, Y, Obstacles.DUNA));
        getObstacles().put(i++, new Obstacle(1f, X, Y, Obstacles.KONUS));
    }

    @Override
    public void initProbability() {
        super.initProbability();
        int i = 0;
        bonus_chance = 5;
        none_chance = 50;
        car_chance = 10;
        obstacle_chance = 35;
        getProbability().put(i++, none_chance);//0
        //obstacles
        getProbability().put(i++, 40);//1
        getProbability().put(i++, 20);//2
        getProbability().put(i++, 30);//3
        //cars
        getProbability().put(i++, 20);
        getProbability().put(i++, 20);
        getProbability().put(i++, 20);
        getProbability().put(i++, 20);
        getProbability().put(i++, 20);
        //bonuses
        getProbability().put(i++, 30);
        getProbability().put(i++, 10);
        getProbability().put(i++, 10);
        getProbability().put(i++, 10);
        getProbability().put(i++, 10);
        getProbability().put(i++, 10);
        getProbability().put(i++, 10);
        getProbability().put(i++, 10);
        //aux
        getProbability().put(i++, 20);//DUNA
        getProbability().put(i++, 33);//KONUS
    }

    @Override
    public void generate() {
        generateStage1();
        generateStage2();
        //generateStage3();
    }

    private void generateStage1() {
        int stage = 0;
        int c = Constants.random.nextInt(101);
        int sum = 0;
        int type = TYPE_NONE;
        if (c <= getProbability().get(getObstacleIdByName("DUNA"))) {
            for (int i = 0; i < grid[0].length; i++) {
                grid[stage][i] = getObstacleIdByName("DUNA");
            }
            return;
        }
        for (int i = 0; i < grid[stage].length; i++) {
            c = Constants.random.nextInt(101);
            type = getRandomType();
            if (type == TYPE_NONE) {
                grid[stage][i] = getObstacleIdByName("noname");
            } else {
                c = Constants.random.nextInt(101);
                sum = 0;
                for (int j = getFirstObstacleTypeId(type); j <= getLastObstacleTypeId(type); j++) {
                    sum += getProbability().get(j);
                    if (c <= sum) {
                        grid[stage][i] = j;
                        break;
                    }
                }
            }
        }

    }

    private void generateStage2() {
//
        int stage = 1;
        int c = 0;
        int sum = 0;
        int type = TYPE_NONE;
        for (int i = 0; i < grid[stage].length; i++) {
            type = getRandomType();
            c = Constants.random.nextInt(101);
            if (type == TYPE_NONE) {
                grid[stage][i] = getObstacleIdByName("noname");
            } else {
                c = Constants.random.nextInt(101);
                sum = 0;
                for (int j = getFirstObstacleTypeId(type); j <= getLastObstacleTypeId(type); j++) {
                    sum += getProbability().get(j);
                    if (c <= sum) {
                        if(type == TYPE_BONUSES){
                            if(checkForId(j)){
                                grid[stage][i] = getObstacleIdByName("noname");
                                break;
                            }
                        }
                        grid[stage][i] = j;
                        break;
                    }
                }
            }
        }
//
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

    private void generateStage3() {
//
        int stage = 2;
        int c = 0;
        int sum = 0;
        int type = TYPE_NONE;
        for (int i = 0; i < grid[stage].length; i++) {
            type = getRandomType();
            c = Constants.random.nextInt(101);
            if (type == TYPE_NONE) {
                grid[stage][i] = getObstacleIdByName("noname");
            } else {
                c = Constants.random.nextInt(101);
                sum = 0;
                for (int j = getFirstObstacleTypeId(type); j <= getLastObstacleTypeId(type); j++) {
                    sum += getProbability().get(j);
                    if (c <= sum) {
                        grid[stage][i] = j;
                        break;
                    }
                }
            }
        }
        //
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
                            road.getObstacles().add(new Obstacle(1f, road.getLineX(j + 1), Road.Y - (i + 1) * STAGE_Y, CACTUS));
                            continue;
                        }
                        case DUNA: {
                            Obstacle duna = new Obstacle(1f, Road.CENTR, Road.Y - (i + 1) * STAGE_Y, DUNA);
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
                            road.getObstacles().add(new Obstacle(1f, road.getLineX(j + 1), Road.Y - (i + 1) * STAGE_Y, HOLE));
                            continue;
                        }
                        case KONUS: {
                            road.getObstacles().add(new Obstacle(1f, road.getLineX(j + 1), Road.Y - (i + 1) * STAGE_Y, KONUS));
                            continue;
                        }
                        case TRAMPOLINE: {
                            road.getObstacles().add(new Obstacle(1f, road.getLineX(j + 1), Road.Y - (i + 1) * STAGE_Y, TRAMPOLINE));
                            continue;
                        }
                        default: {
                            System.out.println("NO OBSTACLE");
                        }
                    }
                } else if (object instanceof Car) {
                    switch (((Car) object).getType()) {
                        case CASUAL_BLACK: {
                            road.getObstacles().add(new Car(1f, road.getLineX(j + 1), Road.Y - (i + 1) * STAGE_Y, Road.ROAD, CASUAL_BLACK));
                            continue;
                        }
                        case CASUAL_BLUE: {
                            road.getObstacles().add(new Car(1f, road.getLineX(j + 1), Road.Y - (i + 1) * STAGE_Y, Road.ROAD, CASUAL_BLUE));
                            continue;
                        }
                        case CASUAL_GREEN: {
                            road.getObstacles().add(new Car(1f, road.getLineX(j + 1), Road.Y - (i + 1) * STAGE_Y, Road.ROAD, CASUAL_GREEN));
                            continue;
                        }
                        case HOTDOG: {
                            road.getObstacles().add(new Car(1f, road.getLineX(j + 1), Road.Y - (i + 1) * STAGE_Y, Road.ROAD, HOTDOG));
                            continue;
                        }
                        case TAXI: {
                            road.getObstacles().add(new Car(1f, road.getLineX(j + 1), Road.Y - (i + 1) * STAGE_Y, Road.ROAD, TAXI));
                            continue;
                        }
                        case TRUCK: {
                            road.getObstacles().add(new Car(1f, road.getLineX(j + 1), Road.Y - (i + 1) * STAGE_Y, Road.ROAD, TRUCK));
                            continue;
                        }
                        default: {
                            System.out.println("NO CAR");
                        }
                    }
                } else if (object instanceof Bonus) {
                    switch (((Bonus) object).getType()) {
                        case TOMAT:{
                            road.getObstacles().add(new Bonus(1f, road.getLineX(j + 1), Road.Y - (i + 1) * STAGE_Y, Bonuses.TOMAT));
                            continue;
                        }
                        case BARRIER: {
                            road.getObstacles().add(new Bonus(1f, road.getLineX(j + 1), Road.Y - (i + 1) * STAGE_Y, Bonuses.BARRIER));
                            continue;
                        }
                        case CHERRY: {
                            road.getObstacles().add(new Bonus(1f, road.getLineX(j + 1), Road.Y - (i + 1) * STAGE_Y, Bonuses.CHERRY));
                            continue;
                        }
                        case FAN: {
                            road.getObstacles().add(new Bonus(1f, road.getLineX(j + 1), Road.Y - (i + 1) * STAGE_Y, Bonuses.FAN));
                            continue;
                        }
                        case FIRE: {
                            road.getObstacles().add(new Bonus(1f, road.getLineX(j + 1), Road.Y - (i + 1) * STAGE_Y, Bonuses.FIRE));
                            continue;
                        }
                        case ICE: {
                            road.getObstacles().add(new Bonus(1f, road.getLineX(j + 1), Road.Y - (i + 1) * STAGE_Y, Bonuses.ICE));
                            continue;
                        }
                        case SURPRISE: {
                            road.getObstacles().add(new Bonus(1f, road.getLineX(j + 1), Road.Y - (i + 1) * STAGE_Y, Bonuses.SURPRISE));
                            continue;
                        }
                        case WRENCH: {
                            road.getObstacles().add(new Bonus(1f, road.getLineX(j + 1), Road.Y - (i + 1) * STAGE_Y, Bonuses.WRENCH));
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

    public void createKonus(Road road){
        Obstacle obstacle = new Obstacle(1f,Road.CENTR,-Road.HEIGHT/2, KONUS);
        road.getObstacles().add(obstacle);
    }

}
