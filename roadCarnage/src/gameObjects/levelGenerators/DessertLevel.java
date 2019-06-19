package gameObjects.levelGenerators;

import gameObjects.*;
import gameObjects.stuff.Bonuses;
import gameObjects.stuff.Cars;
import gameObjects.stuff.Constants;
import gameObjects.stuff.Obstacles;

import static gameObjects.stuff.Cars.*;

public class DessertLevel extends LevelGenerator {

    private boolean isDuna;

    public DessertLevel() {
        super(3, 4);
        stage_y = 200;
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
        getObstacles().put(i++, new Car(1f, X, Y, Road.ROAD, HOTDOG));

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
        getProbability().put(i++, 10);
        getProbability().put(i++, 20);
        getProbability().put(i++, 20);
        getProbability().put(i++, 20);
        getProbability().put(i++, 10);
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

}
