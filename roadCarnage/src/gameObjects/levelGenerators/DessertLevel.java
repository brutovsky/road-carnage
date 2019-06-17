package gameObjects.levelGenerators;

import gameObjects.*;
import gameObjects.stuff.Bonuses;
import gameObjects.stuff.Cars;
import gameObjects.stuff.Constants;
import gameObjects.stuff.Obstacles;

import java.util.HashMap;

import static gameObjects.stuff.Cars.*;
import static gameObjects.stuff.Obstacles.*;

public class DessertLevel extends LevelGenerator {

    private boolean isDuna;

    private static final float STAGE_Y = 175;
    //private static final float STAGE2_Y = 175*2;
    //private static final float STAGE3_Y = 175;

    DessertLevel() {
        super(3, 4);

    }

    public void initObstacles() {
        int i = 0;
        getObstacles().put(i++, null);
        getObstacles().put(i++, new Obstacle(1f, X, Y, Obstacles.KONUS));
        getObstacles().put(i++, new Obstacle(1f, X, Y, Obstacles.DUNA));
        getObstacles().put(i++, new Obstacle(1f, X, Y, CACTUS));
        getObstacles().put(i++, new Obstacle(1f, X, Y, Obstacles.HOLE));
        getObstacles().put(i++, new Obstacle(1f, X, Y, Obstacles.TRAMPOLINE));
        getObstacles().put(i++, new Car(1f, X, Y, Road.ROAD, Cars.TRUCK));
        getObstacles().put(i++, new Car(1f, X, Y, Road.ROAD, Cars.TAXI));
        getObstacles().put(i++, new Car(1f, X, Y, Road.ROAD, Cars.CASUAL_BLUE));
        getObstacles().put(i++, new Car(1f, X, Y, Road.ROAD, Cars.CASUAL_GREEN));
        getObstacles().put(i++, new Car(1f, X, Y, Road.ROAD, CASUAL_BLACK));
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

    public void createObstacles(Road road){
        for(int i =0; i < grid.length;i++){
            for(int j =0; j < grid[i].length;j++){
                GameObject object = getObstacles().get(grid[i][j]);
                if(object == null){
                }else if(object instanceof Obstacle){
                    switch(((Obstacle)object).getType()){
                        case CACTUS:{
                            road.getObstacles().add(new Obstacle(1f,road.getLineX(j+1),Road.Y-(i+1)*STAGE_Y, CACTUS));
                        }
                        case DUNA:{
                            road.getObstacles().add(new Obstacle(1f,road.getLineX(j+1),Road.Y-(i+1)*STAGE_Y, DUNA));
                        }
                        case HOLE:{
                            road.getObstacles().add(new Obstacle(1f,road.getLineX(j+1),Road.Y-(i+1)*STAGE_Y, HOLE));
                        }
                        case KONUS:{
                            road.getObstacles().add(new Obstacle(1f,road.getLineX(j+1),Road.Y-(i+1)*STAGE_Y, KONUS));
                        }
                        case TRAMPOLINE:{
                            road.getObstacles().add(new Obstacle(1f,road.getLineX(j+1),Road.Y-(i+1)*STAGE_Y, TRAMPOLINE));
                        }
                        default:{
                            System.out.println("NO OBSTACLE");
                        }
                    }
                }else if(object instanceof Car){
                    switch(((Car)object).getType()){
                        case CASUAL_BLACK:{
                            road.getObstacles().add(new Car(1f,road.getLineX(j+1),Road.Y-(i+1)*STAGE_Y, Road.ROAD, CASUAL_BLACK));
                        }
                        case CASUAL_BLUE:{
                            road.getObstacles().add(new Car(1f,road.getLineX(j+1),Road.Y-(i+1)*STAGE_Y, Road.ROAD, CASUAL_BLUE));
                        }
                        case CASUAL_GREEN:{
                            road.getObstacles().add(new Car(1f,road.getLineX(j+1),Road.Y-(i+1)*STAGE_Y, Road.ROAD, CASUAL_GREEN));
                        }
                        case HOTDOG:{
                            road.getObstacles().add(new Car(1f,road.getLineX(j+1),Road.Y-(i+1)*STAGE_Y, Road.ROAD, HOTDOG));
                        }
                        case TAXI:{
                            road.getObstacles().add(new Car(1f,road.getLineX(j+1),Road.Y-(i+1)*STAGE_Y, Road.ROAD, TAXI));
                        }
                        case TRUCK:{
                            road.getObstacles().add(new Car(1f,road.getLineX(j+1),Road.Y-(i+1)*STAGE_Y, Road.ROAD, TRUCK));
                        }
                        default:{
                            System.out.println("NO CAR");
                        }
                    }
                }else if(object instanceof Bonus){
                    switch(((Bonus)object).getType()){
                        case BARRIER:{
                            road.getObstacles().add(new Bonus(1f,road.getLineX(j+1),Road.Y-(i+1)*STAGE_Y,Bonuses.BARRIER));
                        }
                        case CHERRY:{
                            road.getObstacles().add(new Bonus(1f,road.getLineX(j+1),Road.Y-(i+1)*STAGE_Y,Bonuses.CHERRY));
                        }
                        case FAN:{
                            road.getObstacles().add(new Bonus(1f,road.getLineX(j+1),Road.Y-(i+1)*STAGE_Y,Bonuses.FAN));
                        }
                        case FIRE:{
                            road.getObstacles().add(new Bonus(1f,road.getLineX(j+1),Road.Y-(i+1)*STAGE_Y,Bonuses.FIRE));
                        }
                        case ICE:{
                            road.getObstacles().add(new Bonus(1f,road.getLineX(j+1),Road.Y-(i+1)*STAGE_Y,Bonuses.ICE));
                        }
                        case SURPRISE:{
                            road.getObstacles().add(new Bonus(1f,road.getLineX(j+1),Road.Y-(i+1)*STAGE_Y,Bonuses.SURPRISE));
                        }
                        case WRENCH:{
                            road.getObstacles().add(new Bonus(1f,road.getLineX(j+1),Road.Y-(i+1)*STAGE_Y,Bonuses.WRENCH));
                        }
                        default:{
                            System.out.println("NO BONUS");
                        }
                    }
                }
            }
        }
    }

}
