package gameObjects.levelGenerators;

import gameObjects.Bonus;
import gameObjects.Car;
import gameObjects.Obstacle;
import gameObjects.Road;
import gameObjects.stuff.Bonuses;
import gameObjects.stuff.Cars;
import gameObjects.stuff.Constants;
import gameObjects.stuff.Obstacles;

import static gameObjects.stuff.Cars.*;

public class CityLevel extends LevelGenerator {


    public CityLevel() {
        super(4, 4);
        stage_y = 175;
    }

    public void initObstacles() {
        super.initObstacles();
        int i = 0;
        //noname
        getObstacles().put(i++, null);//0
        //obstacles
        getObstacles().put(i++, new Obstacle(1f, X, Y, Obstacles.ROAD_BARRIER));//1
        getObstacles().put(i++, new Obstacle(1f, X, Y, Obstacles.HOLE));//2
        getObstacles().put(i++, new Obstacle(1f, X, Y, Obstacles.TRAMPOLINE));//3
        //cars
        getObstacles().put(i++, new Car(1f, X, Y, Road.ROAD, Cars.TRUCK));
        getObstacles().put(i++, new Car(1f, X, Y, Road.ROAD, Cars.TAXI));
        getObstacles().put(i++, new Car(1f, X, Y, Road.ROAD, Cars.CASUAL_BLUE));
        getObstacles().put(i++, new Car(1f, X, Y, Road.ROAD, Cars.CASUAL_GREEN));
        getObstacles().put(i++, new Car(1f, X, Y, Road.ROAD, CASUAL_BLACK));
        getObstacles().put(i++, new Car(1f, X, Y, Road.ROAD, ICECREAM));
        getObstacles().put(i++, new Car(1f, X, Y, Road.ROAD, HOTDOG));
        getObstacles().put(i++, new Car(1f, X, Y, Road.ROAD, MEGABUS));
        getObstacles().put(i++, new Car(1f, X, Y, Road.ROAD, POLICE));
        getObstacles().put(i++, new Car(1f, X, Y, Road.ROAD, AMBULANCE));
        //bonuses
        getObstacles().put(i++, new Bonus(1f, X, Y, Bonuses.TOMAT));
        getObstacles().put(i++, new Bonus(1f, X, Y, Bonuses.CHERRY));
        getObstacles().put(i++, new Bonus(1f, X, Y, Bonuses.SURPRISE));
        getObstacles().put(i++, new Bonus(1f, X, Y, Bonuses.FIRE));
        getObstacles().put(i++, new Bonus(1f, X, Y, Bonuses.ICE));
        getObstacles().put(i++, new Bonus(1f, X, Y, Bonuses.BARRIER));
        getObstacles().put(i++, new Bonus(1f, X, Y, Bonuses.WRENCH));
        getObstacles().put(i++, new Bonus(1f, X, Y, Bonuses.FAN));

        auxiliaryList = 2;
        getObstacles().put(i++, new Obstacle(1f, X, Y, Obstacles.BIG_HOLE));
        getObstacles().put(i++, new Obstacle(1f, X, Y, Obstacles.CENTRE_HOLE));

    }

    @Override
    public void initProbability() {
        super.initProbability();
        int i = 0;
        bonus_chance = 5;
        none_chance = 0;
        car_chance = 85;
        obstacle_chance = 10;
        getProbability().put(i++, none_chance);//0
        //obstacles
        getProbability().put(i++, 20);//1
        getProbability().put(i++, 40);//2
        getProbability().put(i++, 40);//3
        //cars
        getProbability().put(i++, 5);//4
        getProbability().put(i++, 10);//5
        getProbability().put(i++, 10);//6
        getProbability().put(i++, 10);//7
        getProbability().put(i++, 10);//8

        getProbability().put(i++, 5);//9
        getProbability().put(i++, 5);//10
        getProbability().put(i++, 10);//11
        getProbability().put(i++, 20);//12
        getProbability().put(i++, 15);//13
        //bonuses
        getProbability().put(i++, 30);//11
        getProbability().put(i++, 10);//12
        getProbability().put(i++, 10);//13
        getProbability().put(i++, 10);//14
        getProbability().put(i++, 10);//15
        getProbability().put(i++, 10);//16
        getProbability().put(i++, 10);//17
        getProbability().put(i++, 10);//18
        //aux
        getProbability().put(i++, 20);//BIG HOLE
        getProbability().put(i++, 33);//CENTRE HOLE
    }

    @Override
    public void generate() {
        generateStage1();
        generateStage2();
        generateStage3();
        generateStage4();
    }

    private void generateStage4() {
        int stage = 3;
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
                        if (type == TYPE_BONUSES) {
                            if (checkForId(j)) {
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
    }

    private void generateStage1() {
        int stage = 0;
        int c = Constants.random.nextInt(101);
        int sum = 0;
        int type = TYPE_NONE;
        /*if (c <= getProbability().get(getObstacleIdByName("BIG HOLE"))) {
            for (int i = 0; i < grid[0].length; i++) {
                grid[stage][i] = getObstacleIdByName("BIG HOLE");
            }
            return;
        }*/
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
                        if (type == TYPE_BONUSES) {
                            if (checkForId(j)) {
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
