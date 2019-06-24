package gameObjects.levelGenerators;

import gameObjects.Bonus;
import gameObjects.Obstacle;
import gameObjects.Road;
import gameObjects.stuff.Bonuses;
import gameObjects.stuff.Constants;
import gameObjects.stuff.Obstacles;

/**
 * @author Vadym Nakytniak
 * Jungle level generator
 */
public class JungleLevel extends LevelGenerator {

    public JungleLevel() {
        super(3, 4);
        stage_y = 200;
    }

    public void initObstacles() {
        super.initObstacles();
        int i = 0;
        //noname
        getObstacles().put(i++, null);//0
        //obstacles
        getObstacles().put(i++, new Obstacle(1f, X, Y, Obstacles.ROAD_BARRIER));//1
        getObstacles().put(i++, new Obstacle(1f, X, Y, Obstacles.WOLF));//2
        getObstacles().put(i++, new Obstacle(1f, X, Y, Obstacles.FALLEN_TREE));//3
        getObstacles().put(i++, new Obstacle(1f, X, Y, Obstacles.HOLE));//4
        getObstacles().put(i++, new Obstacle(1f, X, Y, Obstacles.TRAMPOLINE));//5
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
        none_chance = 40;
        car_chance = 15;
        obstacle_chance = 40;
        getProbability().put(i++, none_chance);//0
        //obstacles
        getProbability().put(i++, 10);//1
        getProbability().put(i++, 20);//2
        getProbability().put(i++, 20);//3
        getProbability().put(i++, 20);//4
        getProbability().put(i++, 30);//5
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
    }

    private void generateStage1() {
        int stage = 0;
        int c = Constants.random.nextInt(101);
        int sum = 0;
        int type = TYPE_NONE;
        if (c <= getProbability().get(getObstacleIdByName("BIG HOLE"))) {
            for (int i = 0; i < grid[0].length; i++) {
                grid[stage][i] = getObstacleIdByName("BIG HOLE");
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
    }


    private void generateStage3() {
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
    }

    public void createCentreRoadObstacle(Road road) {
        Obstacle obstacle = new Obstacle(1f, Road.CENTR, -Road.HEIGHT / 2, Obstacles.HOLE);
        road.getObstacles().add(obstacle);
    }

}
