package gameObjects.levelGenerators;

import gameObjects.*;
import gameObjects.stuff.Bonuses;
import gameObjects.stuff.Cars;
import gameObjects.stuff.Constants;
import gameObjects.stuff.Obstacles;

import java.util.HashMap;

public class DessertLevel extends LevelGenerator {

    private boolean isDuna;

    DessertLevel() {
        super(3, 4);

    }

    public void initObstacles() {
        int i = 0;
        getObstacles().put(i++, null);
        getObstacles().put(i++, new Obstacle(1f, X, Y, Obstacles.KONUS));
        getObstacles().put(i++, new Obstacle(1f, X, Y, Obstacles.DUNA));
        getObstacles().put(i++, new Obstacle(1f, X, Y, Obstacles.CACTUS));
        getObstacles().put(i++, new Obstacle(1f, X, Y, Obstacles.HOLE));
        getObstacles().put(i++, new Obstacle(1f, X, Y, Obstacles.TRAMPOLINE));
        getObstacles().put(i++, new Car(1f, X, Y, Road.ROAD, Cars.TRUCK));
        getObstacles().put(i++, new Car(1f, X, Y, Road.ROAD, Cars.TAXI));
        getObstacles().put(i++, new Car(1f, X, Y, Road.ROAD, Cars.CASUAL_BLUE));
        getObstacles().put(i++, new Car(1f, X, Y, Road.ROAD, Cars.CASUAL_GREEN));
        getObstacles().put(i++, new Car(1f, X, Y, Road.ROAD, Cars.CASUAL_BLACK));
        getObstacles().put(i++, new Bonus(1f, X, Y, Bonuses.CHERRY));
        getObstacles().put(i++, new Bonus(1f, X, Y, Bonuses.SURPRISE));
        getObstacles().put(i++, new Bonus(1f, X, Y, Bonuses.FIRE));
        getObstacles().put(i++, new Bonus(1f, X, Y, Bonuses.ICE));
        getObstacles().put(i++, new Bonus(1f, X, Y, Bonuses.BARRIER));
        getObstacles().put(i++, new Bonus(1f, X, Y, Bonuses.WRENCH));
        getObstacles().put(i++, new Bonus(1f, X, Y, Bonuses.FAN));
    }

    @Override
    public void initProbability() {
        int i = 0;
        bonus_chance = 5;
        none_chance = 50;
        car_chance = 10;
        obstacle_chance = 35;
        getProbability().put(i++, none_chance);//0
        //obstacles
        getProbability().put(i++, 33);//1
        getProbability().put(i++, 20);//2
        getProbability().put(i++, 50);//3
        getProbability().put(i++, 20);//4
        getProbability().put(i++, 30);//5
        //cars
        getProbability().put(i++, 20);
        getProbability().put(i++, 20);
        getProbability().put(i++, 20);
        getProbability().put(i++, 20);
        getProbability().put(i++, 20);
        //bonuses
        getProbability().put(i++, 40);
        getProbability().put(i++, 10);
        getProbability().put(i++, 10);
        getProbability().put(i++, 10);
        getProbability().put(i++, 10);
        getProbability().put(i++, 10);
        getProbability().put(i++, 10);
    }

    @Override
    public void generate() {
        generateStage1();
        //generateStage2();
        //generateStage3();
    }

    private void generateStage1() {
        int c = Constants.random.nextInt(101);
        int sum = 0;
        int type = TYPE_NONE;
        if (c <= getProbability().get(getObstacleIdByName("DUNA"))) {
            for (int i = 0; i < grid[0].length; i++) {
                grid[0][i] = getObstacleIdByName("DUNA");
            }
            return;
        }
        for (int i = 0; i < grid[0].length; i++) {
            c = Constants.random.nextInt(101);
            sum += none_chance;
            if (c <= sum) {
                type = TYPE_NONE;
            }
            sum += obstacle_chance;
            if (c <= sum) {
                type = TYPE_OBSTACLES;
            }
            sum += car_chance;
            if (c <= sum) {
                type = TYPE_CARS;
            }
            sum += bonus_chance;
            if (c <= sum) {
                type = TYPE_BONUSES;
            }
            if (type == TYPE_NONE) {
                grid[0][i] = getObstacleIdByName("noname");
            } else {
                c = Constants.random.nextInt(101);
                sum = 0;
                for (int j = getLastObstacleTypeId(type); j >= getFirstObstacleTypeId(type); j++) {
                    sum += getProbability().get(j);
                    if (c <= sum) {
                        grid[0][i] = j;
                    }
                }
            }
        }

    }

    private void generateStage2() {

    }

    private void generateStage3() {

    }

}
